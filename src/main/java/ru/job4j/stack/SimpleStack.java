package ru.job4j.stack;

import ru.job4j.list.simple.linked.list.ForwardLinked;

/**
 * @author Marat
 * @create 07.11.2021
 */
public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}
