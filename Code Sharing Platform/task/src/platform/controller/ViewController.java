package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import platform.repository.CodeRepository;

@Controller
public final class ViewController {
    private final CodeRepository repo;

    @Autowired
    public ViewController(CodeRepository repo) {
        this.repo = repo;
    }

    //Todo: Try to do it with just one Model attribute
    @GetMapping(value = "/code/{id}")
    private String getCodeView(Model model, @PathVariable long id) {
        final var code = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no code with the given ID")
        );
//        model.addAttribute("date", DateTime.Formatted(code.getDate()));
        model.addAttribute("date", code.getDate().toString());
        model.addAttribute("code", code.getCode());
        return "code";
    }

    // todo: it returns the 10 most recently uploaded codes
    @GetMapping(value = "/code/latest")
    private String getLatestCodeView(Model model) {
        model.addAttribute("codeList", repo.findLatestByOrderByDateDesc(10));
        return "codes";
    }

    @GetMapping("/code/new")
    private String getNewCodeView() {
        return "new";
    }
}
