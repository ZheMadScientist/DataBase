package database.controller;

import database.model.storage.Content;
import database.model.storage.Material;
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

}
