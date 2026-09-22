package com.antebantez.shopptracker.shoppinglist;

import com.antebantez.shopptracker.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "shopping_list_member")
public class ShoppingListMember {

    @EmbeddedId
    private ShoppingListMemberId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("shoppingListId")
    @JoinColumn(name = "shopping_list_id", nullable = false)
    private ShoppingList shoppingList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShoppingListRole role;

    protected ShoppingListMember() {}

    public ShoppingListMember(ShoppingList shoppingList, User user, ShoppingListRole role) {
        this.shoppingList = shoppingList;
        this.user = user;
        this.role = role;
        this.id = new ShoppingListMemberId(shoppingList.getId(), user.getId());
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public User getUser() {
        return user;
    }

    public ShoppingListRole getRole() {
        return role;
    }
}
