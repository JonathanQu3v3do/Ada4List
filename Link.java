public class Link {

    private double dData;
    private Link next; 

    public Link(double dd ) {
        dData = dd;
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


    public Link getNext() {
        return next;
    }


    public void setNext(Link next) {
        this.next = next;
    }

    public void firstNode() {
        System.out.print("El primer dato de la lista es: " + dData +"\n");
    }

    public void LastNode() {
        System.out.print("El ultimo dato de la lista es: " + dData+ "\n");
    }



}