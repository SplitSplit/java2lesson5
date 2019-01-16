package ru.ponomaryov.se.binaryfind;

public class RecSortedArrayImpl extends SortedArrayImpl {

    public RecSortedArrayImpl(int maxSize) {
        super(maxSize);
    }

    public static void main(String[] args) {
        Array arr = new RecSortedArrayImpl(5);
        arr.add(4);
        arr.add(2);
        arr.add(1);
        arr.add(7);
        arr.add(54);
        arr.add(17);
        arr.add(22);

        arr.display();

        System.out.println("Find 1 = : " + arr.contains(1));
        System.out.println("Index 1 = : " + arr.indexOf(1));
        System.out.println("Find 22 = : " + arr.contains(22));
        System.out.println("Index 22 = : " + arr.indexOf(22));
        System.out.println("Find 222: = " + arr.contains(222));

    }

    @Override
    public int indexOf(int value) {
        return recBinaryFind(value, 0, currentSize);
    }

    private int recBinaryFind(int value, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (value == data[mid]) {
            return mid;
        }

        if (value < data[mid]) {
            return recBinaryFind(value, low, mid - 1);
        } else {
            low = mid + 1;
            return recBinaryFind(value, mid +1 , high);
        }
    }
}
