package org.hazem.reactive.webclientintegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("cart")
public class CartEntity {
    @Id
    private Integer id;

    @Column("user_id")
    private Long userId;

    @Column("created_at")
    private LocalDate createdAt;
}
