package br.com.targettrust.enderecoapicep.controller;

import br.com.targettrust.enderecoapicep.config.BancoApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BancoTestController {
    private final BancoApiService bancoApiService;

    public BancoTestController(BancoApiService bancoApiService) {
        this.bancoApiService = bancoApiService;
    }

    @GetMapping(path = "/banco")
    public String qualBanco() {
        return bancoApiService.getBankName();
    }
}
