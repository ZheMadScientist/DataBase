package database.controller;

import database.model.storage.Content;
import database.model.storage.Material;
import database.model.storage.Review;
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
                          @RequestParam(value="delete_all_versions", required = false, defaultValue = "true") boolean delete_all_versions) {

        Material instance = em.find(Material.class, id);

        if(instance != null) {
            em.remove(instance.content);
            em.remove(instance.tags);
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/review", method = RequestMethod.DELETE)
    public void review (@RequestParam(value="id", required = true, defaultValue = "0") long id,
                        @RequestParam(value="delete_all_versions", required = false, defaultValue = "true") boolean delete_all_versions) {

        Review instance = em.find(Review.class, id);

        if(instance != null) {
            em.remove(instance.user);
            em.remove(instance.content);
            em.remove(instance.tags);
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }

        em.flush();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/content", method = RequestMethod.DELETE)
    public void content (@RequestParam(value="id", required = true, defaultValue = "0") long id,
                      @RequestParam(value="delete_all_versions", required = false, defaultValue = "true") boolean delete_all_versions) {

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
                      @RequestParam(value="delete_all_versions", required = false, defaultValue = "true") boolean delete_all_versions) {

        User instance = em.find(User.class, id);

        if(instance != null){
            em.remove(instance);

            if(delete_all_versions)
                versionController.deleteDumps(id, em);
        }

        em.flush();
    }

}
