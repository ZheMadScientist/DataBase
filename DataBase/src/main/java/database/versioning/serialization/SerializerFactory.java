package database.versioning.serialization;

import database.model.course.Course;
import database.model.storage.Content;
import database.model.storage.Material;
import database.model.storage.Task;
import database.model.user.User;
import database.versioning.serialization.serializers.*;

public class SerializerFactory<T> {

    public Serializer getSerializer(Class<T> c){
        Serializer serializer = null;

        if(c == Material.class){
            serializer = new MaterialSerializer();

        } else if(c == Content.class) {
            serializer = new ContentSerializer();

        } else if(c == Task.class){
            serializer = new TaskSerializer();

        } else if(c == User.class) {
            serializer = new UserSerializer();

        } else if(c == Course.class) {
            serializer = new CourseSerializer();

        } else {
            serializer = new DefaultSerializer<>(c);
        }

        return serializer;
    }
}
