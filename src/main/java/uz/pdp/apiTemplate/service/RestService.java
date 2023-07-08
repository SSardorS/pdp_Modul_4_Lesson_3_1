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
    private String get;

    public int post(ProductDTO productDTO){

        ResponseEntity<Object> exchange = restTemplate.exchange(post, HttpMethod.POST, new HttpEntity<>(productDTO), Object.class);

        return exchange.getStatusCode().value();

    }

    public void put(ProductDTO productDTO){

        restTemplate.put(put, HttpMethod.PUT, new HttpEntity<>(productDTO));

    }

    public void delete(int id) {

        restTemplate.delete(delete+id);

    }

    public ProductDTO getById(int id) {

        return restTemplate.getForObject(getId + id, ProductDTO.class);

    }

    public List get(ProductCriteria productCriteria) {

       return restTemplate.getForObject(get,List.class,productCriteria);

    }
}
