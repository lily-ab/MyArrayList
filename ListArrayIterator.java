/**
 * The "ListArrayIterator" class for iterating through array
 * implements "Iterator interface"
 */
package com.lab1;

import java.util.Iterator;

public class ListArrayIterator<T> implements Iterator {
    private int index=0;
    private T[] array;
    public ListArrayIterator(T[] array) {
        this.array=array;
    }

    /**
     * Displays if there is a next element in the massive
     * or the end of the massive is reached
     * @return true if there is a next element, false if there is not
     */
    @Override
    public boolean hasNext(){
        return index<array.length;
    }

    /**
     * Gets the next element of the massive;
     * @return the next element of the massive
     */
    @Override
    public T next(){
        return array[index++];
    }
}