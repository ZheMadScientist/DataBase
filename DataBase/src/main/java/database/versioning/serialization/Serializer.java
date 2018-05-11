package database.versioning.serialization;

import javax.persistence.EntityManager;

public interface Serializer<T> {

    String serialize(T src);

    T deserialize(String src, EntityManager em);

}
