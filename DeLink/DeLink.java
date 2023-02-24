package DeLink;

public class DeLink<T> {
    private T dData;
    private DeLink<T> next; 

    public DeLink(T dd ) {
        dData = dd;
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

    public DeLink<T> getNext() {
        return next;
    }
    public void setNext(DeLink<T> next) {
        this.next = next;
    }
}