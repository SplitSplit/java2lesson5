package ru.ponomaryov.se.binaryfind;

public class SortedArrayImpl extends ArrayImpl {
    public SortedArrayImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public void add(int value) {
        if (currentSize == data.length) {
            data = grow();
        }

        int index = 0;
        for (index = 0; index < currentSize; index++) {
            if (data[index] > value) {
                break;
            }
        }

        for (int i = currentSize; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        currentSize++;
    }

    @Override
    public int indexOf(int value) {
        int low = 0;
        int high = currentSize - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == data[mid]) {
                return mid;
            }

            if (value < data[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
