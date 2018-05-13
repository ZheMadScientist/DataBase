package database.versioning.serialization.serializers;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import database.model.Entity;
import database.model.course.Course;
import database.model.course.CourseState;
import database.model.stat.log.CourseLog;
import database.model.user.User;
import database.versioning.serialization.Constants;
import database.versioning.serialization.Serializer;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * Реализация интерфейса {@link Serializer}
 * для сериализации класса {@link Course}
 * */
public class CourseSerializer implements Serializer <Course> {

    /**
     * @see Serializer#serialize(Entity)
     */
    @Override
    public String serialize(Course src) {
        StringWriter sw = new StringWriter();
        JsonWriter writer = new JsonWriter(sw);

        try {
            writer.beginObject();

            writer.name(Constants.VERSION).value(src.version);
            writer.name(Constants.VERSION_DESCRIPTION_ID).value(src.versionDescription.version_description_id);
            writer.name(Constants.VERSION_DESCRIPTION).value(src.versionDescription.description);

            writer.name(Constants.NAME).value(src.courseName);
            writer.name(Constants.DESCRIPTION).value(src.courseDescription);

            writer.beginObject();

            writer.name(Constants.INNER_VERSION).value(src.courseState.version);
            writer.name(Constants.INNER_VERSION_DESCRIPTION_ID).value(src.courseState.versionDescription.version_description_id);
            writer.name(Constants.INNER_VERSION_DESCRIPTION).value(src.courseState.versionDescription.description);

            writer.name(Constants.INNER_ENTITY_ID).value(src.courseState.GUID);

            writer.name(Constants.INNER_NAME).value(src.courseState.groupName);

            writer.name(Constants.ARRAY);

            writer.beginArray();

            for(User student : src.courseState.students)
                writer.value(student.GUID);

            writer.endArray();

            writer.endObject();

            writer.name(Constants.COURSE_LOG_ID).value(src.courseLog.GUID);

            writer.endObject();

        } catch (IOException e) {}

        return sw.toString();
    }

    /**
     * @see Serializer#deserialize(String, EntityManager)
     */
    @Override
    public Course deserialize(String src, EntityManager em) {
        Course course = new Course();
        course.courseState = new CourseState();
        course.courseLog = new CourseLog();

        JsonReader reader = new JsonReader(new StringReader(src));

        try {
            reader.beginObject();

            while (reader.hasNext()) {
                String name = reader.nextName();

                if (name.equals(Constants.VERSION)) {
                    course.version = reader.nextString();

                } else if (name.equals(Constants.VERSION_DESCRIPTION_ID)) {
                    course.versionDescription.version_description_id = reader.nextLong();

                } else if (name.equals(Constants.VERSION_DESCRIPTION)) {
                    course.versionDescription.description = reader.nextString();

                } else if (name.equals(Constants.NAME)) {
                    course.courseName = reader.nextString();

                } else if (name.equals(Constants.DESCRIPTION)) {
                    course.courseDescription = reader.nextString();

                } else if (name.equals(Constants.INNER_VERSION)) {
                    reader.beginObject();
                    course.courseState.version = reader.nextString();

                } else if (name.equals(Constants.INNER_VERSION_DESCRIPTION_ID)) {
                    course.courseState.versionDescription.version_description_id = reader.nextLong();

                } else if (name.equals(Constants.INNER_VERSION_DESCRIPTION)) {
                    course.courseState.versionDescription.description = reader.nextString();

                } else if (name.equals(Constants.INNER_ENTITY_ID)) {
                    course.courseState.GUID = reader.nextLong();

                } else if (name.equals(Constants.INNER_NAME)) {
                    course.courseState.groupName = reader.nextString();
                    reader.endObject();

                } else if(name.equals(Constants.ARRAY)) {
                    course.courseState.students = new ArrayList<>();
                    while (reader.hasNext()) {
                        long guid = reader.nextLong();
                        course.courseState.students.add(em.find(User.class, guid));
                    }

                } else if(name.equals(Constants.COURSE_LOG_ID)) {
                    long guid = reader.nextLong();
                    course.courseLog = em.find(CourseLog.class, guid);

                } else {
                    reader.skipValue();
                }
            }

            reader.endObject();
            reader.close();

        } catch (IOException e) { }

        course.courseState.course = course;
        
        return course;
    }
}
