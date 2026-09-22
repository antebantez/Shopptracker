package com.antebantez.shopptracker.shoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
}
