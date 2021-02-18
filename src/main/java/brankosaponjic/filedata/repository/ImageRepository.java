package brankosaponjic.filedata.repository;

import brankosaponjic.filedata.entity.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
