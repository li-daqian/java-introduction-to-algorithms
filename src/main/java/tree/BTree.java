package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiDaQian
 */
public class BTree<T extends Comparable> {

    private Node root;

    private int t;

    public BTree(int t) {
        this.t = t;
        root = new Node();
        root.leaf = true;
    }

    public Result search(T data) {
        return search(root, data);
    }

    @SuppressWarnings("unchecked")
    private Result search(Node node, T data) {
        int i = 0;
        while (i < node.length && data.compareTo(node.key.get(i)) > 0) {
            i += 1;
        }
        if (i < node.length && data.compareTo(node.key.get(i)) == 0) {
            return new Result(node, i);
        } else if (node.leaf) {
            return null;
        } else {
            return search(node.child.get(i), data);
        }
    }

    public void insert(T data) {
        Node r = root;
        // 节点已满
        if (r.length == 2 * t - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.length = 0;
            setNode(s.child, 0, r);
            splitChild(s, 0);
            insertNonFull(s, data);
        }
        // 节点未满
        else {
            insertNonFull(r, data);
        }
    }

    @SuppressWarnings("unchecked")
    private void insertNonFull(Node x, T data) {
        int i = x.length - 1;
        if (x.leaf) {
            while (i >= 0 && data.compareTo(x.key.get(i)) < 0) {
                setKey(x.key, i + 1, x.key.get(i));
                i--;
            }
            setKey(x.key, i + 1, data);
            x.length += 1;
        } else {
            while (i >= 0 && data.compareTo(x.key.get(i)) < 0) {
                i--;
            }
            i += 1;
            if (x.child.get(i).length == 2 * t - 1) {
                splitChild(x, i);
                if (data.compareTo(x.key.get(i)) > 0) {
                    i += 1;
                }
            }
            insertNonFull(x.child.get(i), data);
        }
    }

    private void setKey(List<T> list, int index, T data) {
        if (index == list.size()) {
            list.add(data);
        } else {
            list.set(index, data);
        }
    }

    private void setNode(List<Node> list, int index, Node node) {
        if (index == list.size()) {
            list.add(node);
        } else {
            list.set(index, node);
        }
    }

    private void splitChild(Node x, int i) {
        // 创建节点z 并将y的t-1个关键字以及相应的t个孩子给它
        Node z = new Node();
        // x的第i个孩子
        Node y = x.child.get(i);
        z.leaf = y.leaf;
        z.length = t - 1;

        // 将y的t-1关键字给z
        for (int j = 0; j < z.length; j++) {
            setKey(z.key, j, y.key.get(j + t));
        }
        // 将y的t-1关键字的孩子给z
        if (!y.leaf) {
            for (int j = 0; j < z.length + 1; j++) {
                setNode(z.child, j, y.child.get(j + t));
            }
        }
        // 调整y的关键字个数
        y.length = t - 1;
        // 把z插入至x的i孩子
        for (int j = x.length; j >= i + 1; j--) {
            setNode(x.child, j + 1, x.child.get(j));
        }
        setNode(x.child, i + 1, z);
        // 把y关键字插入至x
        for (int j = x.length - 1; j >= i; j--) {
            setKey(x.key, j + 1, x.key.get(j));
        }
        setKey(x.key, i, y.key.get(t - 1));
        // 调整x节点数量
        x.length = x.length + 1;
    }

    public class Node {
        List<T> key;
        List<Node> child;
        int length;
        boolean leaf;

        public Node() {
            this(new ArrayList<T>(), new ArrayList<Node>(), 0, true);
        }

        public Node(List<T> key, List<Node> child, int length, boolean leaf) {
            this.key = key;
            this.child = child;
            this.length = length;
            this.leaf = leaf;
        }
    }

    public class Result {
        Node node;
        int index;

        Result(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
