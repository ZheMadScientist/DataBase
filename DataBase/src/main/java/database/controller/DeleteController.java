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
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@CrossOrigin
@Transactional
@RestController
@RequestMapping(value = "/delete")
public class DeleteController {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/material", method = RequestMethod.DELETE)
    public void material (@RequestBody Material material) {

        Material instance = em.find(Material.class, material.GUID);

        if(instance != null)
            em.remove(instance);

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/task", method = RequestMethod.DELETE)
    public void task (@RequestBody Task task) {

        Task instance = em.find(Task.class, task.GUID);

        if(instance != null)
            em.remove(instance);

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void user (@RequestBody User user) {

        User instance = em.find(User.class, user.GUID);

        if(instance != null)
            em.remove(instance);

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/userLog", method = RequestMethod.DELETE)
    public void userLog(@RequestBody UserLog userLog) {

        UserLog instance = em.find(UserLog.class, userLog.GUID);
        
        if (instance != null)
            em.remove(instance);
        
        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/course", method = RequestMethod.DELETE)
    public void course(@RequestBody Course course) {

        Course instance = em.find(Course.class, course.GUID);
        
        if (instance != null)
            em.remove(instance);

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/courseLog", method = RequestMethod.DELETE)
    public void courseLog(@RequestBody CourseLog courseLog) {

        CourseLog instance = em.find(CourseLog.class, courseLog.GUID);
        
        if (instance != null)
            em.remove(instance);

        em.flush();
    }


    
}
