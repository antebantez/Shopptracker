package com.antebantez.shopptracker.shoppinglist;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ShoppingListMemberId implements Serializable {

    private Long shoppingListId;
    private Long userId;

    protected ShoppingListMemberId() {
    }

    public ShoppingListMemberId(Long shoppingListId, Long userId) {
        this.shoppingListId = shoppingListId;
        this.userId = userId;
    }

    public Long getShoppingListId() {
        return shoppingListId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingListMemberId that)) return false;

        return Objects.equals(shoppingListId, that.shoppingListId)
                && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingListId, userId);
    }
}