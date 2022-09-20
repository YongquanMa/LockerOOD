package LockerOOD;

import java.util.ArrayList;
import java.util.List;

public class Locker{
    List<Pair> productList;
    int size = 30;
    boolean isFull;
    int numberOfLockers;
    boolean[] isAvailable = new boolean[30];
    private LockerOOD.LockerType LockerType;

    class Pair{
        Product product;
        int id;
        Pair(Product product, int id){
            this.product = product;
            this.id = id;
        }
    }
    Locker(){
        this.size = size;
        this.productList =  new ArrayList<>();
    }

    public void addItem(Product product, List<Pair> productList){ // locker 里添加新的货物
        productList.add(new Pair(product,findLocker(LockerType)));
    }

    public LockerType getLockerType (Product product) { // 选择每个物品适合的 locker type
        if(product.length < 10 && product.width < 10 && product.height < 10){
            return LockerType.SMALL;
        }else if(product.length < 20 && product.width < 20 && product.height < 20){
            return LockerType.MEDIUM;
        }
        return LockerType.LARGE;
    }
    public int findLocker(LockerType type){  // 根据type 选locker id
        int id  = 0;
        if(type == LockerType.LARGE){
            for(int i = 19; i < 30; i++){
                if(isAvailable[i] != true){
                    isAvailable[i] = true;
                    id = i;
                    break;
                }
            }
        }
        else if (type == LockerType.MEDIUM){
            for(int i = 9; i < 19; i++){
                if(isAvailable[i] != true){
                    isAvailable[i] = true;
                    id = i;
                    break;
                }
            }
        } else if (type == LockerType.SMALL){
            for(int i = 0; i < 9; i++){
                if(isAvailable[i] != true){
                    isAvailable[i] = true;
                    id = i;
                    break;
                }
            }
        }
        numberOfLockers ++;
        return id;
    }

    public boolean isFull () { // 检查是否满了
        return numberOfLockers == size;
    }
}
