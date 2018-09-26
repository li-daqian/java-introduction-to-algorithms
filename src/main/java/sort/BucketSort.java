package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author LiDaQian
 */
public class BucketSort {

    public static void sort(int[] array) {
        int largestDigit = getLargestDigit(array);

        List<Node> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new Node());
        }
        // 插入桶
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int bucketIndex = (num / (int) Math.pow(10, largestDigit - 1)) % 10;
            Node currentNode = buckets.get(bucketIndex);
            if (currentNode.value == null) {
                currentNode.value = num;
            } else {
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                Node newNode = new Node();
                newNode.value = num;

                currentNode.next = newNode;
            }
        }
        int mergeIndex = 0;
        for (Node node : buckets) {
            if (node.value == null) {
                continue;
            }
            // 桶链表排序
            insertionSort(node);
            // 聚合桶
            Node nextNode = node.next;
            array[mergeIndex] = node.value;
            mergeIndex++;
            while (nextNode != null) {
                array[mergeIndex] = nextNode.value;
                mergeIndex++;
                nextNode = nextNode.next;
            }
        }
    }

    private static void insertionSort(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node tail = null;

        while (current != tail) {
            while (current.next != tail) {
                // 如果当前节点比下一节点大， 则交换两者的值
                if (current.value > current.next.value) {
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                }
                current = current.next;
            }
            // 尾节点 = 当前节点 尾节点会逐步向当前节点靠拢 直至尾节点==当前节点，结束循环
            tail = current;
            // 当前节点重置为头节点
            current = head;
        }
    }

    private static int getLargestDigit(int[] array) {
        int largestDigit = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int digit = 0;
            while (num % 10 > 0) {
                digit++;
                num = num / 10;
            }
            if (digit > largestDigit) {
                largestDigit = digit;
            }
        }
        return largestDigit;
    }

    static private class Node {
        Integer value;
        Node next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {

            return Objects.hash(value, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
