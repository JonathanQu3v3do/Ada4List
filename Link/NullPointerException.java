package Link;

public class NullPointerException extends Exception {
    public NullPointerException (String msg) {
        super(msg);
    }
}





    
    public class LinkList<T extends Comparable<T>> {
    private Link<T> first; // reference to the first node in the list
    
    
    public LinkList() {
    first = null;
    }
    /**
    
    Returns the reference to the first node in the list.
    @return the reference to the first node in the list.
    @throws NullPointerException if the list is empty.
    */
    public Link<T> firstNode() throws NullPointerException {
    if (isEmpty()) {
    throw new NullPointerException("la lista esta vacia ");
    }
    return first;
    }
    /**
    
    Returns the reference to the last node in the list.
    
    @return the reference to the last node in the list.
    
    @throws NullPointerException if the list is empty.
    */
    public Link<T> lastNode() throws NullPointerException {
    Link<T> current = first;
    
    if (isEmpty()) {
    throw new NullPointerException("la lista esta vacia ");
    }
    
    while (current.getNext() != null) {
    current = current.getNext();
    }
    return current;
    }
    
    /**
    
    Returns the number of nodes in the list.
    @return the number of nodes in the list.
    */
    public int size() {
    Link<T> current = first;
    int cont = 0;
    while (current != null) {
    cont++;
    current = current.getNext();
    }
    return cont;
    }
    /**
    
    Inserts a new node with the given data element into the list in descending order.
    @param key the data element to be inserted into the list.
    */
    public void mayorNode(T key)