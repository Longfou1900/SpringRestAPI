package co.istad.longfou.restapi.repository;

import co.istad.longfou.restapi.domain.Coffee;
//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepostiory {
    @DeleteMapping("DELETE FROM coffees WHERE id = #{id}")
    public boolean deleteById(Long id) {
        return false;
    }

    private final List<Coffee> coffees;

    public CoffeeRepostiory(){
        this.coffees = new ArrayList<>();

        Coffee coffee = new Coffee(1, "Latte", "10% Smooth coffee with steamed milk", BigDecimal.valueOf(5000));
        Coffee coffee2 = new Coffee(2, "Capuccino", "100% Coffee with a thick layer of milk foam", BigDecimal.valueOf(8000));
        Coffee coffee3 = new Coffee(3, "Americano", "200% Coffee shot diluted with hot water", BigDecimal.valueOf(9000));
//
        coffees.add(coffee);
        coffees.add(coffee2);
        coffees.add(coffee3);
    }
//    @Bean
//    public List<Coffee> beanCoffee(){
    public List<Coffee> getCoffees(){

//        List<Coffee> coffees = new ArrayList<>();
//
//        Coffee coffee = new Coffee(1, "Latte", "Smooth coffee with steamed milk", BigDecimal.valueOf(5000));
//        Coffee coffee2 = new Coffee(2, "Capuccino", "Coffee with a thick layer of milk foam", BigDecimal.valueOf(8000));
//        Coffee coffee3 = new Coffee(3, "Americano", "Coffee shot diluted with hot water", BigDecimal.valueOf(9000));
////
//        coffees.add(coffee);
//        coffees.add(coffee2);
//        coffees.add(coffee3);
//        return Arrays.asList(coffee, coffee2, coffee3);
        return coffees;
    }


}
