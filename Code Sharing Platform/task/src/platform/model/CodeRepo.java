package platform.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CodeRepo {
    private final List<Code> codes = new ArrayList<>();

    public Code getAt(int index) {
        return codes.get(index);
    }

    public void add(Code code) {
        code.update();
        codes.add(code);
    }

    public int size() {
        return codes.size();
    }

    public List<Code> getLatest(int n) {
        final var size = codes.size();
        final var latestCodes = new ArrayList<>(codes.subList(size > n ? size - n : 0, size));
//        latestCodes.sort(Comparator.comparing(Code::getDate).reversed());
        Collections.reverse(latestCodes);
        return latestCodes;
    }
}
