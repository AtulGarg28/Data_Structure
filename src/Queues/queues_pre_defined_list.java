package Queues;

import java.util.Iterator;
import java.util.LinkedList;

public class queues_pre_defined_list<T> implements Iterable<T>{
    LinkedList<T> list=new LinkedList<T>();

    public queues_pre_defined_list() {
    }

    public queues_pre_defined_list(T ele) {
        enqueue(ele);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public T peek(){
        if (isEmpty()) throw  new RuntimeException("Enpty queue.");
        return list.peekFirst();
    }

    public T dequeue(){
        if (isEmpty()) throw  new RuntimeException("Enpty queue.");
        return list.removeFirst();
    }

    public void enqueue(T ele){
        list.addLast(ele);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
