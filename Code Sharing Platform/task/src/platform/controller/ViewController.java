package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.dto.CodeDtoView;
import platform.repository.CodeRepository;
import platform.service.Service;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public final class ViewController {
    private final CodeRepository repo;
    private final Service service;

    @Autowired
    public ViewController(CodeRepository repo, Service service) {
        this.repo = repo;
        this.service = service;
    }

    //Todo: How the hell to return a static page instead of a template? It doesn't work
    @GetMapping("/code/new")
    private String getNewCodeView() {
        return "new";
    }

    @GetMapping(value = "/code/{id}")
    private String getCodeView(Model model, @PathVariable String id) {
        model.addAttribute("code", new CodeDtoView().fromCode(service.viewCodeById(id)));
        return "code";
    }

    @GetMapping(value = "/code/latest")
    private String getLatestCodeView(Model model) {
        final var codes = repo.findFirst10BySecretFalseOrderByUploadDateTimeDesc();
        final Collection<CodeDtoView> dtoCollection = new ArrayList<>();
        for (var code : codes) dtoCollection.add(new CodeDtoView().fromCode(code));
        model.addAttribute("codeList", dtoCollection);
        return "latest";
    }
}
