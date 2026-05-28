package co.istad.longfou.restapi.repository;

import co.istad.longfou.restapi.domain.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepostiory {

    @Bean
    public List<Coffee> beaCoffee(){
        Coffee coffee = new Coffee(1, "Latte", "Smooth coffee with steamed milk", 1.5);
        Coffee coffee2 = new Coffee(2, "Capuccino", "Coffee with a thick layer of milk foam", 2.20);
        Coffee coffee3 = new Coffee(3, "Americano", "Coffee shot diluted with hot water", 1.65);
        return Arrays.asList(coffee, coffee2, coffee3);
    }
}
