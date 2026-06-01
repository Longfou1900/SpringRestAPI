package co.istad.longfou.restapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateCoffeeRequest(

        //set constriants
        @NotBlank(message = "Name is required")
        @Size(min= 3, max = 255)
        String name,

        @NotBlank(message = "Description is required")
        @Size(min= 3, max = 10000)
        String description,

        @NotNull(message = "Price is required")
        @Positive(message = "Price must be positive")
        BigDecimal price
) {
}

