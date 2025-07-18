package org.hazem.reactive.webclientintegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("cart_itemS")
public class CartItemEntity {
    @Id
    private Integer id;

    @Column("cart_id")
    private Long cartId;

    @Column("product_id")
    private Long productId;

    private Integer quantity;
}
