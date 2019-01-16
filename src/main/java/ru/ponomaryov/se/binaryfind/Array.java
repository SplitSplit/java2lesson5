package ru.ponomaryov.se.binaryfind;

public interface Array {
    void add(int value);
    int get();
    int get(int index);
    int indexOf(int value);
    boolean contains(int value);
    boolean remove(int value);
    void remove();
    void clear();
    boolean isEmpty();
    int getSize();
    void display();
    void sortBubble();
    void sortSelect();
    void sortInsert();
}
