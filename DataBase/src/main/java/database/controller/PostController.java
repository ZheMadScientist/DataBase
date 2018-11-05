package database.controller;

import database.model.course.Course;
import database.model.stat.log.CourseLog;
import database.model.stat.log.UserLog;
import database.model.storage.Content;
import database.model.storage.Material;
import database.model.storage.Review;
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

    /**
     * Метод для добавления нового материала в бд
     * @param material
     */
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/material", method = RequestMethod.POST)
    public void insertMaterial(@RequestBody Material material) {

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
    }


    /**
     * Метод для добавления нового отзыва в бд
     * @param review
     */

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public void insertReview(@RequestBody Review review) {

        Review instance = em.find(Review.class, review.GUID);

        Review newInstance = new Review(review);

        if (instance != null) {
            if(instance.version.equals(review.version))
                throw new IllegalArgumentException("Version already exists");

            newInstance.GUID = review.GUID;

            versionController.createDump(newInstance, instance, Review.class, em);

            em.merge(newInstance);
        } else {
            em.persist(newInstance.tags);
            em.persist(newInstance.content);
            em.persist(newInstance.user);
            em.persist(newInstance);
        }
        em.flush();
    }


    /**
     * Метод для добавления нового юзера в бд
     * @param user
     */
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void insertUser(@RequestBody User user) {

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
    }

}
