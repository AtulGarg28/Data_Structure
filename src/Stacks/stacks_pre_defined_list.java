package Stacks;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class stacks_pre_defined_list<T> implements Iterable<T>{
    private LinkedList<T> list=new LinkedList<T>();

    public stacks_pre_defined_list() {
    }

    public stacks_pre_defined_list(T firstEle) {
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
