package Problem;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈字符串去重并排序〉
 *
 * @author Chenpeng
 * @create 2019/5/6
 * @since 1.0.0
 */
public class StringRemoveRepetitionAndSort {


    public static Trie readFile(String path) throws IOException {

        FileInputStream fis=new FileInputStream(path);
        InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
        BufferedReader br=new BufferedReader(isr);
        Trie trie=new Trie();
        String line="";
        while((line=br.readLine())!=null){
            trie.insert(line);
        }
        //trie.preTraverse(trie.root);
        br.close();
        isr.close();
        fis.close();
        return trie;

    }

    public static void writeFile(Trie trie) throws IOException{
        FileOutputStream fos=new FileOutputStream(new File("D:/test02.txt"));
        OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter bw=new BufferedWriter(osw);

        LinkedList<Character> chars=new LinkedList<>();
        LinkedList<String> stringList=new LinkedList<>();
        trie.traversal(trie.root,chars,stringList);

        for(String str:stringList){
            bw.write(str+"\r\n");
        }
        bw.close();
        osw.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException{
        Trie trie=StringRemoveRepetitionAndSort.readFile("D:/test01.txt");
        StringRemoveRepetitionAndSort.writeFile(trie);
    }



}

class TrieNode{

    public char val;  //节点的值
    public TrieNode[] children;   //孩子节点
    //public boolean isLeaf;  //是否是叶子节点
    public boolean isEnd;   //是否是一个字符串的结尾

    TrieNode(){
        children=new TrieNode[128];
    }

}

class Trie{

    public TrieNode root;
    Trie(){
        root=new TrieNode();
    }

    public void insert(String str){
        if(str==null||str.length()==0)
            return;

        TrieNode node=root;
        char[] chars=str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(node.children[chars[i]]==null){
                node.children[chars[i]]=new TrieNode();
                node.children[chars[i]].val=chars[i];
            }
            node=node.children[chars[i]];
        }
        node.isEnd=true;

    }



    public void traversal(TrieNode root,LinkedList<Character> charList, LinkedList<String> stringList){

        for(int i=0;i<128;i++){
            TrieNode trieNode=root.children[i];
            if(trieNode!=null) {
                charList.add(trieNode.val);
                if(trieNode.isEnd){
                    StringBuilder sb=new StringBuilder();
                    for(Character character:charList){
                        sb.append(character);
                    }
                    stringList.add(sb.toString());
                }
                traversal(trieNode,charList,stringList);
                charList.removeLast();
            }
        }

    }

    public void preTraverse(TrieNode node){
        if(node!=null){
            System.out.println(node.val);
            for(TrieNode trieNode:node.children){
                preTraverse(trieNode);
            }
        }
    }


}
