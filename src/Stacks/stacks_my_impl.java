package Stacks;

import LinkedList.DoublyLinkedList;

import java.util.EmptyStackException;
import java.util.Iterator;

public class stacks_my_impl<T> implements Iterable<T> {

    private DoublyLinkedList<T> list=new DoublyLinkedList<T>();

    public stacks_my_impl() {
    }

    public stacks_my_impl(T firstEle) {
        push(firstEle);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(T ele){
        list.addLast(ele);
    }

    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list.removeLast();
    }

    public T peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
