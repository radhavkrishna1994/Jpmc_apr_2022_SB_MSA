package com.training.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Book {

private String isbn;

private String title;
private double price;
private long stock;
private int qty;
private double amount;


}
