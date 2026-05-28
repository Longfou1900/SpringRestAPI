package co.istad.longfou.restapi.controller;

//import co.istad.longfou.restapi.domain.Coffee;
import co.istad.longfou.restapi.dto.CoffeeResponse;
import co.istad.longfou.restapi.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
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

    @GetMapping("/{id}")
    public CoffeeResponse getCoffeeByID(@PathVariable Integer id){
        log.info("GET Id : {}",id);
        return null;
    }

    @GetMapping("/search")//is not call as endpoint
    public List<CoffeeResponse> searchCoffeeByName(
            @RequestParam(required = false, defaultValue = "" ) String name ,
            @RequestParam(required = false, defaultValue = "0" ) Double price
    ){
        log.info("GET research name  : {}", name);
        log.info("GET research price  : {}", price);
        return null;
    }
}
