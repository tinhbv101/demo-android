package com.example.myapplication.SQLiteTest;

public class ProductModel {
    private Integer id;
    private String name;
    private Integer inStock;

    public ProductModel(Integer id, String name, Integer inStock) {
        this.id = id;
        this.name = name;
        this.inStock = inStock;
    }

    public ProductModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inStock=" + inStock +
                '}';
    }
}
