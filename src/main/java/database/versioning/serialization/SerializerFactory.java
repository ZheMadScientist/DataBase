package database.versioning.serialization;

import database.model.Entity;
import database.model.user.User;
import database.versioning.serialization.serializers.DefaultSerializer;
import database.versioning.serialization.serializers.UserSerializer;

/**
 * Фабрика для получения нужной реализации интерфейса {@link Serializer}
 * @param <T> тип сериализуемого класса
 */
public class SerializerFactory<T extends Entity> {

    /**
     * Метод, возвращающий нужную реализацию интерфейса {@link Serializer}
     * @param c класс объекта, который нужно сериализовать
     * @return корректная реализация интерфейса {@link Serializer}
     */
    public Serializer getSerializer(Class<T> c){
        Serializer serializer;

        if(c == User.class) {
            serializer = new UserSerializer();

        } else {
            serializer = new DefaultSerializer<>(c);
        }

        return serializer;
    }
}
