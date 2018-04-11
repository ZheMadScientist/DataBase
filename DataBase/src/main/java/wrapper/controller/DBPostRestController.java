package wrapper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import wrapper.model.storage.Material;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@RestController
@RequestMapping(value = "/post")
public class DBPostRestController {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @CrossOrigin
    @Transactional
    @RequestMapping(value = "/material", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void insertMaterial (@RequestParam(value = "name", defaultValue = "") String name,
                             @RequestParam(value = "description", defaultValue = "") String description,
                             @RequestParam(value = "content", defaultValue = "") String content) {

        Material material = new Material(name, description, content);
        System.out.println("MATERIAL GUID = " + material.GUID);
        em.persist(material.content);
        em.persist(material);
        em.flush();
    }
}
