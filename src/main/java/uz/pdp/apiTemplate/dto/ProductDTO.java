package uz.pdp.apiTemplate.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Date date= new Date();

}
