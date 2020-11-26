package platform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.model.Code;

import java.util.List;

//@Component
@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {
    List<Code> findAllByOrderByDateDesc();

    default List<Code> findLatestByOrderByDateDesc(int length) {
        return findAllByOrderByDateDesc().subList(0, (int) Math.min(length, count()));
    }
}
