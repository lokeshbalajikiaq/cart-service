package in.balu.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CartItemResponseDto {

    private Long id;
    
    private Long userId;

    private Long productId;

    private Integer quantity;

}
