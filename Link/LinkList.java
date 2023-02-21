package Link;

public class LinkList<T> {
    private Link<T> first;

    public LinkList() {
        first = null;
    }

    // 1
    public Link<T> firstNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        return first;
    }

    // 1
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

    // 2
    public int size() {
        Link<T> current = first;
        int cont = 0;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    // 3
    public void mayorNode(T key) {
        Link<T> newLink = new Link<T>(key);
        Link<T> previous = null;
        Link<T> current = first;

        while (current != null && key < current.getdData()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null)
            insertFirst(key);
        else {
            // estos dos solo son para el else, vd?
            previous.setNext(newLink);
            newLink.setNext(current);
        }
    }

    // 3
    public void menorNode(T key) {
        Link<T> newLink = new Link<T>(key);
        Link<T> previous = null;
        Link<T> current = first;

        while (current != null && key > current.getdData()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null)
            insertFirst(key);
        else {
            // estos dos solo son para el else, vd?
            previous.setNext(newLink);
            newLink.setNext(current);
        }
    }

    // 4
    public void updateNode(T datoActual, T datoNuevo) throws NullPointerException {
        Link<T> current = first;
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
    public void updateNodeat(int index, T datoNuevo) throws NullPointerException {
        Link<T> current = first;

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
    public Link<T> deleLink(T dato) throws NullPointerException {
        Link<T> current = first;
        Link<T> temp = first;
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
        }

        return temp;
    }

    // 7
    public void deleteAt(int index) throws NullPointerException {
        Link<T> current = first;

        if (isEmpty())
            throw new NullPointerException("No hay elementos");

        if (index == 0)
            first = current.getNext();
        else {
            for (int i = 0; current != null && i < index - 1; i++) {
                current = current.getNext();
            }
            if (current == null || current.getNext() == null)
                throw new NullPointerException("No existe el indice");

            Link<T> temp = current.getNext().getNext();// el nuevo siguiente
            current.setNext(temp);
        }
    }

    // 8
    public void deleteAll() throws NullPointerException {
        first = null;

    }

    // 9
    public int find(T value) throws NullPointerException {
        Link<T> current = first;
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

    public void insertFirst(T dd) {
        Link<T> newLink = new Link<T>(dd);
        newLink.setNext(first);
        first = newLink;
    }

    public Link<T> deleteFirst() {
        Link<T> temp = null;
        if (!isEmpty()) {
            temp = first;
            first = first.getNext();
        }
        return temp;
    }

    public void displayList() {
        System.out.print("List (first--> ");
        Link<T> current = first;

        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }
}