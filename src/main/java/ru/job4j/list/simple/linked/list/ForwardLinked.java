package ru.job4j.list.simple.linked.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Marat
 * @create 07.11.2021
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
    }

    public T deleteFirst() {
        if (Objects.isNull(head)) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    public boolean revert() {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return false;
        }
        Node<T> newHead = null;
        Node<T> lastProcessedNode = null;
        Node<T> node = head;

        while (head != lastProcessedNode) {

            if (newHead == null && node.next.next == null) {
                newHead = new Node<>(node.next.value, node);
                lastProcessedNode = node;
                node = head;

            } else if (node.next == lastProcessedNode) {
                lastProcessedNode.next = node;
                lastProcessedNode = node;
                node = head;

            } else {
                node = node.next;
            }

        }

        head = newHead;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
