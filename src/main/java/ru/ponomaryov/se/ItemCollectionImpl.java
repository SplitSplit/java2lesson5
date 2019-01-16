package ru.ponomaryov.se;

import java.util.ArrayList;

public class ItemCollectionImpl implements ItemCollection {

    ArrayList<Item> items = new ArrayList<>();

    public ItemCollectionImpl() {
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void addItem(String name, double weight, double cost) {
        items.add(new Item(name, weight, cost));
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public void removeAt(int index) {
        items.remove(index);
    }

    @Override
    public Item getItem(int index) {
        return items.get(index);
    }
}
