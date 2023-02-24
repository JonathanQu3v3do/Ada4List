package Link;
/**
 * descripcion corta
 * parámetros de entrada
 * parámetros de salida
 * 
 * 
 * The Link class represents a node in a linked list, which contains a generic data element
 * and a reference to the next node in the list.
 *
 * @param <T> the type of data stored in the node.
*/
public class Link<T> {
    private T dData; // the data element stored in the node
    private Link<T> next; // reference to the next node in the list
    
    /**
    
    Constructs a new Link object with the given data element and a null reference to the next node.
    @param dd the data element stored in the node.
    */
    public Link(T dd ) {
        dData = dd;
        next = null;
    }

    /**
    
    Displays the data element stored in the node.
    */
    public void displayLink() {
        System.out.print("{" + getdData() + "} ");
    }

    /**
    
    Returns the data element stored in the node.
    @return the data element stored in the node.
    */
    public T getdData() {
        return dData;
    }
    /**
    
    Sets the data element stored in the node.
    @param dData the new data element to be stored in the node.
    */
    public void setdData(T dData) {
        this.dData = dData;
    }

    /**
    
    Returns the reference to the next node in the list.
    @return the reference to the next node in the list.
    */
    public Link<T> getNext() {
        return next;
    }
    /**
    
    Sets the reference to the next node in the list.
    @param next the new reference to the next node in the list.
    */
    public void setNext(Link<T> next) {
        this.next = next;
    }
}