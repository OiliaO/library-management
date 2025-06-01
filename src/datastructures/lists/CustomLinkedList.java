package datastructures.lists;

import datastructures.interfaces.LinkedList;
import java.util.*
        ;

public class CustomLinkedList<T> implements LinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public boolean add(Object t) {
        if (t == null) {
            throw new NullPointerException("Element cannot be null.");
        }
        addLast((T)t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Element to remove cannot be null.");
        }
        Node<T> current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                unlink(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) return false;
        Node<T> current = head;
        while (current != null) {
            if (o.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    @Override
    public T set(int index, Object element) {
        checkElementIndex(index);
        Node<T> x = node(index);
        x.data = (T)element;
        return (T)element;
    }

    @Override
    public void addFirst(T t) {
        if (t == null) {
            throw new NullPointerException("Element cannot be null.");
        }
        final Node<T> f = head;
        final Node<T> newNode = new Node<>(t);
        newNode.next = f;
        head = newNode;
        if (f == null) {
            tail = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        if (t == null) {
            throw new NullPointerException("Element cannot be null.");
        }
        final Node<T> l = tail;
        final Node<T> newNode = new Node<>(t);
        newNode.prev = l;
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        final Node<T> f = head;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    @Override
    public T removeLast() {
        final Node<T> l = tail;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }

    @Override
    public T getFirst() {
        final Node<T> f = head;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.data;
    }
    @Override
    public T getLast() {
        final Node<T> l = tail;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.data;
    }

    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.data = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private T unlink(Node<T> x) {
        final T element = x.data;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) { head = next; } else { prev.next = next; x.prev = null; }
        if (next == null) { tail = prev; } else { next.prev = prev; x.next = null; }

        x.data = null;
        size--;
        return element;
    }

    private T unlinkFirst(Node<T> f) {
        final T element = f.data;
        final Node<T> next = f.next;
        f.data = null; f.next = null;
        head = next;
        if (next == null) tail = null; else next.prev = null;
        size--;
        return element;
    }

    private T unlinkLast(Node<T> l) {
        final T element = l.data;
        final Node<T> prev = l.prev;
        l.data = null; l.prev = null;
        tail = prev;
        if (prev == null) head = null; else prev.next = null;
        size--;
        return element;
    }
}