package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import platform.dto.CodeDtoView;
import platform.repository.CodeRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public final class ViewController {
    private final CodeRepository repo;

    @Autowired
    public ViewController(CodeRepository repo) {
        this.repo = repo;
    }

    //Todo: How the hell to return a static page instead of a template? It doesn't work
    @GetMapping("/code/new")
    private String getNewCodeView() {
        return "new";
    }

    @GetMapping(value = "/code/{id}")
    private String getCodeView(Model model, @PathVariable String id) {
        model.addAttribute(
                "code",
                new CodeDtoView().fromCode(repo.save(repo.findByIdAndExpirationDateTimeAfterAndViewsLeftGreaterThanOrSecretFalse(
                        UUID.fromString(id),
                        LocalDateTime.now(),
                        0)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "There is no code with the given UUID")))));
        return "code";
    }

    @GetMapping(value = "/code/latest")
    private String getLatestCodeView(Model model) {
        model.addAttribute("codeList", repo.findFirst10BySecretFalse());
        return "latest";
    }
}
