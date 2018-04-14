package database.controller;

import database.model.storage.Material;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/material", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void insertMaterial (@RequestBody Material material) {

        Material newInstance = new Material(material);

        em.persist(newInstance.content);
        em.persist(newInstance);
        em.flush();
    }

}
