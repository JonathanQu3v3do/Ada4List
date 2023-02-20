public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    // 1
    public Link firstNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        
        return first;
    }

    // 1
    public Link LastNode() throws NullPointerException {
        Link current = first;

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
        Link current = first;
        int cont = 0;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;

    }

    // 3
    public void mayorNode(double key) {

        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;
        while (current != null && key < current.getdData()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null)
            insertFirst(key);
        else
            previous.setNext(newLink);

        newLink.setNext(current);

    }

    // 3
    public void menorNode(double key) {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;
        while (current != null && key > current.getdData()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null)
            insertFirst(key);
        else
            previous.setNext(newLink);

        newLink.setNext(current);
    }

    // 6
    public Link deleLink(double dato) throws NullPointerException {
        Link current = first;
        Link temp = first;
        boolean bandera = false;

        while (current.getNext() != null && bandera == false) {
            if (current.getNext().getdData() == dato)
                bandera = true;
            else
                current = current.getNext();
        }
        if (current.getNext() == null && current.getdData() != dato)
            throw new NullPointerException("No se encontro el dato.");
        else {
            temp = current.getNext();
            current.setNext(current.getNext().getNext());

        }

        return temp;
    }

    // 7
    public void deleteAt(int index) throws NullPointerException {
        Link current = first;
        if (isEmpty())
            System.out.println("no hay elementos");
        if (index == 0)
            first = current.getNext();
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.getNext();
        }
        if (current == null || current.getNext() == null)
            throw new NullPointerException("No existe el indice");

        Link temp = current.getNext().getNext();// el nuevo siguiente
        current.setNext(temp);

    }

    // 8
    public void delateAll() throws NullPointerException {
        Link current = first;
        if (!isEmpty()) {
            while (current != null) {
                first = first.getNext();
                current = first;
            }
            System.out.println("Se ha eliminado con exito");
        } else
            System.out.println("la lista esta vacia");

    }

    // 9
    public int find(double value) throws NullPointerException {
        Link current = first;
        int cont = 0;
        if (isEmpty())
            return -1;
        else {
            while (current != null) {
                if (current.getdData() == value)
                    return cont;
                cont++;
                current = current.getNext();
            }
        }

        throw new NullPointerException("-1 No se encontró el dato");

    }

    public void replaceAt(int index) throws NullPointerException {
       
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(double dd) {
        Link newLink = new Link(dd);
        newLink.setNext(first);
        // newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = null;
        if (!isEmpty()) {
            temp = first;
            first = first.getNext();
            // first = first.next;
        }
        return temp;
    }

    public void displayList() {
        System.out.print("List (first--> ");
        Link current = first;

        // Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
            // current = current.next;
        }
        System.out.println("<--last)");
    }

}
