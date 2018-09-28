package set;

/**
 * @author LiDaQian
 */
public class LinkedList<T> {
    /**
     * 头节点
     */
    private Node head;
    /**
     * 尾节点
     */
    private Node tail;

    private int size = 0;

    /**
     * 添置头节点
     * @param item 元素
     */
    public void insertFirst(T item) {
        Node h = head;
        Node newNode = new Node(item, null, h);
        if (h == null) {
            tail = newNode;
        } else {
            h.prev = newNode;
        }
        head = newNode;

        size++;
    }

    /**
     * 添至尾节点
     * @param item 元素
     */
    public void insertLast(T item) {
        Node t = tail;
        Node newNode = new Node(item, t, null);
        if (t == null) {
            head = newNode;
        } else {
            t.next = newNode;
        }
        tail = newNode;

        size++;
    }

    /**
     * 根据下标获取元素
     * @param index 下标
     * @return 该下标元素
     */
    public T get(int index) {
        if (size == 0) {
            return null;
        }

        if (size / 2 > index) {
            Node x = head;
            int i = 0;
            while (i != index) {
                x = x.next;
                i++;
            }
            return x == null ? null : x.item;
        } else {
            Node x = tail;
            int i = size - 1;
            while (i != index) {
                x = x.prev;
                i--;
            }
            return x == null ? null : x.item;
        }
    }

    /**
     * 删除元素
     * @param item 元素
     * @return 是否删除成功
     */
    public boolean delete(T item) {
        Node node = search(item);
        if (node == null) {
            return false;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        size--;

        return true;
    }

    /**
     * 根据元素返回元素所在节点
     * @param item 元素
     * @return 元素所在节点
     */
    private Node search(T item) {
        Node h = head;
        while (h != null && h.item != item) {
            h = h.next;
        }
        return h;
    }

    private class Node {
        T item;
        Node prev;
        Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
