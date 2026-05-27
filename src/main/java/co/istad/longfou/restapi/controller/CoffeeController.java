package co.istad.longfou.restapi.controller;

import co.istad.longfou.restapi.domain.Coffee;
import co.istad.longfou.restapi.dto.CoffeeResponse;
import co.istad.longfou.restapi.service.CoffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;


    public CoffeeController(CoffeeService coffeeService){
        this.coffeeService = coffeeService;
    }

    @GetMapping
//    public List<Coffee> geCoffees(){
    public List<CoffeeResponse> geCoffees(){
        return coffeeService.getCoffees();
    }
}
