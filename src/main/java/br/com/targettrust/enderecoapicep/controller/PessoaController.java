package br.com.targettrust.enderecoapicep.controller;

import br.com.targettrust.enderecoapicep.controller.dto.CompraDTO;
import br.com.targettrust.enderecoapicep.controller.dto.PessoaRequest;
import br.com.targettrust.enderecoapicep.controller.dto.PessoaResponse;
import br.com.targettrust.enderecoapicep.controller.mapper.PessoaMapper;
import br.com.targettrust.enderecoapicep.model.Pessoa;
import br.com.targettrust.enderecoapicep.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(path = "/pessoa")
    public List<PessoaResponse> listAll() {
        return pessoaService.listar()
                .stream()
                .map(PessoaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/pessoa")
    public void criar(@RequestBody @Valid PessoaRequest pessoa) {
        pessoaService.criar(PessoaMapper.toModel(pessoa), pessoa.getEnderecoId());
    }

    @PostMapping(path = "/pessoa/comprar-casa")
    public void comprarCasa(@RequestBody @Valid CompraDTO compraDTO) {
        pessoaService.comprarCasas(compraDTO.getIdPessoa(), compraDTO.getCasasId());
    }

    @GetMapping(path = "/pessoas-com-casas")
    public List<Pessoa> listarPessoasComCasas() {
        return pessoaService.listar();
    }
}
