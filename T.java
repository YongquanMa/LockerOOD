package LockerOOD;

import java.util.Date;

public class T {
    public static void main ( String[] args ) {
        Date curr = new Date();
        Locker locker = new Locker();
        Product product = new Product(11,11,11, curr, ProductType.MEDIUM);
        Users users = new Users("bob","001");
        DeliveryMan deliveryMan = new DeliveryMan(product,users);
        deliveryMan.placeOrder(users,product,locker);
    }
}
