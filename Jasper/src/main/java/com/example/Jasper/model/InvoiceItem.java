package com.example.Jasper.model;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem {
    private String itemService;
    private String description;
    private Integer quantity;
    private Double rate;
    private Double amount;

}