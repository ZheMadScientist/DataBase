package database.controller;

import database.model.course.Course;
import database.model.stat.log.CourseLog;
import database.model.stat.log.UserLog;
import database.model.step.AssigmentStep;
import database.model.step.Step;
import database.model.step.TestStep;
import database.model.storage.Content;
import database.model.storage.Material;
import database.model.storage.Task;
import database.model.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Контроллер, отвечающий на put запросы
 */
@CrossOrigin
@Transactional
@RestController
@RequestMapping(value = "/put")
public class PutController {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/material", method = RequestMethod.PUT)
    public Material putMaterial(@RequestBody Material material) {

        material = new Material(material);

        Material instance = em.find(Material.class, material.GUID);

        if (instance != null)
            em.remove(instance);

        em.persist(material);

        em.flush();

        return material;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/task", method = RequestMethod.PUT)
    public Task putTask(@RequestBody Task task) {

        task = new Task(task);

        Task instance = em.find(Task.class, task.GUID);

        if (instance != null)
            em.remove(instance);

        em.persist(task);

        em.flush();

        return task;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/content", method = RequestMethod.PUT)
    public Content putContent(@RequestBody Content content) {

        content = new Content(content);

        Content instance = em.find(Content.class, content.GUID);

        if (instance != null)
            em.remove(instance);

        em.persist(content);

        em.flush();

        return content;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User putUser(@RequestBody User user) {

        user = new User(user);

        User instance = em.find(User.class, user.GUID);

        if (instance != null)
            em.remove(instance);

        em.persist(user.versionDescription);
        em.persist(user);

        em.flush();

        return user;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/userLog", method = RequestMethod.PUT)
    public UserLog insertUserLog(@RequestBody UserLog userLog) {

        UserLog instance = em.find(UserLog.class, userLog.GUID);

        userLog = new UserLog(userLog);

        if (instance != null)
            em.remove(instance);

        em.persist(userLog.versionDescription);
        em.persist(userLog);

        em.flush();

        return userLog;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/course", method = RequestMethod.PUT)
    public Course insertCourse(@RequestBody Course course) {

        Course instance = em.find(Course.class, course.GUID);

        course = new Course(course);

        if (instance != null)
            em.remove(instance);

        em.persist(course.courseState);
        em.persist(course.courseLog);
        em.persist(course.versionDescription);
        em.persist(course);

        em.flush();

        return course;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/courseLog", method = RequestMethod.PUT)
    public CourseLog insertCourseLog(@RequestBody CourseLog courseLog) {

        CourseLog instance = em.find(CourseLog.class, courseLog.GUID);

        courseLog = new CourseLog(courseLog);

        if (instance != null)
            em.remove(instance);

        em.persist(courseLog.logs);
        em.persist(courseLog.versionDescription);
        em.persist(courseLog);

        em.flush();

        return courseLog;
    }


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/step", method = RequestMethod.PUT)
    public Step putStep(@RequestBody Step step) {

        Step newInstance = new Step(step);

        em.persist(newInstance.interventions);
        em.persist(newInstance.module);
        em.persist(newInstance.versionDescription);
        em.persist(newInstance);

        em.flush();

        return newInstance;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/testStep", method = RequestMethod.PUT)
    public TestStep putTestStep(@RequestBody TestStep testStep) {


        TestStep newInstance = new TestStep(testStep);

        em.persist(newInstance.keys);
        em.persist(newInstance);

        em.flush();

        return newInstance;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/assigmentStep", method = RequestMethod.PUT)
    public AssigmentStep putAssigmentStep(@RequestBody AssigmentStep assigmentStep) {


        AssigmentStep newInstance = new AssigmentStep(assigmentStep);

        em.persist(newInstance.tasks);
        em.persist(newInstance);

        em.flush();

        return newInstance;
    }

}
