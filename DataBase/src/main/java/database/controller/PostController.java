package database.controller;

import database.model.course.Course;
import database.model.stat.log.CourseLog;
import database.model.stat.log.UserLog;
import database.model.storage.Content;
import database.model.storage.Material;
import database.model.storage.Task;
import database.model.user.User;
import database.versioning.VController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.Map;

/**
 * Контроллер, отвечающий на post запросы
 */
@CrossOrigin
@Transactional
@RestController
@RequestMapping(value = "/persist")
public class PostController {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    VController versionController = new VController();

    @Autowired
    ErrorAttributes errorAttributes;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/material", method = RequestMethod.POST)
    public Material insertMaterial(@RequestBody Material material) {

        Material instance = em.find(Material.class, material.GUID);

        Material newInstance = new Material(material);

        if (instance != null) {
            if(instance.version.equals(material.version))
                throw new IllegalArgumentException("Version already exists");

            newInstance.GUID = material.GUID;

            versionController.createDump(newInstance, instance, Material.class, em);

            em.merge(newInstance.content);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.content);
            em.persist(newInstance);
        }
        em.flush();

        return newInstance;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public Task insertTask(@RequestBody Task task) {

        Task instance = em.find(Task.class, task.GUID);

        Task newInstance = new Task(task);

        if (instance != null) {
            if(instance.version.equals(task.version))
                throw new IllegalArgumentException("Version already exists");

            newInstance.GUID = task.GUID;

            versionController.createDump(newInstance, instance, Task.class, em);

            em.merge(newInstance.material.content);
            em.merge(newInstance.material);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.material.content);
            em.persist(newInstance.material);
            em.persist(newInstance);
        }
        em.flush();

        return newInstance;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/content", method = RequestMethod.POST)
    public Content insertContent(@RequestBody Content content) {

        Content instance = em.find(Content.class, content.GUID);

        Content newInstance = new Content(content);

        if (instance != null) {
            if(instance.version.equals(content.version))
                throw new IllegalArgumentException("Version already exists");

            newInstance.GUID = content.GUID;

            versionController.createDump(newInstance, instance, Content.class, em);

            em.merge(newInstance);
        } else {
            em.persist(newInstance);
        }
        em.flush();

        return newInstance;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User insertUser(@RequestBody User user) {

        User instance = em.find(User.class, user.GUID);

        User newInstance = new User(user);

        if (instance != null) {
            if(instance.version.equals(user.version))
                throw new IllegalArgumentException("Version already exists");

            newInstance.GUID = user.GUID;

            versionController.createDump(newInstance, instance, User.class, em);

            em.merge(newInstance.userLog);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.userLog);
            em.persist(newInstance);
        }
        em.flush();

        return newInstance;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/userLog", method = RequestMethod.POST)
    public UserLog insertUserLog(@RequestBody UserLog userLog) {

        UserLog instance = em.find(UserLog.class, userLog.GUID);

        UserLog newInstance = new UserLog(userLog);

        if (instance != null) {
            if(instance.version.equals(userLog.version))
                throw new IllegalArgumentException("Version already exists");

            newInstance.GUID = userLog.GUID;

            versionController.createDump(newInstance, instance, UserLog.class, em);

            em.merge(newInstance);
        } else {
            em.persist(newInstance);
        }
        em.flush();

        return newInstance;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public Course insertCourse(@RequestBody Course course) {

        Course instance = em.find(Course.class, course.GUID);

        Course newInstance = new Course(course);

        if (instance != null) {
            if(instance.version.equals(course.version))
                throw new IllegalArgumentException("Version already exists");

            newInstance.GUID = course.GUID;

            versionController.createDump(newInstance, instance, Course.class, em);

            em.merge(newInstance.courseState);
            em.merge(newInstance.courseLog);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.courseState);
            em.persist(newInstance.courseLog);
            em.persist(newInstance);
        }
        em.flush();

        return newInstance;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/courseLog", method = RequestMethod.POST)
    public CourseLog insertCourseLog(@RequestBody CourseLog courseLog) {

        CourseLog instance = em.find(CourseLog.class, courseLog.GUID);

        CourseLog newInstance = new CourseLog(courseLog);

        if (instance != null) {
            if(instance.version.equals(courseLog.version))
                throw new IllegalArgumentException("Version already exists");

            newInstance.GUID = courseLog.GUID;

            versionController.createDump(newInstance, instance, CourseLog.class, em);

            em.merge(newInstance.logs);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.logs);
            em.persist(newInstance);
        }
        em.flush();

        return newInstance;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Map<String, Object> handleIllegalArgumentException(IllegalArgumentException e, WebRequest request) {
        return errorAttributes.getErrorAttributes(request, false);
    }

}
