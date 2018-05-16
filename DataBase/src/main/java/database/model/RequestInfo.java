package database.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, хранящий ссылку на онтологию и параметры, необходимые для <br>
 * Генерации новых заданий<br>
 * Создания пулов заданий <br>
 * Подбора похожих заданий
 *
 */


public class RequestInfo implements Serializable {

    /**
     * Ссылка на онтологию
     */
    public long ontology_link;

    /**
     * Ссылки на связанные объекты
     */
    public List<Long> links;

    /**
     * Параметры генерации
     */
    public List<String> generation_params;

    /**
     * Другие атрибуты
     */
    public List<String> attributes;

    public RequestInfo(){
        links = new ArrayList<>();
        generation_params = new ArrayList<>();
    }

    public RequestInfo(RequestInfo old){
        this.links = old.links;
        this.generation_params = old.generation_params;
        this.attributes = old.attributes;
    }
}
