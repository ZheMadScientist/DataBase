package database.versioning.serialization.serializers;

import com.google.gson.Gson;
import database.versioning.serialization.Serializer;

import javax.persistence.EntityManager;

public class DefaultSerializer<T> implements Serializer<T> {

    Class<T> c;

    public DefaultSerializer (Class<T> c) {
        this.c = c;
    }

    @Override
    public String serialize(T src) {
        Gson gson = new Gson();
        return gson.toJson(src);
    }

    @Override
    public T deserialize(String src, EntityManager em) {
        Gson gson = new Gson();
        return gson.fromJson(src, c);
    }

}
