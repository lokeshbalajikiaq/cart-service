package in.balu.service;

import in.balu.dto.CartItemRequestDto;
import in.balu.dto.CartItemResponseDto;
import in.balu.exception.ResourceNotFoundException;
import in.balu.model.CartItem;
import in.balu.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItemResponseDto addToCart(CartItemRequestDto request) {

        // TODO : Product Services API need to call to fetch Product Information

        // TODO : User Service API need to call to Fetch User Details

        CartItem cartItem = new CartItem();
        BeanUtils.copyProperties(request, cartItem);

        cartItemRepository.save(cartItem);
        return mapToDTO(cartItem);
    }

    @Override
    public List<CartItemResponseDto> getUserCart(Long userId) {

        return cartItemRepository.findByUserId(userId).stream()
//                .map(cartItem -> mapToDTO(cartItem))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removeItem(Long userId, Long productId) {

        cartItemRepository.deleteByUserIdAndProductId(userId, productId);

    }

    @Override
    public CartItemResponseDto updateQuantity(CartItemRequestDto request) {

        CartItem cartItem = cartItemRepository.findByUserIdAndProductId(request.getUserId(), request.getProductId())
//                .orElseThrow(() -> new RuntimeException("Item not in the cart"));
                .orElseThrow(() -> new ResourceNotFoundException("Items not in the cart"));

        // Not performing any action. Directly setting the quantity
        cartItem.setQuantity(request.getQuantity());

        CartItem dbCart = cartItemRepository.save(cartItem);

        return mapToDTO(dbCart);
    }

    @Override
    @Transactional
    public void clearCart(Long userId) {

        cartItemRepository.deleteByUserId(userId);

    }

    private CartItemResponseDto mapToDTO(CartItem cartItem) {

        CartItemResponseDto dto = new CartItemResponseDto();

        BeanUtils.copyProperties(cartItem, dto);

        return dto;

    }
}