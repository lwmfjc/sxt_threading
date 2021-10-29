package fife.communicate;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 仓库 放水果的
 */
public class Stock {
    private  Vector<Fruit> fruits = new Vector<>();

    public static Stock stock=new Stock();

    public boolean isEmpty() {
        return fruits.isEmpty();
    }

    public boolean isFull(){
        return fruits.size()>0;
    }

    public  Fruit getFruit() {
        if (fruits.size() > 0) {
            return fruits.remove(0);
        } else {
            return null;
        }
    }

    public  void putFruit(Fruit fruit) {
        fruits.add(0,fruit);
    }
}
