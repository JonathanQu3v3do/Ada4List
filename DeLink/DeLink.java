package DeLink;

public class DeLink {
    private double dData;
    private DeLink next; 

    public DeLink(double dd ) {
        dData = dd;
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

    public DeLink getNext() {
        return next;
    }
    public void setNext(DeLink next) {
        this.next = next;
    }
}