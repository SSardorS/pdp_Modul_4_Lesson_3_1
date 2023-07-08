package uz.pdp.apiTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apiTemplate.dto.ProductCriteria;
import uz.pdp.apiTemplate.dto.ProductDTO;
import uz.pdp.apiTemplate.service.RestService;
import uz.pdp.apiTemplate.service.WebClientService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/webClient")
public class WebClientController {

    @Autowired
    WebClientService webClientService;

    @PostMapping
    public boolean add(@RequestBody ProductDTO productDTO){

        return webClientService.post(productDTO);

    }

    @PutMapping
    public boolean edit(@RequestBody ProductDTO productDTO){

        return webClientService.put(productDTO);

    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){

        return webClientService.delete(id);

    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable int id){

        ProductDTO byId = webClientService.getById(id);

        return ResponseEntity.ok(byId);

    }

    @GetMapping("/list")
    public List<?> get(@RequestBody ProductCriteria productCriteria ){

        return webClientService.get(productCriteria);

    }

}
