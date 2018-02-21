package algrithom;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node<T>{
    T data; //����
    double quanShu; //Ȩ��
    Node lChild;    //������
    Node rChild;    //������

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
	//������������
    public Node createHaFuManTree(List<Node> nodes){
        //�ڵ�Ԫ�ش��ڻ��ߵ���2ʱ����ѭ��
        while(nodes.size()>1)
        {
            //��������
            sort(nodes);
            //�����С����λ�ڵ�
            Node lChild=nodes.get(0);
            Node rChild=nodes.get(1);
            //����С�������ڵ�"���"
            Node parent=new Node(null, lChild.quanShu+rChild.quanShu);
            parent.lChild=lChild;
            parent.rChild=rChild;
            //ɾ���Ѿ���ϵ������ڵ�
            nodes.remove(0);
            nodes.remove(0);
            //������ɵĽڵ�
            nodes.add(parent);
        }
        return nodes.get(0);    //���ظ��ڵ�
    }   

    //ð�����򣬽�nodes����Ȩ����������
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

    //������������ö�ʵ��
    public void levelTraversal(Node root){
        //������
        Queue q=new LinkedList<Object>();
        //��Ӹ��ڵ�
        q.add(root);
        while(!q.isEmpty()){
            //��һ��Ԫ�س���
            Node node=(Node) q.poll();
            System.out.print(node+" ");
            if(node.lChild!=null)
                q.add(node.lChild);
            if(node.rChild!=null)
                q.add(node.rChild); 
        }
    }

    //��ù���������Ȩ��·������
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
