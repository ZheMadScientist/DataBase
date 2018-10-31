package database.controller;


import database.model.storage.Material;
import database.model.storage.Review;
import database.model.tagging.Tags;
import database.model.user.User;
import database.versioning.AllVersions;
import database.versioning.VController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

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

    /**
     * Метод для получения Материала по параметрам
     * @param name - наименование, обязательный параметр
     * @param description - описание
     * @param version - требуемая версия
     * @return {@link Material}
     */
    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public Material material(@RequestParam(value="name") String name,
                             @RequestParam(value="description", required = false) String description,
                             @RequestParam(value="version", required = false, defaultValue = "1") String version) {

        //if(!version.equals(""))
            //return versionController.getOlder(em.find(Material.class, id), Material.class, version, em);

        //return em.find(Material.class, id);
        return new Material();
    }

    /*
     * EOF CONTENT
     */

    /*
     * USERS
     */

    /**
     * Метод для получения юзера по параметрам
     * @param name - имя, обязательный параметр
     * @param midName - отчество
     * @param lastName - фамилия
     * @param age - возраст
     * @param gender - пол (male / female)
     * @return {@link User}
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User user (@RequestParam(value="name") String name,
                      @RequestParam(value="mid_name", required = false) String midName,
                      @RequestParam(value="last_name", required = false) String lastName,
                      @RequestParam(value="age", required = false) int age,
                      @RequestParam(value="gender", required = false) String gender) {


        return new User();
    }

    /*
     * EOF USERS
     */


    /*
     * REVIEWS
     */

    /**
     * Метод для получения объекта {@link Review} <br> Все параметры могут быть {@code null} или неполными объектами. <br>
     *     Например, {@link User} может иметь только {@code User.name} <br>
     *         Но хотя бы один параметр должен быть ненулевым
     * @param user - юзер, которому принадлжеит отзыв
     * @param tags - набор тэгов для поиска отзыва
     * @param fromDate - начальная дата для фильтрации отзывов
     * @param toDate - конечная дата для фильтрации отзывов
     * @param version - имя нужной версии отзыва
     * @return {@link Review}
     */
    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public Review review (User user,
                          Tags tags,
                          @RequestParam(value = "from", required = false) @DateTimeFormat(pattern="dd.MM.yyyy") LocalDate fromDate,
                          @RequestParam(value = "to", required = false) @DateTimeFormat(pattern="dd.MM.yyyy") LocalDate toDate,
                          @RequestParam(value="version", required = false, defaultValue = "1") String version) {

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

    /*
     * VERSIONS
     */

    /**
     * Метод для получения имен и описаний всех версий сущности
     * @param id - guid сущности
     * @return имена всех сохраненных в бд версий
     * @see AllVersions
     */
    @RequestMapping(value = "/get_all_versions", method = RequestMethod.GET)
    public AllVersions getAllMaterialVersions (@RequestParam(value="id") int id) {


        return new AllVersions();
    }

    /*
     * EOF VERSIONS
     */
}
