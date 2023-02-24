package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Dictionacy {
    @GetMapping("/")
    public String dictionary(@RequestParam(required = false) String word, Model model) {
        if (word == null) {
            model.addAttribute("word", word);
            return "/dictionary";
        }
        List<String> englishList = new ArrayList<>();
        englishList.add("Blue");
        englishList.add("Yellow");
        englishList.add("Red");
        englishList.add("Green");
        englishList.add("Brown");
        model.addAttribute("word", word);
        int index = englishList.indexOf(word);

        List<String> vietnameseList = new ArrayList<>();
        vietnameseList.add("Màu xanh niển");
        vietnameseList.add("Màu vàng");
        vietnameseList.add("Màu đỏ");
        vietnameseList.add("Màu xanh lá");
        vietnameseList.add("Màu nâu");
        model.addAttribute("vietList", vietnameseList);

        String translate = vietnameseList.get(index);
        model.addAttribute("trans", translate);
        return "/dictionary";
    }
}