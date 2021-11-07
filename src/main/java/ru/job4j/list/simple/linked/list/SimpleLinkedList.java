package ru.job4j.list.simple.linked.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


/**
 * @author Marat
 * @create 26.10.2021
 */
public class SimpleLinkedList<E> implements List<E> {

    private Node<E> first;
    private int size;
    private int modCount;

    @Override
    public void add(E value) {
        Node<E> node = new Node<>(value, null);
        if (first == null) {
            first = node;
        } else {
            first.next = node;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> prev = first;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Node<E> next = first;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return next != null && next.item != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E item = next.item;
                next = next.next;
                return item;
            }

        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}

