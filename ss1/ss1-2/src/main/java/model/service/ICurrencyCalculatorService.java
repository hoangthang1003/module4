package model.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface ICurrencyCalculatorService {
     double converseCurrency (@RequestParam(required = false) Double usd);
}
