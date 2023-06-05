package br.com.targettrust.enderecoapicep.controller;

import br.com.targettrust.enderecoapicep.controller.dto.PorCepDTO;
import br.com.targettrust.enderecoapicep.model.Endereco;
import br.com.targettrust.enderecoapicep.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnderecoController {
    private final EnderecoService enderecoService;


    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping(path = "/endereco")
    public List<Endereco> listAll() {
        return enderecoService.listarEndereco();
    }

    @PostMapping(path = "/endereco")
    public void salvar(@RequestBody Endereco endereco) {
        enderecoService.criar(endereco);
    }

    @PostMapping(path = "/endereco/por-cep")
    public void salvarPorCep(@RequestBody @Valid PorCepDTO porCepDTO) {
        enderecoService.criarPorCep(porCepDTO.getCep());
    }
}
