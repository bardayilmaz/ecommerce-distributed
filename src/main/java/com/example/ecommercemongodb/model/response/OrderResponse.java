package com.example.ecommercemongodb.model.response;

import com.example.ecommercemongodb.entity.Product;
import com.example.ecommercemongodb.entity.Order;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderResponse {

    private String id;
    private LocalDateTime orderDate;
    private List<Product> products;

    public static OrderResponse fromEntity(Order order, List<Product> products) {
        return OrderResponse.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .products(products)
                .build();
    }
}
