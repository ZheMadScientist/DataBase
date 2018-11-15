package database.repos;

import database.model.storage.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {

    List<Material> getMaterialsByNameAndDescriptionAndTags_tagsContaining(String name, String description, List<String> tags);

    List<Material> getMaterialsByNameAndDescription(String name, String description);

    List<Material> getMaterialsByNameAndTags_tagsContaining(String name, List<String> tags);

    List<Material> getMaterialsByDescriptionAndTags_tagsContaining(String description, List<String> tags);

    List<Material> getMaterialsByTags_tagsContaining(List<String> tags);

    List<Material> getMaterialsByName(String name);

    List<Material> getMaterialsByDescription(String description);

}
