package Problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈LRU算法实现〉
 *
 * @author Chenpeng
 * @create 2019/4/29
 * @since 1.0.0
 */
public class LRUCache {

    private class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
            pre=next=null;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    private Map<Integer,Node> map;

    public LRUCache(int size) {
        head = null;
        tail = null;
        size = 0;
        map = new HashMap<>();
    }

    public int get(int key){
        Node node=map.get(key);
        if(node!=null){
            levelUp(node);
            return node.value;
        }
        return -1;
    }

    private void levelUp(Node node){
        if(head!=node){
            Node pre=node.pre;
            Node next=node.next;
            pre.next=next;
            if(tail==node){
                tail=pre;
            }else{
                next.pre=pre;
            }
            head.pre=node;
            node.next=head;
            node.pre=null;
            head=node;
        }
    }

    public void put(int key,int value){
        Node target=map.get(key);
        if(target!=null){
            target.value=value;
            levelUp(target);
        }else{
            if(size==map.size()){
                Node delNode=tail;
                tail=delNode.pre;
                if(tail!=null){
                    tail.next=null;
                }
                delNode.pre=null;
                map.remove(delNode.key);
            }else{
                size++;
            }

            Node node=new Node(key,value);
            if(head==null||tail==null){
                head=node;
                tail=node;
            }else{
                head.pre=node;
                node.next=head;
                head=node;
            }
            map.put(key,node);
        }

    }



}
