package algrithom;

public class AVLTree<T extends Comparable<T>> {

    private AVLTreeNode<T> mRoot;    // �����

    // AVL���Ľڵ�(�ڲ���)
    class AVLTreeNode<T extends Comparable<T>> {
        T element;                // ֵ
        int height;         // �߶�
        AVLTreeNode<T> left;    // ����
        AVLTreeNode<T> right;    // �Һ���

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.element = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /*
 * ��ȡ���ĸ߶�
 */
    private int height(AVLTreeNode<T> tree) {
        if (tree != null)
            return tree.height;

        return 0;
    }

    public int height() {
        return height(mRoot);
    }

    /*
 * LL�������Ӧ�����(����ת)��
 *
 * ����ֵ����ת��ĸ��ڵ�
 */

    /**
     * LL�������Ӧ�����(����ת)��
     *
     * @param k2
     * @return ��ת��ĸ��ڵ�
     */
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> k2) {
        AVLTreeNode<T> k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;

        return k1;
    }

    /**
     * ���Ҷ�Ӧ�����(�ҵ���ת)��
     *
     * @param k1
     * @return ��ת��ĸ��ڵ�
     */
    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> k1) {
        AVLTreeNode<T> k2;

        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;

        return k2;
    }


    /**
     * LR�����Ҷ�Ӧ�����(��˫��ת)��
     *
     * @param k3
     * @return ��ת��ĸ��ڵ�
     */
    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> k3) {
        k3.left = rightRightRotation(k3.left);

        return leftLeftRotation(k3);
    }

    /**
     * RL�������Ӧ�����(��˫��ת)��
     *
     * @param k1
     * @return ��ת��ĸ��ڵ�
     */
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> k1) {
        k1.right = leftLeftRotation(k1.right);

        return rightRightRotation(k1);
    }


    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    /**
     * �������뵽AVL���У������ظ��ڵ�
     *
     * @param tree AVL���ĸ����
     * @param key  ����Ľ��ļ�ֵ
     * @return ���ڵ�
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            // �½��ڵ�
            return tree = new AVLTreeNode<T>(key, null, null);

        }

        int cmp = key.compareTo(tree.element);
        if (cmp < 0) {// ��key���뵽"tree��������"�����
            tree.left = insert(tree.left, key);

        } else if (cmp > 0) { // ��key���뵽"tree��������"�����
            tree.right = insert(tree.right, key);
        }

        return balance(tree);
    }


    private static final int ALLOWED_IMBALANCE = 1;

    private AVLTreeNode<T> balance(AVLTreeNode<T> tree) {
        if (tree == null) {
            return tree;
        }
        // ����ڵ����AVL��ʧȥƽ�⣬�������Ӧ�ĵ��ڡ�
        if (height(tree.left) - height(tree.right) > ALLOWED_IMBALANCE) {

            if (height(tree.left.left) >= height(tree.left.right)) {
                leftLeftRotation(tree);
            } else {
                leftRightRotation(tree);
            }
        } else if (height(tree.right) - height(tree.left) > ALLOWED_IMBALANCE) {
            if (height(tree.right.right) >= height(tree.right.left)) {
                rightRightRotation(tree);
            } else {
                rightLeftRotation(tree);
            }
        }
        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;

        return tree;
    }

    public void remove(T key) {
        AVLTreeNode<T> z;

        if ((z = search(mRoot, key)) != null)
            mRoot = remove(mRoot, z);
    }

    /*
       * (�ݹ�ʵ��)����"AVL��x"�м�ֵΪkey�Ľڵ�
      */
    private AVLTreeNode<T> search(AVLTreeNode<T> x, T key) {
        if (x == null)
            return x;

        int cmp = key.compareTo(x.element);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    /**
     * ɾ�����(z)�����ظ��ڵ�
     *
     * @param tree AVL���ĸ����
     * @param z    ��ɾ���Ľ��
     * @return ���ڵ�
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> z) {
        if (tree == null)
            return tree;

        int cmp = z.element.compareTo(tree.element);
        if (cmp > 0) {
            tree.right = remove(tree.right, z);
        } else if (cmp < 0) {
            tree.left = remove(tree.left, z);
        } else if (tree.left != null && tree.right != null) {
            tree.element = findMin(tree.right).element;
            tree.right = remove(tree.element, tree.right);
        } else {
            tree = (tree.left != null) ? tree.left : tree.right;
        }
        return balance(tree);
    }

    private AVLTreeNode<T> findMin(AVLTreeNode<T> node) {
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    public AVLTreeNode<T> remove(T t, AVLTreeNode<T> node) {
        if (node == null) {
            return node;
        }
        int compareResult = t.compareTo(node.element);
        if (compareResult > 0) {
            node.right = remove(t, node.right);
        } else if (compareResult < 0) {
            node.left = remove(t, node.left);
        } else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;

    }

    /*
     * ��ӡ"���������"
     *
     * key        -- �ڵ�ļ�ֵ
     * direction  --  0����ʾ�ýڵ��Ǹ��ڵ�;
     *               -1����ʾ�ýڵ������ĸ���������;
     *                1����ʾ�ýڵ������ĸ������Һ��ӡ�
     */
    private void print(AVLTreeNode<T> tree, T key, int direction) {
        if(tree != null) {
            if(direction==0)    // tree�Ǹ��ڵ�
                System.out.printf("%2d is root\n", tree.element, key);
            else                // tree�Ƿ�֧�ڵ�
                System.out.printf("%2d is %2d's %6s child\n", tree.element, key, direction==1?"right" : "left");

            print(tree.left, tree.element, -1);
            print(tree.right,tree.element,  1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.element, 0);
    }

	public void inOrder() {
		// TODO Auto-generated method stub
		
	}

	public void postOrder() {
		// TODO Auto-generated method stub
		
	}

	public void preOrder() {
		// TODO Auto-generated method stub
		
	}
}