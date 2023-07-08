package uz.pdp.apiTemplate.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apiTemplate.dto.ProductCriteria;
import uz.pdp.apiTemplate.dto.ProductDTO;

import java.util.List;

@FeignClient(value = "ProductClient",url = "http://localhost:8080/v1/product")
public interface ProductClient {

    @PostMapping("/create")
    boolean add(@RequestBody ProductDTO productDTO);

    @PutMapping("/update")
    boolean edit(@RequestBody ProductDTO productDTO);

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable int id);

    @GetMapping("/get/{id}")
    HttpEntity<?> getById(@PathVariable int id);

    @GetMapping("/list")
    List<?> get(@RequestBody ProductCriteria productCriteria );

}
