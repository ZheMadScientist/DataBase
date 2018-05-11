package database.controller;

import database.model.course.Course;
import database.model.stat.log.CourseLog;
import database.model.stat.log.UserLog;
import database.model.storage.Material;
import database.model.storage.Task;
import database.model.user.User;
import database.versioning.VController;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@CrossOrigin
@Transactional
@RestController
@RequestMapping(value = "/persist")
public class PostController {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    VController versionController = new VController();

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/material", method = RequestMethod.POST)
    public Material insertMaterial(@RequestBody Material material) {

        Material instance = em.find(Material.class, material.GUID);

        Material newInstance = new Material(material);

        if (instance != null) {
            newInstance.GUID = material.GUID;

            versionController.createDump(newInstance, Material.class);

            em.persist(newInstance.content.versionDescription);
            em.persist(newInstance.versionDescription);
            em.merge(newInstance.content);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.content.versionDescription);
            em.persist(newInstance.content);
            em.persist(newInstance.versionDescription);
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
            newInstance.GUID = task.GUID;

            versionController.createDump(newInstance, Task.class);

            em.merge(newInstance.material.content);
            em.merge(newInstance.material);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.material.content.versionDescription);
            em.persist(newInstance.material.versionDescription);
            em.persist(newInstance.material.content);
            em.persist(newInstance.material);
            em.persist(newInstance.versionDescription);
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
            newInstance.GUID = user.GUID;

            versionController.createDump(newInstance, User.class);

            em.merge(newInstance.userLog);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.userLog);
            em.persist(newInstance.versionDescription);
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
            newInstance.GUID = userLog.GUID;

            versionController.createDump(newInstance, UserLog.class);

            em.merge(newInstance);
        } else {
            em.persist(newInstance.versionDescription);
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
            newInstance.GUID = course.GUID;

            versionController.createDump(newInstance, Course.class);

            em.merge(newInstance.courseState);
            em.merge(newInstance.courseLog);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.courseState);
            em.persist(newInstance.courseLog);
            em.persist(newInstance.versionDescription);
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
            newInstance.GUID = courseLog.GUID;

            versionController.createDump(newInstance, CourseLog.class);

            em.merge(newInstance.logs);
            em.merge(newInstance);
        } else {
            em.persist(newInstance.logs);
            em.persist(newInstance.versionDescription);
            em.persist(newInstance);
        }
        em.flush();

        return newInstance;
    }


}
