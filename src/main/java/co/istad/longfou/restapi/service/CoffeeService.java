package co.istad.longfou.restapi.service;

import co.istad.longfou.restapi.dto.CoffeeResponse;
import co.istad.longfou.restapi.dto.CreateCoffeeRequest;

import java.math.BigDecimal;
import java.util.List;

public interface CoffeeService {

    //1. Excepted result: (return type: void, oject, collection, int, ...)
    //2. Your logic: add single Coffee
    //3. Parameters is used for client submission
    CoffeeResponse createCoffee(CreateCoffeeRequest coffeeRequest);

    List<CoffeeResponse> searchCoffee(String name, BigDecimal price);

    CoffeeResponse getCoffeeById(Integer id);

//    List<Coffee> getCoffees();
    List<CoffeeResponse> getCoffees();
}
