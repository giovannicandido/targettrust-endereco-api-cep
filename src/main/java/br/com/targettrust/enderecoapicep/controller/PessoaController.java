package br.com.targettrust.enderecoapicep.controller;

import br.com.targettrust.enderecoapicep.controller.dto.CompraDTO;
import br.com.targettrust.enderecoapicep.controller.dto.PessoaRequest;
import br.com.targettrust.enderecoapicep.controller.dto.PessoaResponse;
import br.com.targettrust.enderecoapicep.controller.mapper.PessoaMapper;
import br.com.targettrust.enderecoapicep.model.Pessoa;
import br.com.targettrust.enderecoapicep.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pessoa/search")
    public List<Pessoa> findByNome(@RequestParam String nome) {
        return pessoaService.findByNome(nome);
    }
}
