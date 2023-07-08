package uz.pdp.apiTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apiTemplate.dto.ProductCriteria;
import uz.pdp.apiTemplate.dto.ProductDTO;
import uz.pdp.apiTemplate.service.ProductClient;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/openFeign")
public class OpenFeignController {

    @Autowired
    ProductClient productClient;

    @PostMapping
    public boolean add(@RequestBody ProductDTO productDTO){
        return productClient.add(productDTO);
    }

    @PutMapping
    public boolean edit(@RequestBody ProductDTO productDTO){
        return productClient.edit(productDTO);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return productClient.delete(id);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable int id){
        return productClient.getById(id);
    }

    @GetMapping("/list")
    public List<?> get(@RequestBody ProductCriteria productCriteria ){
        return productClient.get(productCriteria);
    }
}
