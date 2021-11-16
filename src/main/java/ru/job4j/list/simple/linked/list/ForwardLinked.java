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
        Node<T> next = head.next;
        head.next = null;
        head = next;
        return value;
    }

    public boolean revert() {
        boolean isReverted = Objects.nonNull(head) && Objects.nonNull(head.next);
        if (isReverted) {
            Node<T> lastProcessedNode = head;
            Node<T> newHead = new Node<>(lastProcessedNode.next.value, new Node<>(lastProcessedNode.value, null));
            lastProcessedNode = lastProcessedNode.next;

            while (lastProcessedNode.next != null) {
                newHead = new Node<>(lastProcessedNode.next.value, newHead);
                lastProcessedNode = lastProcessedNode.next;
            }
            head = newHead;
        }
        return isReverted;
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
