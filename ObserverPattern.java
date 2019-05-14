package Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 〈一句话功能简述〉<br>
 * 〈观察者模式〉
 *
 * @author Chenpeng
 * @create 2019/4/21
 * @since 1.0.0
 */
public class ObserverPattern {

    public static void main(String[] args) {

        ProductList productList=ProductList.getInstance();
        JingDongObserver jingDongObserver=new JingDongObserver();
        TaobaoObserver taobaoObserver=new TaobaoObserver();
        productList.addObserver(jingDongObserver);
        productList.addObserver(taobaoObserver);
        productList.addProduct("新增产品 1");

    }

}

class ProductList extends Observable{
    private List<String> productList=null;
    private static ProductList instance;
    private ProductList(){

    }

    public static ProductList getInstance(){
        if(instance==null){
            instance=new ProductList();
            instance.productList=new ArrayList<String>();
        }
        return instance;
    }

    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }

    public void addProduct(String newProduct){
        productList.add(newProduct);
        System.out.println("产品列表新增了产品："+newProduct);
        this.setChanged();
        this.notifyObservers(newProduct);
    }
}

class JingDongObserver implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        String newProduct=(String) arg;
        System.err.println("发送新产品【"+newProduct+"】同步到京东商城");
    }
}

class TaobaoObserver implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        String newProduct=(String) arg;
        System.err.println("发送新产品【"+newProduct+"】同步到淘宝商城");
    }
}
