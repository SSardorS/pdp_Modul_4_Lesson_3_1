package uz.pdp.apiTemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import uz.pdp.apiTemplate.dto.ProductCriteria;
import uz.pdp.apiTemplate.dto.ProductDTO;

import java.util.List;

@Service
public class WebClientService {

    @Autowired
    WebClient webClient;

    @Value("${api.url.post}")
    private String post;

    @Value("${api.url.put}")
    private String put;

    @Value("${api.url.delete}")
    private String delete;

    @Value("${api.url.getId}")
    private String getId;

    @Value("${api.url.get}")
    private String getAll;

    public Boolean post(ProductDTO productDTO){

       return webClient
               .post()
               .uri(post)
               .body(BodyInserters.fromValue(productDTO))
               .retrieve()
               .bodyToMono(Boolean.class)
               .block();

    }


    public Boolean put(ProductDTO productDTO){

        return webClient
                .put()
                .uri(put)
                .body(Mono.just(productDTO), ProductDTO.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

    }

    public Boolean delete(int id) {
        return webClient
                .delete()
                .uri(delete+id)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

    }

    public ProductDTO getById(int id) {

        return webClient
                .get()
                .uri(getId+id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ProductDTO>() {
                })
                .block();

    }

    public List<ProductDTO> get(ProductCriteria productCriteria) {

        return webClient
                .method(HttpMethod.GET)
                .uri(getAll)
                .body(Mono.just(productCriteria), ProductCriteria.class)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductDTO>>() {
                })
                .block();

    }

}
