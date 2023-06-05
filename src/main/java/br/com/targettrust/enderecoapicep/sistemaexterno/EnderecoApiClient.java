package br.com.targettrust.enderecoapicep.sistemaexterno;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "https://viacep.com.br", name = "viacep")
public interface EnderecoApiClient {
    /**
     * Retorna a resposta Http da API, para o tipo de dados EnderecoDTO
     * @param cep
     * @return
     */
    @GetMapping(path = "/ws/{cep}/json")
    ResponseEntity<EnderecoDTO> getEndereco(@PathVariable("cep") String cep);

    /**
     * Retorna a resposta da api diretamente (corpo da resposta)
     * @param cep
     * @return
     */
    @GetMapping(path = "/ws/{cep}/json")
    EnderecoDTO getEnderecoPorCep2(@PathVariable("cep") String cep);

    /**
     * So um exemplo de post
     * @param enderecoDTO
     */
    @PostMapping(path = "/ws/salvar")
    void salvarEndereco(@RequestBody EnderecoDTO enderecoDTO);
}
