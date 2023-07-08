package uz.pdp.apiTemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.apiTemplate.dto.ProductCriteria;
import uz.pdp.apiTemplate.dto.ProductDTO;

import java.util.List;

@Service
public class RestService {

    @Autowired
    RestTemplate restTemplate;


    @Value("${api.url.post}")
    private String post;

    @Value("${api.url.get}")
    private String put;

    @Value("${api.url.delete}")
    private String delete;

    @Value("${api.url.getId}")
    private String getId;

    @Value("${api.url.get}")
    private String getAll;

    public ResponseEntity<Boolean> post(ProductDTO productDTO){

        return restTemplate.exchange(post, HttpMethod.POST, new HttpEntity<>(productDTO), Boolean.class);

    }

    public ResponseEntity<Boolean> put(ProductDTO productDTO){

        return restTemplate.exchange(put, HttpMethod.PUT, new HttpEntity<>(productDTO), Boolean.class);

    }

    public ResponseEntity<Boolean> delete(int id) {

        return restTemplate.exchange(delete, HttpMethod.DELETE, ResponseEntity.EMPTY, Boolean.class, id);

    }

    public ProductDTO getById(int id) {

        return restTemplate.getForObject(getId, ProductDTO.class,id);

    }

    public ResponseEntity<List<ProductDTO>> get(ProductCriteria productCriteria) {

        ResponseEntity<List<ProductDTO>> exchange = restTemplate.exchange(getAll, HttpMethod.GET, new HttpEntity<>(productCriteria), new ParameterizedTypeReference<>() {
        });

        return exchange;


    }
}
