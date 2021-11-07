package ru.job4j.stack;

import java.util.NoSuchElementException;

/**
 * @author Marat
 * @create 07.11.2021
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        try {
            while (true) {
                out.push(in.pop());
            }
        } catch (NoSuchElementException e) {
            T value = out.pop();
            try {
                while (true) {
                    push(out.pop());
                }
            } catch (NoSuchElementException e1) {
                return value;
            }
        }
    }

    public void push(T value) {
        in.push(value);
    }
}
