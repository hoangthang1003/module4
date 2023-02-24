package model.service.impl;

import org.springframework.web.bind.annotation.RequestParam;
import model.service.ICurrencyCalculatorService;

public class CurrencyCalculatorService implements ICurrencyCalculatorService {
    public double converseCurrency (@RequestParam(required = false) Double usd) {
        double  vnd = usd*23792.50;
        return vnd;
    }
}
