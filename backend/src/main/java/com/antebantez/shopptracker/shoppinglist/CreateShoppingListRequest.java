package com.antebantez.shopptracker.shoppinglist;

import jakarta.validation.constraints.NotBlank;

public record CreateShoppingListRequest (
        @NotBlank String name
){
}
