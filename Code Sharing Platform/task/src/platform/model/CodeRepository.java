package platform.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CodeRepository extends CrudRepository<Code, Long> {
    List<Code> findAllOrderByDateDesc();
}
