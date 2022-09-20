package LockerOOD;

import javax.xml.stream.Location;
import java.util.*;

public class DeliveryMan {
    class Pair{  //用了pair 去存 物品和收货人的名字，用于快递员存好货以后通知 顾客
        Product product;
        Users userName;
        Pair(Product product, Users userName,Users userId){
            this.product = product;
            this.userName = userName;
        }
    }
    Locker locker = new Locker();
    Location location;

    Date date;
    HashSet<Integer> set = new HashSet<>();
    HashMap<Location, List<Pair>> map = new HashMap<>();
    Product product;
    Users user;
    DeliveryMan(Product product, Users user){
        this.product = product;
        this.user = user;
    }


    public void placeGroupOrder(){  // 存好货物后通知顾客
        for(Location location : map.keySet()){
            List<Pair> list = map.get(location);
            for(Pair pair : list){
                Users name = pair.userName;
                Product product = pair.product;
                int lockerId = chooseLocker(product);
                int code = generateCode();
                name.receiveCode(code,date,lockerId,location);
            }
        }
    }
    public void placeOrder(Users user, Product product,Locker locker){ // 获得locker id 和 code
        int lockerId = chooseLocker(product);
        int code = generateCode();
        user.receiveCode(code,date,lockerId,location);
    }
    public int chooseLocker(Product product){ // 获得locker id
        LockerType type =  locker.getLockerType(product);
        int id = locker.findLocker(type);
        return id;
    }
    public int generateCode(){ // 获得code
        Random random = new Random();
        int code;
        while(true){
            int val = random.nextInt(999999);
            if(!set.contains(val)){
                set.add(val);
                code = val;
                break;
            }
        }
        return code;
    }
    public List<Integer> needRefund(){ // 检查需要return的物品
        Date currTime = new Date();
        List<Integer> expiredList = new ArrayList<>();
        for( Locker.Pair pair : locker.productList){
            Product products = pair.product;
            if(currTime.getTime() - products.date.getTime() > 3){
                expiredList.add(pair.id);
            }
        }
        return expiredList;
    }
}
