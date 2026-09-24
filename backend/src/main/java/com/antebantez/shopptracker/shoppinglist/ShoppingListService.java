package com.antebantez.shopptracker.shoppinglist;

import com.antebantez.shopptracker.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListMemberRepository shoppingListMemberRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository,
                               ShoppingListMemberRepository shoppingListMemberRepository
    ) {
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingListMemberRepository = shoppingListMemberRepository;
    }

    @Transactional
    public ShoppingList create(String name, User user) {
        ShoppingList shoppingList = new ShoppingList(name, user);

        ShoppingList savedList = shoppingListRepository.save(shoppingList);

        ShoppingListMember shoppingListMember = new ShoppingListMember(
                savedList,
                user,
                ShoppingListRole.OWNER);
        shoppingListMemberRepository.save(shoppingListMember);

        return savedList;
    }
}
