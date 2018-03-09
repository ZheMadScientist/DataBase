package wrapper.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wrapper.model.Entity;
import wrapper.model.course.Course;
import wrapper.model.stat.log.CourseLog;
import wrapper.model.stat.log.UserLog;
import wrapper.model.storage.Material;
import wrapper.model.storage.Task;
import wrapper.model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@RestController
public class DBRestController {

    @PersistenceContext
    private EntityManager em;

    // CONTENT

    @CrossOrigin
    @RequestMapping("/material")
    public Material material(@RequestParam(value="material_id", required = true, defaultValue = "0") long material_id) {
        //return new Material(MaterialType.URL, name, "", new Content(ContentType.URL));
        return em.find(Material.class, material_id);
    }

    @CrossOrigin
    @RequestMapping("/task")
    public Task task (@RequestParam(value="name", required = false, defaultValue = "1") String name) {
        //return new Material(MaterialType.URL, name, "", new Content(ContentType.URL));
        return null;
    }

    // END OF CONTENT


    // USERS

    @CrossOrigin
    @RequestMapping("/user")
    public User user (@RequestParam(value="guid", required = true, defaultValue = "1") long guid) {
        return em.find(User.class, guid);
    }

    @CrossOrigin
    @RequestMapping("/userLog")
    public UserLog userLog (@RequestParam(value="name", required = false, defaultValue = "1") String name) {
        return null;
    }

    // END OF USERS

    // COURSE

    @CrossOrigin
    @RequestMapping("/course")
    public Course course (@RequestParam(value="name", required = false, defaultValue = "1") String name) {
        return null;
    }

    @CrossOrigin
    @RequestMapping("/courseLog")
    public CourseLog courseLog (@RequestParam(value="name", required = false, defaultValue = "1") String name) {
        return null;
    }

    // END OF COURSE

    @CrossOrigin
    @RequestMapping("/getEntityByGUID")
    public Entity entity (@RequestParam(value="guid", required = true, defaultValue = "0") long guid) {
        //return new Material(MaterialType.URL, name, "", new Content(ContentType.URL));
        return em.find(Entity.class, guid);
    }
}
