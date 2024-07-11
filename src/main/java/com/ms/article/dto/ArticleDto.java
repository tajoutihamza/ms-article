package com.ms.article.dto;

public class ArticleDto {
    private String name;
    private long quantity;
    private String stockZone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getStockZone() {
        return stockZone;
    }

    public void setStockZone(String stockZone) {
        this.stockZone = stockZone;
    }
}
