package database.controller;

import database.model.storage.Material;
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
    @RequestMapping(value = "/material", method = RequestMethod.POST)
    public void material (@RequestBody Material material) {

        Material instance = em.find(Material.class, material.GUID);

        em.remove(instance);
        em.flush();
    }
}
