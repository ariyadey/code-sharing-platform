package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.model.CodeRepo;

@Controller
public class ViewController {
    private final CodeRepo repo;

    @Autowired
    public ViewController(CodeRepo repo) {
        this.repo = repo;
    }

    //todo can you make two statements one? (With the help of Freemarker)
    @GetMapping(value = "/code/{codeNumber}")
    private String getCodeView(Model model, @PathVariable int codeNumber) {
        model.addAttribute("date", repo.getAt(codeNumber - 1).getDate());
        model.addAttribute("code", repo.getAt(codeNumber - 1).getCode());
        return "code";
    }

    // todo: it returns the 10 most recently uploaded codes
    //todo try addAllAttribute() method
    @GetMapping(value = "/code/latest")
    private String getLatestCodeView(Model model) {
        model.addAttribute("codeList", repo.getLatest(10));
        return "codes";
    }

    @GetMapping("/code/new")
    private String getNewCodeView() {
        return "new";
    }
}
