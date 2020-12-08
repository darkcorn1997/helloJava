package collection; // 二叉树排序

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Node leftNode;
    private Node rightNode;
    private Object value;

    public void add(Object v) {
        if (null==value) {value=v;}
        else {
            if ((Integer)v - (Integer)value <= 0) {
                if (null==leftNode) {leftNode=new Node();}
                leftNode.add(v);
            }
            else {
                if (null==rightNode) {rightNode=new Node();}
                rightNode.add(v);
            }
        }
    }

    public List<Object> values () {
        List<Object> values = new ArrayList<>();
        if (null != leftNode) {values.addAll(leftNode.values());}
        values.add(value);
        if (null != rightNode) {values.addAll(rightNode.values());}
        return values;
    }


    public static void main(String[] args) {
        int[] random = new int[] {67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        Node roots = new Node();
        for (int r:random) {
            roots.add(r);
        }
        System.out.println(roots.values());
    }
}
