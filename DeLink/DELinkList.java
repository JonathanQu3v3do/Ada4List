package DeLink;

public class DELinkList {
    private DeLink first;
    private DeLink last;

    public DELinkList() {
        first = null;
        last = null;
    }

    // 1
    public DeLink firstNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        return first;
    }

    // 1
    public DeLink lastNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        return last;
    }

    // 2
    public int size() {
        DeLink current = first;
        int cont = 0;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    // 3
    public void mayorNode(double key) {
        DeLink newLink = new DeLink(key);
        DeLink previous = null;
        DeLink current = first;

        while (current != null && key < current.getdData()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) insertFirst(key);
        else {
            previous.setNext(newLink);
            newLink.setNext(current);
            if(current == null) last = newLink;
        }
    }

    // 3
    public void menorNode(double key) {
        DeLink newLink = new DeLink(key);
        DeLink previous = null;
        DeLink current = first;
        while (current != null && key > current.getdData()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) insertFirst(key);
        else {
            previous.setNext(newLink);
            newLink.setNext(current);
            if(current == null) last = newLink;
        }
    }

    // 4
    public void updateNode(double datoActual, double datoNuevo) throws NullPointerException {
        DeLink current = first;
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
        DeLink current = first;

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
    public DeLink deletLink(double dato) throws NullPointerException {
        DeLink current = first;
        DeLink temp = first;
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
        }

        return temp;
    }

    // 7
    public DeLink deleteAt(int index) throws NullPointerException {
        DeLink current = first;
        DeLink temp = null;

        if (isEmpty())
            throw new NullPointerException("No hay elementos");

        if (index == 0){
            temp = current;
            first = current.getNext();
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
            if(current.getNext() == null) last = current; //se eliminó el último elementos
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
        DeLink current = first;
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
        DeLink newLink = new DeLink(dd);
        
        if(isEmpty()) last = newLink;

        newLink.setNext(first);
        first = newLink;
    }

    public DeLink deleteFirst() throws NullPointerException{
        DeLink temp = first;

        if (isEmpty()) {
            throw new NullPointerException("La lista esta vacia.");
        }
        
        if(first.getNext() == null) last = null;
        
        first = first.getNext();
        return temp;
    }

    public void insertLast(double dato) {
        DeLink newLink = new DeLink(dato);
        DeLink current = first;

        if(!isEmpty()){
            while(current.getNext() != null) {
                current = current.getNext(); 
            }
            current.setNext(newLink);
        }
        else first = newLink;

        last = newLink;
    }

    public DeLink deletetLast() {
        DeLink current = first;
        DeLink temp = first;
        
        while(current.getNext().getNext() != null) {
            current = current.getNext();
        }
        temp = current.getNext();
        current.setNext(null);
        last = current;

        return temp;
    }

    public void displayList() {
        System.out.print("List (first--> ");
        DeLink current = first;

        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }
}
