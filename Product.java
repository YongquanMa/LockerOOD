package LockerOOD;

import java.util.Date;

public class Product {
    int height;
    int width;
    int length;
    Date date;

    ProductType type;
    Product ( int height, int width, int length, Date date, ProductType type){
        this.height = height;
        this.width = width;
        this.length = length;
        this.date = date;
        this.type = type;
    }
}
