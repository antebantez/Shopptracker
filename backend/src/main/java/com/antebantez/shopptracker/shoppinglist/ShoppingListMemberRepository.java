package com.antebantez.shopptracker.shoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListMemberRepository extends JpaRepository<ShoppingListMember, ShoppingListMemberId> {
}
