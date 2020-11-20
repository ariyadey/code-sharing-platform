package platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import platform.model.Code;

import java.util.ArrayList;
import java.util.Comparator;

import static platform.CodeSharingPlatform.CODES;

@Controller
public class ViewController {

    @GetMapping(value = "/code/{codeNumber}")
    private String getCodeView(Model model, @PathVariable int codeNumber) {
        //todo can you make two statements one? (With the help of Freemarker)
        model.addAttribute("date", CODES.get(codeNumber - 1).getDate());
        model.addAttribute("code", CODES.get(codeNumber - 1).getCode());
        return "code";
    }

    @GetMapping(value = "/code/latest")
    private String getLatestCodeView(Model model) {
        final var latestCodes = new ArrayList<>(CODES.subList(CODES.size() > 10 ? CODES.size() - 10 : 0, CODES.size()));
        latestCodes.sort(Comparator.comparing(Code::getDate).reversed()); //todo extract method
        //todo try addAllAttribute() method
        model.addAttribute("codeList", latestCodes);
        return "codes";
    }

    @GetMapping("/code/new")
    private String getNewCodeView() {
        return "new";
    }
}
