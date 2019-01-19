package edu.isu.cs.cs3308;

public class Node<E> {

    private E data; //refernce for data
    private Node<E> next; //reference for next node


    public Node (E data) //Constructor for the node itself
    {
        this.data = data;
    }



    public E getData(){return data;} //Returns the item/data in the node

    public void setData(E d){this.data = data;}//Sets the data of the node

    public Node<E> getNext(){return next;} //Returns the next node

    public void setNext(Node<E> n){this.next = next;}//Sets the next node


}
