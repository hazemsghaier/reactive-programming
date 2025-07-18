package org.hazem.reactive.webclientintegration.dto.fakeApinStore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductApiDto {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
