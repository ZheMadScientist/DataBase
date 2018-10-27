package database.controller;


import database.model.course.Course;
import database.model.stat.log.CourseLog;
import database.model.stat.log.UserLog;
import database.model.step.AssigmentStep;
import database.model.step.Step;
import database.model.step.TestStep;
import database.model.storage.Content;
import database.model.storage.Material;
import database.model.storage.Review;
import database.model.storage.Task;
import database.model.tagging.Tags;
import database.model.user.User;
import database.versioning.VController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Date;

/**
 * Контроллер, отвечающий на get запросы
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class GetController {

    @PersistenceContext
    private EntityManager em;

    private VController versionController = new VController();

    /*
     * CONTENT
     */

    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public Material material(@RequestParam(value="id", required = true, defaultValue = "0") long id,
                             @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(Material.class, id), Material.class, version, em);

        return em.find(Material.class, id);
    }

    @RequestMapping(value = "/task", method = RequestMethod.GET )
    public Task task (@RequestParam(value="id", required = true, defaultValue = "1") long id,
                      @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(Task.class, id), Task.class, version, em);

        return em.find(Task.class, id);
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET )
    public Content content (@RequestParam(value="id", required = true, defaultValue = "1") long id,
                         @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(Content.class, id), Content.class, version, em);

        return em.find(Content.class, id);
    }

    /*
     * EOF CONTENT
     */

    /*
     * USERS
     */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User user (@RequestParam(value="id", required = true, defaultValue = "1") long id,
                      @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(User.class, id), User.class, version, em);

        return em.find(User.class, id);
    }

    @RequestMapping(value = "/default_user", method = RequestMethod.GET)
    public User getDefaultuser () {

        User user = new User();

        user.age = 22;
        user.gender = "ZH";
        user.lastName = "Andreeva";
        user.middleName = "";
        user.name = "Varya";

        return user;
    }

    @RequestMapping(value = "/userLog", method = RequestMethod.GET)
    public UserLog userLog (@RequestParam(value="id", defaultValue = "1") long id,
                            @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(UserLog.class, id), UserLog.class, version, em);

        return em.find(UserLog.class, id);
    }

    /*
     * EOF USERS
     */

    /*
     * COURSE
     */

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public Course course (@RequestParam(value="id", defaultValue = "1") long id,
                          @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(Course.class, id), Course.class, version, em);

        return em.find(Course.class, id);
    }

    @RequestMapping(value = "/courseLog", method = RequestMethod.GET)
    public CourseLog courseLog (@RequestParam(value="id", defaultValue = "1") long id,
                                @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(CourseLog.class, id), CourseLog.class, version, em);

        return em.find(CourseLog.class, id);
    }

    /*
     * EOF COURSE
     */

    /*
     * STEPS
     */

    @RequestMapping(value = "/step", method = RequestMethod.GET)
    public Step step (@RequestParam(value="id", defaultValue = "1") long id,
                      @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(Step.class, id), Step.class, version, em);

        return em.find(Step.class, id);
    }

    @RequestMapping(value = "/testStep", method = RequestMethod.GET)
    public TestStep testStep (@RequestParam(value="id", defaultValue = "1") long id,
                              @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(TestStep.class, id), TestStep.class, version, em);

        return em.find(TestStep.class, id);
    }

    @RequestMapping(value = "/assigmentStep", method = RequestMethod.GET)
    public AssigmentStep assigmentStep (@RequestParam(value="id", defaultValue = "1") long id,
                                        @RequestParam(value="version", required = false, defaultValue = "") String version) {

        if(!version.equals(""))
            return versionController.getOlder(em.find(AssigmentStep.class, id), AssigmentStep.class, version, em);

        return em.find(AssigmentStep.class, id);
    }

    /*
     * EOF STEPS
     */

    /*
     * REVIEWS
     */

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public Review review (User user,
                          Tags tags,
                          @RequestParam(value = "from", required = false) @DateTimeFormat(pattern="dd.MM.yyyy") LocalDate fromDate,
                          @RequestParam(value = "to", required = false) @DateTimeFormat(pattern="dd.MM.yyyy") LocalDate toDate,
                          @RequestParam(value="version", required = false, defaultValue = "") String version) {

        String query = "from Review ";

        if(fromDate != null || toDate != null) {

            if(fromDate == null)
                fromDate = LocalDate.MIN;

            if(toDate == null)
                toDate = LocalDate.MAX;

            query += "where (date > fromDate and date < toDate";
        }

        

        em.createQuery(query);

        return new Review();
    }

    /*
     * EOF REVIEWS
     */
}
