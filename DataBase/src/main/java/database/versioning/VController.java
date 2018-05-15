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

/**
 * Класс, предоставляющий функциональность создания,<br> получения и удаления версий объектов
 */
public class VController {

    /**
     * @deprecated
     * Метод, сохраняющий предыдущую версию объекта, если она присутствует в БД
     * @param newInstance обновленный объект
     * @param c класс объекта
     * @param <T> тип объекта, наследник класса {@link Entity}
     */
    public <T extends Entity> void createDump (T newInstance, Class<T> c, EntityManager em){

        T old = em.find(c, newInstance.GUID);

        createDump(newInstance, old, c, em);
    }

    /**
     * Метод, сохраняющий предыдущую версию объекта
     * @param newInstance обновленный объект
     * @param old текущий (устаревший) объект
     * @param c класс объектов
     * @param <T> тип объектов, наследуется от {@link Entity}
     */
    public <T extends Entity> void createDump (T newInstance, T old, Class<T> c, EntityManager em){

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


    /**
     * Метод для восстановления предыдущего состояния обекта по версии {@code version}
     * @param latest "самый новый" объект
     * @param c класс объекта
     * @param version версия объекта, которую необходимо восстановить
     * @param <T> тип объекта
     * @return восстановленный до требуемой версии объект
     */
    public <T extends Entity> T getOlder (T latest, Class<T> c, String version, EntityManager em) {
        // seems wrong
        List<Versions> versions = em.createQuery("SELECT t FROM Versions t where t.entity_id = :id")
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

        if(depth > 0) {
            res.GUID = versions.get(depth - 1).GUID;
            res.date = versions.get(depth - 1).date;
        }

        return res;
    }

    /**
     * Метод удаления всех сохраненных состояний объекта
     * @param entity_id GUID объекта
     * @param em EntityManager для работы с бд
     */
    public void deleteDumps(long entity_id, EntityManager em){
        em.createQuery("delete from Versions c where c.entity_id = :id")
                .setParameter("id", entity_id)
                .executeUpdate();
    }

    /**
     * Метод удаления определенного дампа по версии
     * @param entity_id GUID объекта
     * @param version нужная версия
     * @param em EntityManager для работы с бд
     */
    public void deleteDumpByVersion(long entity_id, String version, EntityManager em){
        em.createQuery("delete from Versions c where c.entity_id = :id and c.version = :version")
                .setParameter("id", entity_id)
                .setParameter("version", version)
                .executeUpdate();
    }

}
