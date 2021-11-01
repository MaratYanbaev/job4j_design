package ru.job4j.list.simple.linked.list;

/**
 * @author Marat
 * @create 26.10.2021
 */
public interface List<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
}
