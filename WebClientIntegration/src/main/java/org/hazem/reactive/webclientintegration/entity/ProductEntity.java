package org.hazem.reactive.webclientintegration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("products")
public class ProductEntity {

    @Id
    private Integer id;

    private String title;

    private String description;

    private String category;

    private String image;

    private Double price;

    @Column("rating_rate")
    private Double ratingRate;

    @Column("rating_count")
    private Integer ratingCount;
}
