package tree;

/**
 * <p>一颗红黑数是满足下面红黑性质的二叉搜索树<br/>
 *
 *     1.每个节点都是红色或黑色的 <br/>
 *     2.根节点是黑色的 <br/>
 *     3.如果一个节点是红色的，则它的两个子节点都是黑色的 <br/>
 *     4.对每个节点，从该节点到其所有后代叶节点的简单路径上，均包含相同数目的黑色节点。
 * @author LiDaQian
 */
public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    /**
     * 插入{@code key}至红黑树
     *
     * @param key 值
     * @return {@code key}
     */
    public int insert(int key) {
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (key < x.value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        Node newNode = new Node(key, true, null, null, y);

        if (y == null) {
            root = newNode;
        } else if (key < y.value) {
            y.left = newNode;
        } else {
            y.right = newNode;
        }

        insertFixUp(newNode);

        return key;
    }

    /**
     * 删除值
     * @param key 值
     * @return 是否删除成功
     */
    public boolean delete(int key) {
        Node z = searchNode(key);
        if (z == null) {
            return false;
        }
        Node y = z;
        boolean yOriginalColor = y.color;
        Node x;
        if (z.left == null) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == null) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimumNode(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                if (x != null) {
                    x.parent = y;
                }
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (x != null && yOriginalColor == BLACK) {
            deleteFixUp(x);
        }

        return true;
    }

    /**
     * 中序遍历
     */
    public void inOrderTreeWalk() {
        inOrderTreeWalk(root);
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

    /**
     * 插入后修正节点
     * @param z 节点
     */
    private void insertFixUp(Node z) {
        while (colorOf(parentOf(z)) == RED) {
            if (parentOf(z) == leftOf(parentOf(parentOf(z)))) {
                Node y = rightOf(parentOf(parentOf(z)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(z), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(z)), RED);
                    z = parentOf(parentOf(z));
                } else {
                    if (z == rightOf(parentOf(z))) {
                        z = parentOf(z);
                        leftRotate(z);
                    }
                    setColor(parentOf(z), BLACK);
                    setColor(parentOf(parentOf(z)), RED);
                    rightRotate(parentOf(parentOf(z)));
                }
            } else {
                Node y = leftOf(parentOf(parentOf(z)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(z), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(z)), RED);
                    z = parentOf(parentOf(z));
                } else {
                    if (z == leftOf(parentOf(z))) {
                        z = parentOf(z);
                        rightRotate(z);
                    }
                    setColor(parentOf(z), BLACK);
                    setColor(parentOf(parentOf(z)), RED);
                    leftRotate(parentOf(parentOf(z)));
                }
            }
        }

        setColor(root, BLACK);
    }

    /**
     * 删除节点后调整
     * @param x 变化节点
     */
    private void deleteFixUp(Node x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
                Node w = rightOf(parentOf(x));
                // case 1
                if (colorOf(w) == RED) {
                    setColor(w, BLACK);
                    setColor(parentOf(x), RED);
                    leftRotate(parentOf(x));
                    w = rightOf(parentOf(x));
                }
                // case 2
                if (colorOf(leftOf(w)) == BLACK && colorOf(rightOf(w)) == BLACK) {
                    setColor(w, RED);
                    x = parentOf(x);
                } else {
                    // case 3
                    if (colorOf(rightOf(w)) == BLACK) {
                        setColor(leftOf(w), BLACK);
                        setColor(w, RED);
                        rightRotate(w);
                        w = rightOf(parentOf(x));
                    }
                    // case 4
                    setColor(w, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(w), BLACK);
                    leftRotate(parentOf(x));
                    x = root;
                }
            } else {
                Node w = leftOf(parentOf(x));
                // case 1
                if (colorOf(w) == RED) {
                    setColor(w, BLACK);
                    setColor(parentOf(x), RED);
                    rightRotate(parentOf(x));
                    w = leftOf(parentOf(x));
                }
                // case 2
                if (colorOf(leftOf(w)) == BLACK && colorOf(rightOf(w)) == BLACK) {
                    setColor(w, RED);
                    x = parentOf(x);
                } else {
                    // case 3
                    if (colorOf(leftOf(w)) == BLACK) {
                        setColor(rightOf(w), BLACK);
                        setColor(w, RED);
                        rightRotate(w);
                        w = leftOf(parentOf(x));
                    }
                    // case 4
                    setColor(w, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(w), BLACK);
                    rightRotate(parentOf(x));
                    x = root;
                }
            }
        }

        x.color = BLACK;
    }

    /**
     * 以x轴为节点 左旋
     *
     *      |             |
     *      x             y
     *     / \          /  \
     *    a   y  ==>   x    c
     *      /  \     /  \
     *     b    c   a    b
     *
     * @param x 轴节点
     */
    private void leftRotate(Node x) {
        Node y = x.right;

        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    /**
     * 以x轴为节点 右旋
     *
     *      |             |
     *      y             x
     *     / \          /  \
     *    a   x  <==   y    c
     *      /  \     /  \
     *     b    c   a    b
     *
     * @param x 轴节点
     */
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.right = x;
        x.parent = y;
    }

    /**
     * 根据值搜索节点
     * @param k 值
     * @return 节点
     */
    private Node searchNode(int k) {
        Node node = root;

        while (node != null && node.value != k) {
            if (k < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }

    private static boolean colorOf(Node p) {
        return p == null ? BLACK : p.color;
    }

    private static Node parentOf(Node p) {
        return p == null ? null: p.parent;
    }

    private static void setColor(Node p, boolean c) {
        if (p != null) {
            p.color = c;
        }
    }

    private static Node leftOf(Node p) {
        return (p == null) ? null: p.left;
    }

    private static Node rightOf(Node p) {
        return (p == null) ? null: p.right;
    }

    private void inOrderTreeWalk(Node node) {
        if (node != null) {
            inOrderTreeWalk(node.left);
            System.out.println(node.value);
            inOrderTreeWalk(node.right);
        }
    }

    private class Node {
        int value;
        boolean color;
        Node left;
        Node right;
        Node parent;

        Node(int value, boolean color, Node left, Node right, Node parent) {
            this.value = value;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
