package com.antebantez.shopptracker.shoppinglist;

import com.antebantez.shopptracker.common.exception.AuthenticatedUserNotFoundException;
import com.antebantez.shopptracker.user.User;
import com.antebantez.shopptracker.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping-lists")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;
    private final UserRepository userRepository;

    public ShoppingListController(ShoppingListService shoppingListService, UserRepository userRepository) {
        this.shoppingListService = shoppingListService;
        this.userRepository = userRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListResponse create(@Valid @RequestBody CreateShoppingListRequest request, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow(() -> new AuthenticatedUserNotFoundException("Authenticated user not found"));

        ShoppingList shoppingList = shoppingListService.create(request.name(), user);

        return new ShoppingListResponse(shoppingList.getId(), shoppingList.getName());

    }
}
