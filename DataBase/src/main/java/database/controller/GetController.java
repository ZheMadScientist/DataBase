package database.controller;


import database.model.storage.Material;
import database.model.storage.Review;
import database.model.tagging.Tags;
import database.model.user.User;
import database.repos.MaterialRepo;
import database.repos.ReviewRepo;
import database.repos.UserRepo;
import database.versioning.AllVersions;
import database.versioning.VController;
import database.versioning.Versions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Контроллер, отвечающий на get запросы
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/get")
public class GetController {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MaterialRepo materialRepo;

    @PersistenceContext
    private EntityManager em;

    private VController versionController = new VController();

    private LocalDate minDate = LocalDate.of(1700, 1,1);

    private LocalDate maxDate = LocalDate.of(3000, 1,1);

    /*
     * CONTENT
     */

    /**
     * Метод для получения Материалов {@link List<Material>} по параметрам
     * Пример запроса: url / get / material ? name = {} & description = {} & version = 1
     * @param name наименование
     * @param description описание
     * @param tags тэги в виде списка
     * @param getAll boolean, если {@code true}, возвращаются все материалы из базы
     * @return {@link List<Material>}
     */
    @RequestMapping(value = "/materials", method = RequestMethod.GET)
    public List<Material> getMaterial(@RequestParam(value="name", required = false) String name,
                                      @RequestParam(value="description", required = false) String description,
                                      @RequestParam(value="tags", required = false) ArrayList<String> tags,
                                      @RequestParam(value = "getAll", required = false, defaultValue = "false") boolean getAll) {

        if(getAll)
            return materialRepo.findAll();

        List<Material> res;

        if(name != null && description != null && tags != null)
            res = materialRepo.getMaterialsByNameAndDescriptionAndTags_tagsContaining(name, description, tags);

        else if(name != null && description != null)
            res = materialRepo.getMaterialsByNameAndDescription(name, description);

        else if(name != null && tags != null)
            res = materialRepo.getMaterialsByNameAndTags_tagsContaining(name, tags);

        else if(description != null && tags != null)
            res = materialRepo.getMaterialsByDescriptionAndTags_tagsContaining(description, tags);

        else if(tags != null)
            res = materialRepo.getMaterialsByTags_tagsContaining(tags);

        else if(name != null)
            res = materialRepo.getMaterialsByName(name);

        else if(description != null)
            res = materialRepo.getMaterialsByDescription(description);

        else throw new IllegalArgumentException("At least one argument must not be null");

        return res;
    }

    /**
     * Метод получения материала по GUID
     * @param id guid материала
     * @param version требуемая версия
     * @return {@link Material}
     */

    @RequestMapping(value = "/material_by_id", method = RequestMethod.GET)
    public Material getMaterialById(@RequestParam(value="id") long id,
                                    @RequestParam(value="version", required = false, defaultValue = "") String version) {

        Material material = em.find(Material.class, id);

        if(!version.equals(""))
            return versionController.getOlder(material, Material.class, version, em);

        return material;
    }

    /*
     * EOF CONTENT
     */


    /*
     * REVIEWS
     */

    /**
     * Метод для получения объекта {@link List<Review>} <br> Все параметры могут быть {@code null} или неполными объектами. <br>
     *     Например, {@link User} может иметь только {@code User.name} <br>
     *         Но хотя бы один параметр должен быть ненулевым
     * @param tags набор тэгов для поиска отзыва
     * @param fromAge начальный возраст юзера, оставившего отзыв
     * @param toAge конечный возраст юзера
     * @param gender пол юзера
     * @param fromDate начальная дата для фильтрации отзывов
     * @param toDate конечная дата для фильтрации отзывов
     * @param getAll boolean, если {@code true}, возвращаются все отзывы из базы
     * @return {@link List<Review>}
     */
    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public List<Review> getReview (
                                @RequestParam(value="tags", required = false) ArrayList<String> tags,
                                @RequestParam(value = "fromAge", required = false, defaultValue = "-1") int fromAge,
                                @RequestParam(value = "toAge", required = false, defaultValue = "-1") int toAge,
                                @RequestParam(value = "gender", required = false) String gender,
                                @RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern="dd.MM.yyyy") LocalDate fromDate,
                                @RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern="dd.MM.yyyy") LocalDate toDate,
                                @RequestParam(value = "getAll", required = false, defaultValue = "false") boolean getAll) {

        List<User> users;
        List<Review> res = new ArrayList<>();



        if(getAll)
            return reviewRepo.findAll();

        if(tags == null && fromAge == -1 && toAge == -1 && gender == null && fromDate == null && toDate == null)
            throw new IllegalArgumentException("At least one argument must not be null");

        if(fromDate == null)
            fromDate = minDate;

        if(toDate == null)
            toDate = maxDate;

        if(tags == null && gender == null && fromAge == -1 && toAge == -1)
            return reviewRepo.getReviewsByReviewDateBetween(fromDate, toDate);

        if(tags != null && gender == null && fromAge == -1 && toAge == -1)
            return reviewRepo.getReviewsByTags_tagsContaining(tags);

        if(toAge == -1)
            toAge = Integer.MAX_VALUE;

        if(gender != null) {
            users = userRepo.getUsersByAgeBetweenAndGender(fromAge, toAge, gender);
        } else {
            users = userRepo.getUsersByAgeBetween(fromAge, toAge);
        }

        if(tags != null) {
            for (User u : users)
                res.addAll(reviewRepo.getReviewsByUserAndReviewDateBetweenAndTags_tagsContaining(u, fromDate, toDate, tags));
        } else {
            for (User u : users)
                res.addAll(reviewRepo.getReviewsByUserAndReviewDateBetween(u, fromDate, toDate));
        }


        return res;
    }

    /**
     * Метод получения отзыва по GUID
     * @param id guid отзыва
     * @param version требуемая версия отзыва
     * @return {@link Review}
     */
    @RequestMapping(value = "/review_by_id", method = RequestMethod.GET)
    public Review getReviewById (@RequestParam(value="id") long id,
                                 @RequestParam(value="version", required = false, defaultValue = "") String version) {

        Review review = em.find(Review.class, id);

        if(!version.equals(""))
            review = versionController.getOlder(review, Review.class, version, em);

        return review;
    }

    /*
     * EOF REVIEWS
     */

    /*
     * VERSIONS
     */

    /**
     * Метод для получения имен и описаний всех версий сущности
     * @param id guid сущности
     * @return имена всех сохраненных в бд версий
     * @see AllVersions
     */
    @RequestMapping(value = "/get_all_versions", method = RequestMethod.GET)
    public AllVersions getAllVersions (@RequestParam(value="id") long id) {

        List<Versions> versions = em.createQuery("SELECT t FROM Versions t where t.entity_id = :id")
                .setParameter("id", id)
                .getResultList();

        AllVersions allVersions = new AllVersions();

        for(Versions v : versions)
            allVersions.put(v.version, v.versionDescription);

        return allVersions;
    }

    /*
     * EOF VERSIONS
     */
}
