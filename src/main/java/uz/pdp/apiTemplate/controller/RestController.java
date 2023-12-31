package uz.pdp.apiTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apiTemplate.dto.ProductCriteria;
import uz.pdp.apiTemplate.dto.ProductDTO;
import uz.pdp.apiTemplate.service.RestService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @Autowired
    RestService restService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody ProductDTO productDTO){

        return restService.post(productDTO);

    }

    @PutMapping
    public HttpEntity<?> edit(@RequestBody ProductDTO productDTO){

        return restService.put(productDTO);

    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable int id){

        return restService.delete(id);

    }


    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable int id){

        ProductDTO byId = restService.getById(id);

        return ResponseEntity.ok(byId);

    }

    @GetMapping("/list")
    public HttpEntity<?> get(@RequestBody ProductCriteria productCriteria ){

        return restService.get(productCriteria);

    }

}
