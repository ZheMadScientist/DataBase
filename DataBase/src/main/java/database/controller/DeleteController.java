package database.controller;

import database.model.course.Course;
import database.model.stat.log.CourseLog;
import database.model.stat.log.UserLog;
import database.model.storage.Content;
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

/**
 * Контроллер, отвечающий на delete запросы
 */
@CrossOrigin
@Transactional
@RestController
@RequestMapping(value = "/delete")
public class DeleteController {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    VController versionController = new VController();

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/material", method = RequestMethod.DELETE)
    public void material (@RequestParam(value="id", required = true, defaultValue = "0") long id,
                          @RequestParam(value="delete_all_versions", required = false, defaultValue = "false") boolean delete_all_versions) {

        Material instance = em.find(Material.class, id);

        if(instance != null) {
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/task", method = RequestMethod.DELETE)
    public void task (@RequestParam(value="id", required = true, defaultValue = "0") long id,
                      @RequestParam(value="delete_all_versions", required = false, defaultValue = "false") boolean delete_all_versions) {

        Task instance = em.find(Task.class, id);

        if(instance != null){
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/content", method = RequestMethod.DELETE)
    public void content (@RequestParam(value="id", required = true, defaultValue = "0") long id,
                      @RequestParam(value="delete_all_versions", required = false, defaultValue = "false") boolean delete_all_versions) {

        Content instance = em.find(Content.class, id);

        if(instance != null){
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void user (@RequestParam(value="id", required = true, defaultValue = "0") long id,
                      @RequestParam(value="delete_all_versions", required = false, defaultValue = "false") boolean delete_all_versions) {

        User instance = em.find(User.class, id);

        if(instance != null){
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/userLog", method = RequestMethod.DELETE)
    public void userLog(@RequestParam(value="id", required = true, defaultValue = "0") long id,
                        @RequestParam(value="delete_all_versions", required = false, defaultValue = "false") boolean delete_all_versions) {

        UserLog instance = em.find(UserLog.class, id);
        
        if (instance != null){
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }
        
        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/course", method = RequestMethod.DELETE)
    public void course(@RequestParam(value="id", required = true, defaultValue = "0") long id,
                       @RequestParam(value="delete_all_versions", required = false, defaultValue = "false") boolean delete_all_versions) {

        Course instance = em.find(Course.class, id);
        
        if (instance != null){
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/courseLog", method = RequestMethod.DELETE)
    public void courseLog(@RequestParam(value="id", required = true, defaultValue = "0") long id,
                          @RequestParam(value="delete_all_versions", required = false, defaultValue = "false") boolean delete_all_versions) {

        CourseLog instance = em.find(CourseLog.class, id);
        
        if (instance != null){
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }

        em.flush();
    }


    
}
