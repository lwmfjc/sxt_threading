package com.com.hello3;
//生产的商品
public class Product {

    private String name;//名字
    private int price;//价格
    private boolean isProduced;

    public boolean isProduced() {
        return isProduced;
    }

    public void setProduced(boolean produced) {
        isProduced = produced;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
