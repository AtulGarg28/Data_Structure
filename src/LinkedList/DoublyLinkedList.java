package LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{
    private int size=0;
    private Node<T> head=null;
    private Node<T> tail=null;

    public class Node<T>{
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Empty this linked list, O(n)
    public void clear(){
        Node<T> trav=head;
        while (trav!=null){
            Node<T> next=trav.next;
            trav.next=trav.prev=null;
            trav.data=null;
            trav=next;
        }
        head=tail=trav=null;
        size=0;
    }

    public boolean isEmpty(){
        if (size==0) return true;
        else return false;
    }

    public int size(){
        return size;
    }

    // O(1)
    public void add(T ele){
        addLast(ele);
    }

    // O(1)
    public void addFirst(T ele){
        if (isEmpty()){
            head=tail=new Node<T>(ele,null,null);
        } else {
            head.prev=new Node<T>(ele,null,head);
            head=head.prev;
        }
        size++;
    }

    // O(1)
    public void addLast(T ele){
        if (isEmpty()){
            head=tail=new Node<T>(ele,null,null);
        } else {
            tail.next=new Node<T>(ele,tail,null);
            tail=tail.next;
        }
        size++;
    }

    // O(1)
    public T peekFirst(){
        if (isEmpty()) throw new RuntimeException("Enpty list");
        return head.data;
    }

    // O(1)
    public T peekLast(){
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst(){
        if (isEmpty()) throw new RuntimeException("Empty list");
        T removedData= head.data;
        head=head.next;
        --size;

        // Now, if after deleting that element, the list becomes null, i.e. if there was only one node before deleting, So, now it becomes empty.
        if (isEmpty()) tail=null;
        else head.prev=null;
        return removedData;
    }

    public T removeLast(){
        if (isEmpty()) throw new RuntimeException("Empty list");
        T removedData= tail.data;
        tail=tail.prev;
        --size;

        if (isEmpty()) head=null;
        else tail.next=null;
        return removedData;
    }

    private T remove(Node<T> node){
        if (node.next==null) return removeLast();
        if (node.prev==null) return removeFirst();

        node.prev.next=node.next;
        node.next.prev=node.prev;

        T removedData=node.data;
        node.data=null;
        node=node.prev=node.next=node=null;

        --size;

        return removedData;
    }

    public T removeAt(int index){
        if (index<0 || index>=size) throw new IllegalArgumentException("Index out of range");

        int i;
        Node<T> trav;
        if (index<size/2){
            // Only initaialization for i and trav.
            for (i=0,trav=head;i!=index;i++){
                trav=trav.next;
            }
        } else {
            for (i=size-1,trav=tail;i!=index;i--){
                trav=trav.prev;
            }
        }
        return remove(trav);
    }

    //Removing particular value, O(n)
    public boolean remove(Object obj){
        Node<T> trav;
        if (obj==null){
            for (trav=head;trav!=null;trav=trav.next){
                if (trav.data==null){
                    remove(trav);
                    return true;
                }
            }
        }else {
            for (trav=head;trav!=null;trav=tail.next){
                if (obj.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    //Finding index, O(n)
    public int indexOf(Object obj){
        int count=0;
        Node<T> trav=head;
        if (obj==null){
            for (trav=head;trav!=null;trav=trav.next,count++){
                if (trav.data==null){
                    return count;
                }
            }
        }else {
            for (trav=head;trav!=null;trav=trav.next,count++){
                if (obj.equals(trav.data)){
                    return count;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj)!=-1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav!=null;
            }

            @Override
            public T next() {
                T data= trav.data;
                trav=trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new  UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[ ");
        Node<T> trav=head;
        while (trav!=null){
            sb.append(trav.data+", ");
            trav=trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
