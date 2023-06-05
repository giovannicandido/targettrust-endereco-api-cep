package br.com.targettrust.enderecoapicep.sistemaexterno;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Exemplo de Client para Api de endereco usando restTemplate diretamente
 */
public class EnderecoApiRestTemplateClient {
    private final RestTemplate restTemplate = new RestTemplate();
    EnderecoDTO buscarEnderecoPorCep(String cep) {
        ResponseEntity<EnderecoDTO> enderecoResposta = restTemplate.getForEntity("https://viacep.com.br/ws/" + cep + "/json", EnderecoDTO.class);
        if (!enderecoResposta.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            throw new RuntimeException("Cep não encontrado");
        }
        return enderecoResposta.getBody();
    }
}
