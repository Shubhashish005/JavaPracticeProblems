package info.java.collection;

import java.util.AbstractList;
import java.util.Arrays;

public class CustomArrayList<E> extends AbstractList<E> {

    private static int counter = 0;
    private Object[] elementData;
    private int defaultSize = 10;

    public CustomArrayList() {
        elementData = new Object[defaultSize];
    }

    public CustomArrayList(int defaultSize) {
        this.defaultSize = defaultSize;
        elementData = new Object[defaultSize];
    }

    public static void main(String[] args) {

        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        customArrayList.stream().forEach(System.out::println);
        System.out.println("Get operation : " + customArrayList.get(1));

        // Remove element from arrayList
        customArrayList.remove(1);
        customArrayList.stream().forEach(System.out::println);
        System.out.println("Get operation : " + customArrayList.get(1));
//        System.out.println();
    }

    @Override
    public boolean add(E e) {
        if (counter == (0.75 * defaultSize)) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
            elementData[counter++] = e;
            return true;
        }

        elementData[counter++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new UnsupportedOperationException("Not valid result");
        }

        E element = (E) elementData[index];

        // Shift elements to left after removing Array
        for (int i = index; i <= counter; i++) {
            elementData[i] = elementData[i + 1];
        }
        counter--;
        return element;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new UnsupportedOperationException("Not valid result");
        }

        E element = (E) elementData[index];
        return element;
    }

    @Override
    public int size() {
        return counter;
    }
}
