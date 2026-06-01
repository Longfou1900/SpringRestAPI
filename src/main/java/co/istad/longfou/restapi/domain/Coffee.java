package co.istad.longfou.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
//import lombok.Data;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Coffee {
    private Integer id;
    private String name;
    private String description;
    //add price attribute
    //private Double price;
    private BigDecimal price;

}
