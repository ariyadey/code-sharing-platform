package platform.model;

import org.springframework.data.repository.CrudRepository;

public interface CodeRepository extends CrudRepository<Code, Integer> {
}

//@Component
//public final class CodeRepository {
//    private final List<Code> codes = new ArrayList<>();
//
//    public final Code getAt(int index) {
//        return codes.get(index);
//    }
//
//    public final void add(Code code) {
//        code.update();
//        codes.add(code);
//    }
//
//    public final int size() {
//        return codes.size();
//    }
//
//    public final List<Code> getLatest(int n) {
//        final var size = codes.size();
//        final var latestCodes = new ArrayList<>(codes.subList(size > n ? size - n : 0, size));
////        latestCodes.sort(Comparator.comparing(Code::getDate).reversed());
//        Collections.reverse(latestCodes);
//        return latestCodes;
//    }
//}
