package com.ms.article.dto;

public class DtoArticle {
    private String name;
    private long quantity;
    private StockDto stockDto;

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

    public StockDto getStockDto() {
        return stockDto;
    }

    public void setStockDto(StockDto stockDto) {
        this.stockDto = stockDto;
    }
}
