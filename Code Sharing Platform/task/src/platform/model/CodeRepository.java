package platform.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CodeRepository extends CrudRepository<Code, Long> {
    List<Code> findAllByOrderByDateDesc();

    default List<Code> findLatestByOrderByDateDesc(int length) {
        return findAllByOrderByDateDesc().subList(0, (int) Math.min(length, count()) - 1);
    }
}
