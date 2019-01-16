package ru.ponomaryov.se.binaryfind;

import java.util.Arrays;

public class ArrayImpl implements Array{

    protected int[] data;
    protected int currentSize;

    public ArrayImpl(int maxSize) {
        this.data = new int[maxSize];
//        this.currentSize = 0;
    }

    @Override
    public void add(int value) {
        if (currentSize == data.length) {
            data = grow();
        }
        data[currentSize++] = value;
    }

    protected int[] grow() {
        return Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public int get() {
        if (!isEmpty()) {
            return data[currentSize - 1];
        }
        return 0;
    }

    @Override
    public int get(int index) {
        if (index >= 0 && index < currentSize) {
            return data[index];
        }

        return 0;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean remove(int value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }

        for (int i = index; i < currentSize - 1; i++) {
            data[i] = data[i + 1];
        }
        currentSize--;

        return true;
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            currentSize--;
        }
    }

    @Override
    public void clear() {
        currentSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public void display() {
        System.out.println("Display array:");
        for (int i = 0; i < currentSize; i++) {
            System.out.println(data[i]);
        }
        System.out.println("------------");
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = 0; j < currentSize - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }


    @Override
    public void sortSelect() {
        for (int i = 0; i < currentSize - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < currentSize; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < currentSize; i++) {
            int temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1] >= temp) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    private void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }


}
