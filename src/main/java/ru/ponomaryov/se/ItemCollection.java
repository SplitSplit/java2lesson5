package ru.ponomaryov.se;

public interface ItemCollection {

    public int getCount();

    public void addItem(Item item);

    public void addItem(String name, double weight, double cost);

    public void clear();

    public void removeAt(int index);

    public Item getItem(int index);
}
