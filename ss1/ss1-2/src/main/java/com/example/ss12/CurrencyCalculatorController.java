package com.example.ss12;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import model.service.impl.CurrencyCalculatorService;

@Controller
@RequestMapping("/")
public class CurrencyCalculatorController {
    private CurrencyCalculatorService currencyCalculatorService = new CurrencyCalculatorService();
    @GetMapping ("")
    public String converseCurrency (@RequestParam(required = false) Double usd, Model model) {
        if (usd == null) {
            model.addAttribute("usd", usd);
            return "/currency";
        }
        double vnd = currencyCalculatorService.converseCurrency(usd);
        model.addAttribute("usd", usd);

        model.addAttribute("vnd", vnd);
        return "/currency";
    }
}
