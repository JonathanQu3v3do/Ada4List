package DoublyLink;

public class DoublyLink {
    private double dData;
    private DoublyLink previous;
    private DoublyLink next;

    public DoublyLink(double dd ) {
        dData = dd;
        previous = null;
        next = null;
    }

    public void displayLink() {
        System.out.print("{" + dData + "} ");
    }

    public double getdData() {
        return dData;
    }
    public void setdData(double dData) {
        this.dData = dData;
    }
    
    public void setPrevious(DoublyLink previous) {
        this.previous = previous;
    }
    public DoublyLink getPrevious() {
        return previous;
    }

    public DoublyLink getNext() {
        return next;
    }
    public void setNext(DoublyLink next) {
        this.next = next;
    }
}