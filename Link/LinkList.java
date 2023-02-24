package Link;
/**
 * Esta clase maneja la lista ligada simple.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
 */
public class LinkList<T extends Comparable<T>> {
    private Link<T> first; //hace referencia al primer elemento de la Lista.

    /**
     * Constructor para LinkList con referencia null al primer nodo de la lista.
     */
    public LinkList() {
        first = null;
    }

    /**
     * Devuelve el primer elemento de la lista.
     * @return Link<T>
     * @throws NullPointerException
     */
    public Link<T> firstNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        return first;
    }

    /**
     * Devuelve el ultimo elemento de la lista.
     * @return Link<T>
     * @throws NullPointerException
     */
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

    /**
     * Devuelve el tamaño de la lista.
     * @return int cantidad de nodos.
     */
    public int size() {
        Link<T> current = first;
        int cont = 0;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    /**
     * Inserta un nuevo nodo en la lista en orden decreciente.
     * @param key dato para el nuevo nodo
     */
    public void mayorNode(T key) {

        Link<T> newLink = new Link<T>(key);
        Link<T> previous = null;
        Link<T> current = first;

        while (current != null && key.compareTo(current.getdData()) < 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null)
            insertFirst(key);
        else {
            previous.setNext(newLink);
            newLink.setNext(current);
        }
    }

    /**
     * Inserta un nuevo nodo en la lista en orden creciente.
     * @param key dato para el nuevo nodo
     */
    public void menorNode(T key) {
        Link<T> newLink = new Link<T>(key);
        Link<T> previous = null;
        Link<T> current = first;

        while (current != null && key.compareTo(current.getdData()) > 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null)
            insertFirst(key);
        else {
            previous.setNext(newLink);
            newLink.setNext(current);
        }
    }

    /**
     * Actualiza el dato de un nodo con un dato nuevo.
     * @param datoActual el dato del nodo que se busca en la lista
     * @param datoNuevo el nuevo dato por el que se cambia datoActual
     * @throws NullPointerException
     */
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

    /**
     * Actualiza el dato de un nodo, busca el nodo por posicion
     * @param index posicion del nodo por actualizar
     * @param datoNuevo dato por el que se cambia el dato del nodo
     * @throws NullPointerException
     */
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

    /**
     * Elimina un elemento proporcionado.
     * @param dato
     * @return Link<T>
     * @throws NullPointerException
     */
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

    /**
     * Elimina el nodo de una posición en la lista.
     * @param index posicion del nodo por eliminar
     * @throws NullPointerException
     */
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

    /**
     * Elimina todos los datos de la lista.
     * @throws NullPointerException
     */
    public void deleteAll() throws NullPointerException {
        first = null;
    }

    /**
     * Busca un nodo en la lista y devuelve su posicion.
     * @param value dato del nodo que se busca
     * @return int posicion del nodo en la lista
     * @throws NullPointerException
     */
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

    
    /**
     * Comprueba si la lista esta vacia.
     * @return boolean
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * Inserta un elemento al inicio de la lista.
     * @param dd dato del nodo por insertar
     */
    public void insertFirst(T dd) {
        Link<T> newLink = new Link<T>(dd);
        newLink.setNext(first);
        first = newLink;
    }

    /**
     * Elimina el primer elemento de la lista.
     * @return Link<T>
     * @throws NullPointerException
     */
    public Link<T> deleteFirst() throws NullPointerException{
        Link<T> temp = null;

        if(isEmpty())
            throw new NullPointerException("La lista esta vacia.");
        
        temp = first;
        first = first.getNext();
        return temp;
    }

    /**
     * Imrpime el contenido de la lista.
     */
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
