package co.istad.longfou.restapi.service.impl;

import co.istad.longfou.restapi.domain.Coffee;
import co.istad.longfou.restapi.dto.CoffeeResponse;
import co.istad.longfou.restapi.repository.CoffeeRepostiory;
import co.istad.longfou.restapi.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoffeesesrviceImpl implements CoffeeService {

    private final CoffeeRepostiory coffeeRepostiory;

    public CoffeesesrviceImpl(CoffeeRepostiory coffeeRepostiory){
        this.coffeeRepostiory = coffeeRepostiory;
    }

    @Override
//    public List<Coffee> getCoffees() {
    public List<CoffeeResponse> getCoffees() {
        //return domain from Response
        List<Coffee> coffees = coffeeRepostiory.beaCoffee();
//        return coffeeRepostiory.beaCoffee();
        //Return DTO - CoffeeResponse
        return coffees.stream()
                .filter(coffee -> coffee.getId() > 2)
                .map(coffee -> new CoffeeResponse(coffee.getName(), coffee.getDescription()))
                .toList();
    }
}
