package com.satyanand.ecomspringapp.dto.response;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductResponseDTO {
    private Long id;
    private String image;
    private String color;
    private double price;
    private String description;
    private int discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;

    private CategorySummaryDTO category;

    private Instant createdAt;
    private Instant updatedAt;
}
