package co.istad.longfou.restapi.service.impl;

import co.istad.longfou.restapi.domain.Coffee;
import co.istad.longfou.restapi.dto.CoffeeResponse;
import co.istad.longfou.restapi.dto.CreateCoffeeRequest;
import co.istad.longfou.restapi.repository.CoffeeRepostiory;
import co.istad.longfou.restapi.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    //db
    private final CoffeeRepostiory coffeeRepository;

//    private final List<Coffee> coffeebean;

//    public CoffeesesrviceImpl(CoffeeRepostiory coffeeRepostiory, List<Coffee> coffeeBean){
    public CoffeeServiceImpl(CoffeeRepostiory coffeeRepostiory){
        this.coffeeRepository = coffeeRepostiory;
//        this.coffeebean = coffeeBean;
    }

    @Override
    public CoffeeResponse createCoffee(CreateCoffeeRequest createcoffeeRequest) {

        Coffee coffee = new Coffee();
        coffee.setId(new Random().nextInt(99999));
        coffee.setName(createcoffeeRequest.name());
        coffee.setDescription(createcoffeeRequest.description());
        coffee.setPrice(createcoffeeRequest.price());

        boolean isExisting = coffeeRepository.getCoffees()
                        .stream()
                        .anyMatch(c -> c.getId().equals(coffee.getId()));

        if (isExisting) {
            throw new RuntimeException("Coffee ID already exists");
        }

        coffeeRepository.getCoffees().add(coffee);
        return new CoffeeResponse(coffee.getId(), coffee.getName(), coffee.getDescription());

//        coffeebean.add(coffee);
//        return new CoffeeResponse( coffee.getName(), coffee.getDescription(), coffee.getPrice());

    }

    @Override
    public List<CoffeeResponse> searchCoffee(String name, BigDecimal price) {
        //TODO: here logic ...
        return coffeeRepository.getCoffees()
//        return coffeebean
                .stream()
                .filter(coffee ->
                        coffee.getName().toLowerCase().contains(name.toLowerCase()) ||
                        coffee.getPrice().equals(price))
                .map(coffee -> new CoffeeResponse(coffee.getId(),coffee.getName(), coffee.getPrice().toString()))
                .toList();
    }

    @Override
    public CoffeeResponse getCoffeeById(Integer id) {
        return coffeeRepository.getCoffees()
//        return coffeebean
                .stream()
                .filter(coffee -> coffee.getId().equals(id))
                .map(coffee -> new CoffeeResponse(coffee.getId(),coffee.getName(), coffee.getDescription()))
                .findFirst()
                .orElseThrow();
    }

    @Override
//    public List<Coffee> getCoffees() {
    public List<CoffeeResponse> getCoffees() {
        //return domain from Response
//        List<Coffee> coffees = coffeeRepostiory.beanCoffee();
        return coffeeRepository.getCoffees().stream()
        //Return DTO - CoffeeResponse
//        return coffees.stream()
//        return coffeebean.stream()
//                .filter(coffee -> coffee.getId() > 2)
                .map(coffee -> new CoffeeResponse(coffee.getId(),coffee.getName(), coffee.getDescription()))
                .toList();
    }
}
