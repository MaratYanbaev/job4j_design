package ru.job4j.list.simple.array.list;

/**
 * @author Marat
 * @create 20.10.2021
 */
public interface List<T> extends Iterable<T> {
    void add(T value);
    T set(int index, T newValue);
    T remove(int index);
    T get(int index);
    int size();
}
