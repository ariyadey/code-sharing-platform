package platform.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class CodeRepo {
    private final List<Code> codes = new ArrayList<>();

    //todo complete and use it instead of getCodes()
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

    public List<Code> getLatest(int n) { //todo improve this method
        final var repoSize = codes.size();
        final var latestCodes = new ArrayList<>(codes.subList(repoSize > 10 ? repoSize - 10 : 0, repoSize));
        latestCodes.sort(Comparator.comparing(Code::getDate).reversed());
        return latestCodes;
    }
}
