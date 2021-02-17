package DynamicArray;

import java.util.Arrays;

public class DynamicArrayMain<T> implements Iterable<T> {
    private T[] arr;
    private int length=0;
    private int capacity=0;

    public DynamicArrayMain() {
        this(12);
    }

    public DynamicArrayMain(int capacity) {
        if (capacity<0){
            throw new IllegalArgumentException("Illegal value of capacity"+capacity);
        }
        this.capacity=capacity;
        arr=(T[]) new Object[capacity];
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void clear(){
        for (int i=0;i<=length;i++){
            arr[i]=null;
        }
        length=0;
    }

    public T getElement(int index){
        if (index<=length){
            return arr[index];
        }else {
            throw new ArrayIndexOutOfBoundsException("Index "+index+" not exists");
        }
    }

    public void replace(int index,T element){
        if (index<=length) {
            arr[index] = element;
        }else {
            throw new ArrayIndexOutOfBoundsException("Index "+index+" not exists");
        }
    }

    public void add(T element){
        if (length+1>=capacity){
            if (capacity==0){
                capacity=1;
            }else {
                capacity *=2;
            }
            T[] new_arr=(T[]) new Object[capacity];
            for (int i=0;i<length;i++){
                new_arr[i]=arr[i];
            }
            arr=new_arr;    //arr has Extra nulls inserted. i.e. now double in size.
        }
        arr[length++]=element;
    }

    public T removeAtIndex(int index){
        if (index>length || index<0){
            throw new IndexOutOfBoundsException();
        }
        T value=arr[index];
        T[] new_arr=(T[]) new Object[length-1];
        for (int i=0, j=0;i<length;i++,j++){
            if (index==i){
                j--;
            }else {
                new_arr[j]=arr[i];
            }
        }
        arr=new_arr;
        capacity= --length;
        return value;
    }

    public int indexOf(T obj){
        for (int i=0;i<length;i++){
            if (obj==null){
                if(arr[i]==null) return i;
            }else {
                if (obj.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    public boolean remove(T obj){
        int index=indexOf(obj);
        if (index == -1) return false;
        removeAtIndex(index);
        return true;
    }

    public boolean contains(T obj){
        int index=indexOf(obj);
        if (index == -1) return false;
        return true;
    }

//    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>(){

            int index=0;

            @Override
            public boolean hasNext() {
                return index<length;
            }

            @Override
            public T next() {
                return arr[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (length==0) return "[]";
        return "DynamicArrayMain{" +
                "arr=" + Arrays.toString(arr);
    }

    public static void main(String[] args){
        System.out.println("Hello");
    }
}
