package Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br>
 * 〈微信红包随机算法〉
 *
 * @author Chenpeng
 * @create 2019/4/20
 * @since 1.0.0
 */
public class RedPacket {

    private int count;//人数
    private double money;//金额

    public RedPacket(double money,int count){
        this.money=money;
        this.count=count;
    }

    public List<Double> getRandomRedPacket(){

        List<Double> list=new ArrayList<Double>();
        while(count>0){
            list.add(getRandomMoney());
        }
        return list;
    }


    public double getRandomMoney(){
        if(count==1){
            count--;
            return (double)Math.round(money*100)/100;
        }
        Random random=new Random();
        double min=0.01;
        double max=money/count*2;
        double randomMoney=random.nextDouble()*max;
        randomMoney=randomMoney<min?min:randomMoney;
        randomMoney=Math.floor(randomMoney*100)/100;
        count--;
        money-=randomMoney;
        return randomMoney;
    }

    public static void main(String[] args) {
        RedPacket redPacket=new RedPacket(100,10);
        List<Double> list=redPacket.getRandomRedPacket();
        for(Double d:list){
            System.out.println(d);
        }
    }

}
