package Link;

/**
 * 
 * Esta clase solo tiene 1 atributo: first, que hace referencia al primer
 * elemento de la Lista.
 * La clase LinkList cuenta con varios metodos que hacen diferentes operaciones
 * que se adaptan al manejo
 * de una lista enlazada
 * 
 * @author: Andrea Torres y Jonathan Quevedo
 * 
 * 
 * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
 * 
 */

public class LinkList<T extends Comparable<T>> {
    private Link<T> first;

    public LinkList() {
        first = null;
    }

    /**
     * @return Link<T>
     * @throws NullPointerException
     *                              Método que devuelva el primer elemento
     */
    // 1
    public Link<T> firstNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        return first;
    }

    /**
     * @return Link<T>
     * @throws NullPointerException
     *                              Método que devuelva el último elemento
     */
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

    /**
     * @return int
     *         Método que devuelva el tamaño de la lista
     */
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

    /**
     * @param key
     *            metodo para insertar un nodo y ordenar de mayor a menor
     */
    // 3
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
     * @param key
     *            metodo para insertar un nodo y ordenar de menor a mayor
     */
    // 3
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
     * @param datoActual
     * @param datoNuevo
     * @throws NullPointerException
     *                              metodo para actualizar el dato de un nodo
     */
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

    /**
     * @param index
     * @param datoNuevo
     * @throws NullPointerException
     *                              metodo para actualizar el dato de un nodo
     */
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

    /**
     * @param dato
     * @return Link<T>
     * @throws NullPointerException
     *                              metodo para eliminar un elemento proporcionado
     */
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

    /**
     * @param index
     * @throws NullPointerException
     *                              Método para eliminar un elemento de una posición
     *                              en la lista.
     */
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

    /**
     * @throws NullPointerException
     *                              metodo para limpiar la lista
     */
    // 8
    public void deleteAll() throws NullPointerException {
        first = null;

    }

    /**
     * @param value
     * @return int
     * @throws NullPointerException
     *                              Método para hacer una búsqueda de un elemento
     */
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

    /**
     * @return boolean
     *         metodo que comprueba si la lista esta vacia
     */
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * @param dd
     *           metodo que inserta un elemento al inicio de la lista
     */
    public void insertFirst(T dd) {
        Link<T> newLink = new Link<T>(dd);
        newLink.setNext(first);
        first = newLink;
    }

    /**
     * @return Link<T>
     *         metodo que elimina el primer elemento de la lista
     */
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
}//Cierre de la clase 
