package DoublyLink;

public class DoublyLinkedList {
    private DoublyLink first;
    private DoublyLink last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    // 1
    public DoublyLink firstNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        return first;
    }

    // 1
    public DoublyLink lastNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        return last;
    }

    // 2
    public int size() {
        DoublyLink current = first;
        int cont = 0;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    // 3
    public void mayorNode(double key) {
        DoublyLink newLink = new DoublyLink(key);
        DoublyLink previous = null;
        DoublyLink current = first;

        while (current != null && key < current.getdData()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) insertFirst(key);
        else {
            previous.setNext(newLink);
            newLink.setPrevious(previous);
            newLink.setNext(current);
            if(current == null) last = newLink;
            else current.setPrevious(newLink);
        }
    }

    // 3
    public void menorNode(double key) {
        DoublyLink newLink = new DoublyLink(key);
        DoublyLink previous = null;
        DoublyLink current = first;
        while (current != null && key > current.getdData()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) insertFirst(key);
        else {
            previous.setNext(newLink);
            newLink.setPrevious(previous);
            newLink.setNext(current);
            if(current == null) last = newLink;
            else current.setPrevious(newLink);
        }
    }

    // 4
    public void updateNode(double datoActual, double datoNuevo) throws NullPointerException {
        DoublyLink current = first;
        boolean bandera = false;

        if (isEmpty())
            throw new NullPointerException("La lista esta vacia.");

        while (current != null && bandera == false) {
            if (current.getdData() == datoActual) {
                current.setdData(datoNuevo);
                bandera = true;
            } else
                current = current.getNext();
        }

        if (bandera == false)
            throw new NullPointerException("No se encontro el dato.");
    }

    // 5
    public void updateNodeAt(int index, double datoNuevo) throws NullPointerException {
        DoublyLink current = first;

        if (isEmpty())
            throw new NullPointerException("No hay elementos");

        for (int i = 0; current != null && i < index; i++) {
            current = current.getNext();
        }

        if (current != null)
            current.setdData(datoNuevo);
        else
            throw new NullPointerException("No existe el indice");
    }

    // 6
    public DoublyLink deletLink(double dato) throws NullPointerException {
        DoublyLink current = first;
        DoublyLink temp = first;
        boolean bandera = false;

        if (isEmpty())
            throw new NullPointerException("La lista esta vacia.");

        while (current.getNext() != null && bandera == false) {
            if (current.getNext().getdData() == dato)
                bandera = true;
            else
                current = current.getNext();
        }

        if (bandera == false)
            throw new NullPointerException("No se encontro el dato.");
        else {
            temp = current.getNext();
            current.setNext(current.getNext().getNext());
            if(current.getNext() == null) last = current;
            else current.getNext().setPrevious(current);
        }

        return temp;
    }

    // 7
    public DoublyLink deleteAt(int index) throws NullPointerException {
        DoublyLink current = first;
        DoublyLink temp = null;

        if (isEmpty())
            throw new NullPointerException("No hay elementos");

        if (index == 0){
            temp = current;
            first = current.getNext();
            first.setPrevious(null);
            if(first == null) last = null; //solo un elemento
        }
        else {
            for (int i = 0; current != null && i < index - 1; i++) {
                current = current.getNext();
            }
            if (current == null || current.getNext() == null)
                throw new NullPointerException("No existe el indice");

            temp = current.getNext();// el nuevo siguiente
            current.setNext(temp.getNext());
            if(current.getNext() == null) last = current; //se eliminó el último elemento
            else current.getNext().setPrevious(current); //no se eliminó el último elemento
        }

        return temp;
    }

    // 8
    public void deleteAll() throws NullPointerException {
        first = null;
        last = null;
    }

    // 9
    public int find(double value) throws NullPointerException {
        DoublyLink current = first;
        int cont = 0;
        if (isEmpty())
            throw new NullPointerException("La lista esta vacia.");

        while (current != null) {
            if (current.getdData() == value)
                return cont;

            cont++;
            current = current.getNext();
        }

        return -1;
    }

    
    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(double dd) {
        DoublyLink newLink = new DoublyLink(dd);
        
        if(isEmpty()) last = newLink;

        newLink.setNext(first);
        first = newLink;
    }

    public DoublyLink deleteFirst() throws NullPointerException{
        DoublyLink temp = first;

        if (isEmpty()) {
            throw new NullPointerException("La lista esta vacia.");
        }
        
        if(first.getNext() == null) last = null;
        
        first = first.getNext();
        first.setPrevious(null);
        return temp;
    }

    public void insertLast(double dato) {
        DoublyLink newLink = new DoublyLink(dato);
        DoublyLink current = last;

        current.setNext(newLink);
        newLink.setPrevious(current);
        last = newLink;
    }

    public DoublyLink deletetLast() {
        DoublyLink current = last.getPrevious();
        DoublyLink temp = last;

        last = current;
        current.setNext(null);
        
        return temp;
    }

    public void displayList() {
        System.out.print("List (first--> ");
        DoublyLink current = first;

        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }
}
