package Problem;

/**
 * 〈一句话功能简述〉<br>
 * 〈hashMap的简单实现〉
 *
 * @author Chenpeng
 * @create 2019/4/17
 * @since 1.0.0
 */
public class MyHashMap<K,V> {

    private static final int DEFAULT_SIZE=1<<4;
    private Entry<K,V>[] data;
    private int capacity;
    private int size;

    public MyHashMap(){
        this(DEFAULT_SIZE);
    }

    public MyHashMap(int capacity){
        if(capacity>0){
            data=new Entry[capacity];
            size=0;
            this.capacity=capacity;
        }else{
            System.out.println("error");
        }
    }

    public void put(K key,V value){
        if(key==null)
            System.out.println("error");
        int hash=hash(key);
        Entry<K,V> nE=new Entry<K,V>(key,value,null);
        Entry<K,V> mE=data[hash];

        while(mE!=null){
            if(mE.key.equals(key)){
                mE.value=value;
                return;
            }
            mE=mE.next;
        }

        nE.next=data[hash];
        data[hash]=nE;
        size++;
    }

    public V get(K key){
        if(key==null)
            System.out.println("error");
        int hash=hash(key);
        Entry<K,V> mE=data[hash];
        while(mE!=null) {
            if (mE.key.equals(key)) {
                return mE.value;
            }
            mE = mE.next;
        }
        return null;
    }


    public int size(){
        return size;
    }

    private int hash(K key){
        int h=0;
        if(key==null) {
            h = 0;
        }else{
            h=key.hashCode()^(key.hashCode()>>>16);
        }
        h=h%capacity;
        return h;
    }
    //内部entry类
    private class Entry<K,V>{

        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key,V value,Entry<K,V> next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }


    public static void main(String[] args) {
        MyHashMap<String,Integer> myHashMap=new MyHashMap<>();

        myHashMap.put("霍晨鹏",34);
        myHashMap.put("霍晨鹏1",35);
        myHashMap.put("霍晨鹏2",36);

        System.out.println(myHashMap.size());

    }

}
