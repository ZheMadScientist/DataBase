package database.versioning;

import database.model.Entity;
import database.model.storage.AIDS.GuidStorage;
import database.versioning.model.TokensWrapper;
import database.versioning.serialization.Serializer;
import database.versioning.serialization.SerializerFactory;
import database.versioning.tools.VersioningUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.Comparator;
import java.util.List;

public class VController {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;


    public <T extends Entity> void createDump (T newInstance, Class<T> c){

        T old = em.find(c, newInstance.GUID);

        createDump(newInstance, old, c);
    }

    public <T extends Entity> void createDump (T newInstance, T old, Class<T> c){

        if(!GuidStorage.getInstance().contains(newInstance.GUID) || old == null)
            return;

        Serializer serializer = new SerializerFactory().getSerializer(c);

        String oldJSON = serializer.serialize(old);
        String newJSON = serializer.serialize(newInstance);

        TokensWrapper tokensWrapper = VersioningUtils.getTokensWrapper(newJSON, oldJSON);

        Versions dump = new Versions(old.GUID, tokensWrapper, old.version, old.date);

        em.persist(dump);
        em.flush();
    }


    public <T extends Entity> T getOlder (T latest, Class<T> c, String version) {
        // seems wrong
        List<Versions> versions = em.createQuery("SELECT t FROM versions t where t.entity_id = :id")
                .setParameter("id", latest.GUID)
                .getResultList();

        versions.sort(Comparator.comparing(obj -> obj.date));

        int depth = 0;
        for(int i = 0; i < versions.size(); ++i){
            if(versions.get(i).version.equals(version)){
                depth = i;
                break;
            }
        }

        SerializerFactory<T> serializerFactory = new SerializerFactory<>();

        Serializer<T> serializer = serializerFactory.getSerializer(c);

        String tmp = serializer.serialize(latest);

        for(int i = 0; i < depth; ++i)
            tmp = VersioningUtils.recoverFromWrapper(tmp.split(";"), versions.get(i).tokensWrapper);

        T res = serializer.deserialize(tmp, em);

        res.GUID = versions.get(depth - 1).GUID;
        res.date = versions.get(depth - 1).date;

        return res;
    }

    public void deleteDumps(long entity_id){
        em.createQuery("delete from ChildEntity c where c.entity_id = :id")
                .setParameter("id", entity_id)
                .executeUpdate();
    }

}
