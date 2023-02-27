package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.impl.DictionaryService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DictionaryController {
    DictionaryService dictionaryService = new DictionaryService();
    @GetMapping("/")
    public String dictionary(@RequestParam(required = false) String word, Model model) {
        if (word == null) {
            model.addAttribute("word", word);
            return "/dictionary";
        }
        List<String> englishList = dictionaryService.getEngList();
        model.addAttribute("word", word);
        int index = englishList.indexOf(word);
        List<String> vietnameseList = dictionaryService.getVietList();
        model.addAttribute("vietList", vietnameseList);

        String translate = vietnameseList.get(index);
        model.addAttribute("trans", translate);
        return "/dictionary";
    }
}