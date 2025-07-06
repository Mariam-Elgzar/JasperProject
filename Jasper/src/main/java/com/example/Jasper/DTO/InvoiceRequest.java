package com.example.Jasper.DTO;

import com.example.Jasper.model.InvoiceItem;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InvoiceRequest {
    private String invoiceNumber;
    private String customerName;
    private String customerAddress1;
    private String customerAddress2;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date issueDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dueDate;

    private List<InvoiceItem> items;
    private Double subtotal;
    private Double discount;
    private Double taxRate;
    private String terms;
    private String conditions;
}