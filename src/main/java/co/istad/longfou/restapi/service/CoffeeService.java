package co.istad.longfou.restapi.service;

import co.istad.longfou.restapi.domain.Coffee;
import co.istad.longfou.restapi.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {

//    List<Coffee> getCoffees();
    List<CoffeeResponse> getCoffees();
}
