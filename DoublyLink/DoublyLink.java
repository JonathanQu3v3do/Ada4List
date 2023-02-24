package DoublyLink;

public class DoublyLink<T> {
    private T dData;
    private DoublyLink<T> previous;
    private DoublyLink<T> next;

    public DoublyLink(T dd ) {
        dData = dd;
        previous = null;
        next = null;
    }

    public void displayLink() {
        System.out.print("{" + getdData() + "} ");
    }

    
    /** 
     * @return T
     */
    public T getdData() {
        return dData;
    }
    
    /** 
     * @param dData
     */
    public void setdData(T dData) {
        this.dData = dData;
    }
    
    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }
    public DoublyLink<T> getPrevious() {
        return previous;
    }

    public DoublyLink<T> getNext() {
        return next;
    }
    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }
}