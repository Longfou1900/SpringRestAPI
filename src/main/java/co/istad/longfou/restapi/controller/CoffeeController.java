package co.istad.longfou.restapi.controller;

//import co.istad.longfou.restapi.domain.Coffee;

import co.istad.longfou.restapi.dto.CoffeeResponse;
import co.istad.longfou.restapi.dto.CreateCoffeeRequest;
import co.istad.longfou.restapi.dto.UpdateCoffeeRequest;
import co.istad.longfou.restapi.service.CoffeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CoffeeResponse createCoffee(
            @Valid @RequestBody CreateCoffeeRequest createCoffeeRequest
    ) {
        return coffeeService.createCoffee(createCoffeeRequest);
    }

    @GetMapping
//    public List<Coffee> geCoffees(){
    public List<CoffeeResponse> geCoffees() {
        return coffeeService.getCoffees();
    }

    @GetMapping("/{id}")
    public CoffeeResponse getCoffeeByID(@PathVariable Integer id) {
        log.info("GET Id : {}", id);
        return coffeeService.getCoffeeById(id);
    }

    @PutMapping("/{id}")
    public CoffeeResponse updateCoffeeId(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateCoffeeRequest updateCoffeeRequest
            ) {
        return coffeeService.updateCoffeeById(id,updateCoffeeRequest);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public CoffeeResponse deleteCoffeeBYId(
            @PathVariable Long id){
        return coffeeService.deleteCoffeeById(id);
    }

    @GetMapping("/search")//is not call as endpoint
    public List<CoffeeResponse> searchCoffeeByName(
            @RequestParam(required = false, defaultValue = "") String name,
//            @RequestParam(required = false, defaultValue = "0" ) Double price
            @RequestParam(required = false, defaultValue = "0") BigDecimal price
    ) {
        log.info("GET research name  : {}", name);
        log.info("GET research price  : {}", price);
        return null;
    }

}
