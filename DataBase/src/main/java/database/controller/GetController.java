package database.controller;


import database.model.course.Course;
import database.model.stat.log.CourseLog;
import database.model.stat.log.UserLog;
import database.model.step.AssigmentStep;
import database.model.step.Step;
import database.model.step.TestStep;
import database.model.storage.Material;
import database.model.storage.Task;
import database.model.user.User;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class GetController {

    @PersistenceContext
    private EntityManager em;

    /**
     * CONTENT
     */

    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public Material material(@RequestParam(value="id", required = true, defaultValue = "0") long id) {
        return em.find(Material.class, id);
    }

    @RequestMapping(value = "/task", method = RequestMethod.GET )
    public Task task (@RequestParam(value="id", required = true, defaultValue = "1") long id) {
        return em.find(Task.class, id);
    }

    /**
     * EOF CONTENT
     */

    /**
     * USERS
     */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User user (@RequestParam(value="id", required = true, defaultValue = "1") long id) {
        return em.find(User.class, id);
    }

    @RequestMapping(value = "/userLog", method = RequestMethod.GET)
    public UserLog userLog (@RequestParam(value="id", required = false, defaultValue = "1") long id) {
        return em.find(UserLog.class, id);
    }

    /**
     * EOF USERS
     */

    /**
     * COURSE
     */

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public Course course (@RequestParam(value="id", required = false, defaultValue = "1") long id) {
        return em.find(Course.class, id);
    }

    @RequestMapping(value = "/courseLog", method = RequestMethod.GET)
    public CourseLog courseLog (@RequestParam(value="id", required = false, defaultValue = "1") long id) {
        return em.find(CourseLog.class, id);
    }

    /**
     * EOF COURSE
     */

    /**
     * STEPS
     */

    @RequestMapping(value = "/step", method = RequestMethod.GET)
    public Step step (@RequestParam(value="id", required = false, defaultValue = "1") long id) {
        return em.find(Step.class, id);
    }

    @RequestMapping(value = "/testStep", method = RequestMethod.GET)
    public TestStep testStep (@RequestParam(value="id", required = false, defaultValue = "1") long id) {
        return em.find(TestStep.class, id);
    }

    @RequestMapping(value = "/assigmentStep", method = RequestMethod.GET)
    public AssigmentStep assigmentStep (@RequestParam(value="id", required = false, defaultValue = "1") long id) {
        return em.find(AssigmentStep.class, id);
    }

    /**
     * EOF STEPS
     */
}
