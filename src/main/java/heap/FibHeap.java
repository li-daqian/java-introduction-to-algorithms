package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 斐波那契堆
 * @author LiDaQian
 */
public class FibHeap<T extends Comparable> {

    private Node min;
    private int n;

    public FibHeap() {
        this.n = 0;
        this.min = null;
    }

    /**
     * 插入元素
     * @param element 元素
     */
    @SuppressWarnings("unchecked")
    public void insert(T element) {
        Node x = new Node();
        x.key = element;
        x.degree = 0;
        x.mark = false;
        x.parent = null;
        x.child = null;

        insertNode(x);

        n += 1;
    }

    /**
     * 聚合两个斐波那契堆
     * @param h1 斐波那契堆
     * @param h2 斐波那契堆
     * @return 新斐波那契堆
     */
    @SuppressWarnings("unchecked")
    public FibHeap<T> union(FibHeap<T> h1, FibHeap<T> h2) {
        FibHeap<T> h = new FibHeap<>();

        h.min = h1.min;
        // concatenate the root list of h2 with the root list of h
        if (h.min != null && h2.min != null) {
            Node a = h1.min;
            Node b = h2.min;

            Node temp = a.right;
            a.right = b.right;
            b.right.left = a;
            b.right = temp;
            temp.left = b;
        }

        if (h1.min == null || (h2.min != null && h2.min.key.compareTo(h1.min.key) < 0)) {
            h.min = h2.min;
        }

        h.n = h1.n + h2.n;

        return h;
    }

    /**
     * 抽取最小节点
     * @return 最小值
     */
    public T extractMin() {
        if (min == null) {
            return null;
        }

        Node z = min;

        // add child to the root list
        while (min.child != null) {
            Node child = min.child;
            removeNode(child);
            if (child.right != child) {
                min.child = child.right;
            } else {
                min.child = null;
            }
            insertNode(child);
            child.parent = null;
        }
        // remove z from the root list
        removeNode(z);
        if (min == min.right) {
            min = null;
        } else {
            min = min.right;
            consolidate();
        }

        n -= 1;

        return z.key;
    }

    /**
     * 关键字减值
     * @param x 节点
     * @param key 新值
     */
    @SuppressWarnings("unchecked")
    public void decreaseKey(Node x, T key) {
        if (key.compareTo(x.key) > 0) {
            throw new IllegalArgumentException("new key is greater than current key.");
        }
        x.key = key;

        Node y = x.parent;
        if (y != null && x.key.compareTo(y.key) < 0) {
            // 将node从父节点parent中剥离出来，并将node添加到根链表中
            cut(x, y);
            cascadingCut(y);
        }

        if (x.key.compareTo(min.key) < 0) {
            min = x;
        }
    }

    /**
     * 删除节点
     * 该方法仅支持 T = Integer.class
     * @param node 节点
     */
    @SuppressWarnings("unchecked")
    public void delete(Node node) {
        decreaseKey(node, (T) node.min());
        extractMin();
    }

    /**
     * 对节点node进行 级联剪切
     * 级联剪切：如果减小后的结点破坏了最小堆性质，
     *     则把它切下来(即从所在双向链表中删除，并将
     *     其插入到由最小树根节点形成的双向链表中)，
     *     然后再从"被切节点的父节点"到所在树根节点递归执行级联剪枝
     * @param node 节点
     */
    private void cascadingCut(Node node) {
        Node parent = node.parent;
        if (parent == null) {
            return;
        }
        if (!node.mark) {
            node.mark = true;
        } else {
            cut(node, parent);
            cascadingCut(parent);
        }
    }

    /**
     * 将node从父节点parent的子链接中剥离出来
     * 并使node成为根链表中的一员
     * @param node 要剥离的节点
     * @param parent 剥离节点的父节点
     */
    private void cut(Node node, Node parent) {
        removeNode(node);
        renewDegree(parent, node.degree);
        if (node.right == node) {
            parent.child = null;
        } else {
            parent.child = node.right;
        }

        node.parent = null;
        node.left = node.right = node;
        node.mark = false;
        addNode(node, min);
    }

    /**
     * 修改度数
     * @param parent 父节点
     * @param degree 减少的度数
     */
    private void renewDegree(Node parent, int degree) {
        parent.degree -= degree;
        if (parent.parent != null) {
            renewDegree(parent.parent, degree);
        }
    }

    /**
     * 添加至根节点
     * @param node
     */
    @SuppressWarnings("unchecked")
    private void insertNode(Node node) {
        if (min == null) {
            node.left = node;
            node.right = node;
            min = node;
        } else {
            addNode(node, min);
            if (node.key.compareTo(min.key) < 0) {
                min = node;
            }
        }
    }

    private void removeNode(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    /**
     * 合并斐波那契堆的根链表中相同度数的树
     */
    @SuppressWarnings("unchecked")
    private void consolidate() {
        List<Node> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(null);
        }

        int d;
        Node x, y, temp;
        // 合并相同度的根节点，使每个度数的树唯一
        while (min != null) {
            x = removeMin();
            d = x.degree;
            while (a.get(d) != null) {
                y = a.get(d);
                if (x.key.compareTo(y.key) > 0) {
                    temp = x;
                    x = y;
                    y = temp;
                }
                link(y, x);
                a.set(d, null);
                d += 1;
            }
            a.set(d, x);
        }
        min = null;

        for (int i = 0; i < n; i++) {
            if (a.get(i) != null) {
                if (min == null) {
                    min = a.get(i);
                } else {
                    addNode(a.get(i), min);
                    if (a.get(i).key.compareTo(min.key) < 0) {
                        min = a.get(i);
                    }
                }
            }
        }
    }

    private Node removeMin() {
        Node result = min;

        if (min == min.right) {
            min = null;
        } else {
            removeNode(min);
            min = min.right;
        }

        return result;
    }

    /**
     * 把y链接至root
     * @param y 节点
     * @param root 节点
     */
    private void link(Node y, Node root) {
        removeNode(y);
        if (root.child == null) {
            root.child = y;
        } else {
            addNode(y, root.child);
        }

        y.parent = root;
        root.degree++;
        y.mark = false;
    }

    /**
     * 将"单个节点node"加入"链表root"之前
     */
    private void addNode(Node node, Node root) {
        node.left = root.left;
        root.left.right = node;
        node.right = root;
        root.left = node;
    }

    class Node implements Number {
        T key;
        int degree;
        boolean mark;
        Node parent;
        Node child;
        Node left;
        Node right;

        @Override
        public Object min() {
            return Integer.MIN_VALUE;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return degree == node.degree &&
                    mark == node.mark &&
                    Objects.equals(key, node.key) &&
                    Objects.equals(parent, node.parent) &&
                    Objects.equals(child, node.child) &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, degree, mark, parent, child, left, right);
        }
    }

    interface Number<T> {
        T min();
    }
}
