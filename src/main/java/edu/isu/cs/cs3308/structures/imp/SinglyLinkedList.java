package edu.isu.cs.cs3308.structures.imp;

import edu.isu.cs.cs3308.Node;
import edu.isu.cs.cs3308.structures.List;

public class SinglyLinkedList<E> implements List<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int size = 0;



    /**
     *
     * @return the size of the SLL
     */
    @Override
    public int size() {
        return size = 0;
    }

    /**
     *
     * @return whether or not the SLL is Empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @return data of first entry
     */

    @Override
    public E first() {

        if (isEmpty())
            return null;

        return head.getData();

    }

    /**
     *
     * @return data of last entry
     */

    @Override
    public E last() {
        if(isEmpty())return null;

        return tail.getData();
    }

    /**
     *
     * @param element Element to be added to the front of the list.
     */
    @Override
    public void addFirst(E element) {

        if(element == null){return;}

        Node<E> newest = new Node<>(element);
        newest.setNext(head);
        head = newest;
        size++;

    }

    /**
     *
     * @param element Element to be added to the end of the list.
     */
    @Override
    public void addLast(E element) {
        if(element == null){return;}

        Node<E> last = new Node<>(element);
        tail.setNext(last);
        tail = last;
        size++;
    }

    /**
     *
     * removes the last Element of the SLL
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) return null;

        Node<E> temp = head;
        head = head.getNext();
        temp.setNext(null);
        size--;
        return temp.getData();
    }

    /**
     *
     * @return Removes the last entry in SLL returns it's data
     */
    @Override
    public E removeLast() {
        if(isEmpty()) return null;

        Node<E> temp = head;
        E answer = tail.getData();

        for(int i = 0; i < size; i++){
            temp = temp.getNext();
        }
        temp.setNext(null);
        tail = temp;
        size--;

        return temp.getData();
    }

    /**
     *
     * @param index Index of the value to be retrieved.
     * @return Data of indexed element
     */
    @Override
    public E get(int index) {
        if(index < 0 || index >= size)
            return null;

        Node<E> current = head;
        for(int i = 0; i < index; i++)
            current = current.getNext();

        return current.getData();


    }

    /**
     *
     * @param element Element to be added (as long as it is not null).
     * @param index Index in the list where the element is to be inserted.
     *              Inserts a node ad specified index
     */
    @Override
    public void insert(E element, int index) {
        if(index < 0 || index >= size)
            return;

        Node<E> newNode = new Node<>(element);
        Node<E> current = head;

        for(int i = 0; i < index - 1; i++)
            current = current.getNext();

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    /**
     *
     * @param index Index of the element to remove
     * @return removes element at specified index and returns the information therein
     */
    @Override
    public E remove(int index) {
        if(index < 0 || index >= size)  //Making sure that index is within bounds
                return null;

        Node<E> current = head;          //Sets the current node at the head of the SLL and then cycles through
        for(int i = 0; i < index; i++){  //until the node right before the indicated node
            current = current. getNext();
        }

        Node<E> toRemove = current.getNext();  //Sets the node to be removed as the next node ie the node indexed.
        current.setNext(toRemove.getNext());   //Sets the sets the current nodes next node as the one after the node
        toRemove.setNext(null);                //to be removed.
        size--;                                //Decrements Size;
        return toRemove.getData();             //Returns the information from the node about to be removed

    }

    @Override
    public void printList() {

    }
}
