package com.satyanand.ecomspringapp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDTO {

    private int id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
