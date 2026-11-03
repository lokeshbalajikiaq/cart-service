package in.balu.service;

import in.balu.dto.CartItemRequestDto;
import in.balu.dto.CartItemResponseDto;
import java.util.*;

public interface CartService {

    CartItemResponseDto addToCart(CartItemRequestDto request);

    List<CartItemResponseDto> getUserCart(Long userId);

    void removeItem(Long userId, Long productId);

    CartItemResponseDto updateQuantity(CartItemRequestDto request);

    void clearCart(Long userId);

}
