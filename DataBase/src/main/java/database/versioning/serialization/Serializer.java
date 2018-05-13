package database.versioning.serialization;

import database.model.Entity;

import javax.persistence.EntityManager;

/**
 * Интерфейс для сериализации и десериализации объектов в JSON.
 * Реализации интерфейса используют библиотеку Gson
 * @param <T> класс, унследованный от Entity
 */
public interface Serializer <T extends Entity> {

    /**
     * Метод, сериализующий объект в строку формата JSON
     * @param src объект, наследник {@link Entity}
     * @return строка в формате JSON
     */
    String serialize(T src);

    /**
     * Метод, преобразующий строку в формате JSON в объект
     * @param src объект, наследник {@link Entity}
     * @param em {@link EntityManager}, ипользующийся для получения несериализованных вложенных объектов
     * @return {@link T} десериализованный объект
     */
    T deserialize(String src, EntityManager em);

}
