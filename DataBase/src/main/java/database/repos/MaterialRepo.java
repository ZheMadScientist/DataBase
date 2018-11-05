package database.repos;

import database.model.storage.Material;
import database.model.tagging.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {

    List<Material> getMaterialsByNameAndDescriptionAndTagsIn(String name, String description, Tags tags);

    List<Material> getMaterialsByNameAndDescription(String name, String description);

    List<Material> getMaterialsByName(String name);

}
