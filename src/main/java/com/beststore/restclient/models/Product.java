package com.beststore.restclient.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Product {

    private int id;

    private String name;

    private String brand;

    private String category;

    private double price;

    private String description;

    private Date createdAt;
}
