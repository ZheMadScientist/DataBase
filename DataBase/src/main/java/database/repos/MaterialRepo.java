package database.repos;

import database.model.storage.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {

    Set<Material> getMaterialsByNameAndDescriptionAndTags_tagsIn(String name, String description, List<String> tags);

    List<Material> getMaterialsByNameAndDescription(String name, String description);

    Set<Material> getMaterialsByNameAndTags_tagsIn(String name, List<String> tags);

    Set<Material> getMaterialsByDescriptionAndTags_tagsIn(String description, List<String> tags);

    Set<Material> getMaterialsByTags_tagsIn(List<String> tags);

    List<Material> getMaterialsByName(String name);

    List<Material> getMaterialsByDescription(String description);

}
