package co.istad.longfou.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    //add price atritute
    private Double price;

}
