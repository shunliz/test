package algrithom;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node<T>{
    T data; //数据
    double quanShu; //权数
    Node lChild;    //左子树
    Node rChild;    //右子树

    public Node(T data, double quanShu) {
        super();
        this.data = data;
        this.quanShu = quanShu;
    }

    @Override
    public String toString() {
        return "Node["+data+" "+quanShu+"]";
    }

}

public class HaFuManTree {
	//创建哈夫曼树
    public Node createHaFuManTree(List<Node> nodes){
        //节点元素大于或者等于2时继续循环
        while(nodes.size()>1)
        {
            //升序排序
            sort(nodes);
            //获得最小的两位节点
            Node lChild=nodes.get(0);
            Node rChild=nodes.get(1);
            //将最小的两个节点"结合"
            Node parent=new Node(null, lChild.quanShu+rChild.quanShu);
            parent.lChild=lChild;
            parent.rChild=rChild;
            //删除已经结合的两个节点
            nodes.remove(0);
            nodes.remove(0);
            //添加生成的节点
            nodes.add(parent);
        }
        return nodes.get(0);    //返回根节点
    }   

    //冒泡排序，将nodes按照权数升序排序
    public List<Node> sort(List<Node> nodes){
        for(int i=0;i<nodes.size();i++)
        {
            for(int j=i;j<nodes.size();j++)
            {
                if(nodes.get(i).quanShu>nodes.get(j).quanShu)
                {
                    Node node = nodes.get(i);
                    nodes.set(i,nodes.get(j));
                    nodes.set(j, node);
                }
            }
        }
        return nodes;
    }

    //层序遍历，利用队实现
    public void levelTraversal(Node root){
        //创建队
        Queue q=new LinkedList<Object>();
        //添加根节点
        q.add(root);
        while(!q.isEmpty()){
            //第一个元素出队
            Node node=(Node) q.poll();
            System.out.print(node+" ");
            if(node.lChild!=null)
                q.add(node.lChild);
            if(node.rChild!=null)
                q.add(node.rChild); 
        }
    }

    //获得哈夫曼树带权数路径长度
    public double getPathNum(Node root,int height){
        if(root==null){
            return 0;
        }else{
            if(root.lChild==null&&root.rChild==null){
                return root.quanShu*height;
            }else{
                return getPathNum(root.lChild, height+1)+getPathNum(root.rChild, height+1);
            }
        }
    }
}
