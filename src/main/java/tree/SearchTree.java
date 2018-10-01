package tree;

/**
 * @author LiDaQian
 */
public class SearchTree {

    private Node root;

    /**
     * 先序遍历
     */
    public void preOrderTreeWalk() {
        preOrderTreeWalk(root);
    }

    /**
     * 中序遍历
     */
    public void inOrderTreeWalk() {
        inOrderTreeWalk(root);
    }

    /**
     * 后序遍历
     */
    public void postOrderTreeWalk() {
        postOrderTreeWalk(root);
    }

    /**
     * 判断二叉树是有key
     * 采用递归算法
     * @param k key
     * @return 是否有key
     */
    public boolean search(int k) {
        return search(k, root);
    }

    /**
     * 判断二叉树是有key
     * 采用循环算法
     * @param k key
     * @return 是否有key
     */
    public boolean iterativeSearch(int k) {
        Node node = root;
        while (node != null && node.key != k) {
            if (k < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node != null;
    }

    /**
     * 返回二叉树最小值
     * @return 最小值
     */
    public Integer minimum() {
        Node node = minimumNode(root);
        return node == null ? null : node.key;
    }

    /**
     * 返回二叉树最大值
     * @return 最大值
     */
    public Integer maximum() {
        Node node = root;
        while (node != null && node.right != null) {
            node = node.right;
        }
        return node == null ? null : node.key;
    }

    /**
     * 插入二叉树
     * @param k 值
     */
    public int insert(int k) {
        Node n = root;
        while (n != null) {
            if (k < n.key) {
                if (n.left == null) {
                    n.left = new Node(k, null, null, n);
                    break;
                }
                n = n.left;
            } else {
                if (n.right == null) {
                    n.right = new Node(k, null, null, n);
                    break;
                }
                n = n.right;
            }
        }
        if (n == null) {
            root = new Node(k, null, null, null);
        }
        return k;
    }

    /**
     * 删除二叉树种中的值
     * 分三种情况<br/>
     * 1.没有子节点，直接删除，修改k的父节点的子节点为null<br/>
     * 2.只有一个节点，则交换两者的位置
     * 3.有两个节点，找到k的后继节点（如果后继节点不是k的子节点，则把后继节点变成k子节点）， 交换两者位置
     * @param k 值
     * @return 是否删除成功
     */
    public boolean delete(int k) {
        Node node = searchNode(k);
        if (node == null) {
            return false;
        }

        if (node.left == null) {
            transplant(node, node.right);
        } else if (node.right == null) {
            transplant(node, node.left);
        } else {
            Node y = minimumNode(node.right);
            if (y.parent != node) {
                transplant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }
            transplant(node, y);
            y.left = node.left;
            y.left.parent = y;
        }

        return true;
    }

    /**
     * 替换节点
     * @param source 被替换节点
     * @param replacement 替换节点
     */
    private void transplant(Node source, Node replacement) {
        if (source.parent == null) {
            root = replacement;
        } else if (source == source.parent.left) {
            source.parent.left = replacement;
        } else {
            source.parent.right = replacement;
        }
        if (replacement != null) {
            replacement.parent = source.parent;
        }
    }

    /**
     * 根据值搜索节点
     * @param k 值
     * @return 节点
     */
    private Node searchNode(int k) {
        Node node = root;

        while (node != null && node.key != k) {
            if (k < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }

    /**
     * 搜索节点的最小值
     * @param node 节点
     * @return 节点最小值
     */
    private Node minimumNode(Node node) {
        Node n = node;
        while (n != null && n.left != null) {
            n = n.left;
        }
        return n;
    }

    private boolean search(int k, Node node) {
        if (node == null) {
            return false;
        }
        if (node.key == k) {
            return true;
        }
        if (k < node.key) {
            return search(k, node.left);
        } else {
            return search(k, node.right);
        }
    }

    private void postOrderTreeWalk(Node node) {
        if (node != null) {
            postOrderTreeWalk(node.left);
            postOrderTreeWalk(node.right);
            System.out.println(node.key);
        }
    }

    private void inOrderTreeWalk(Node node) {
        if (node != null) {
            inOrderTreeWalk(node.left);
            System.out.println(node.key);
            inOrderTreeWalk(node.right);
        }
    }

    private void preOrderTreeWalk(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrderTreeWalk(node.left);
            preOrderTreeWalk(node.right);
        }
    }

    private class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key, Node left, Node right, Node parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
