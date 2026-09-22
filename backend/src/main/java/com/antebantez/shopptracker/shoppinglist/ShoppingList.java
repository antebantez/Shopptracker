package com.antebantez.shopptracker.shoppinglist;

import com.antebantez.shopptracker.user.User;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private OffsetDateTime createdAt;

    protected ShoppingList() {
    }

    public ShoppingList(String name, User createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
