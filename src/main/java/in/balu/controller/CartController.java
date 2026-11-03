package in.balu.controller;

import in.balu.dto.CartItemRequestDto;
import in.balu.dto.CartItemResponseDto;
import in.balu.repository.CartItemRepository;
import in.balu.service.CartService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/cart")
@Slf4j

public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CartItemResponseDto addItemToCart(@Valid @RequestBody CartItemRequestDto request) {
        return cartService.addToCart(request);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CartItemResponseDto updateQuantity(@Valid @RequestBody CartItemRequestDto request) {

        return cartService.updateQuantity(request);

    }

    @GetMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CartItemResponseDto> getCartByUserId(@PathVariable Long userId) {

        return cartService.getUserCart(userId);

    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void clearUserCart(@PathVariable Long userId) {

        cartService.clearCart(userId);

    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeItemFromCart(@PathVariable Long productId, @RequestParam Long userId) {

        cartService.removeItem(userId, productId);

    }

}
