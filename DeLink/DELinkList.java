package DeLink;
/**
 * Esta clase maneja la lista ligada simple con doble puntero.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
 */
public class DELinkList<T extends Comparable<T>> {
    private DeLink<T> first; //hace referencia al primer elemento de la Lista.
    private DeLink<T> last; //hace referencia al ultimo elemento de la Lista.

    /**
     * Constructor para DELinkList con referencia null al primer y ultimo nodo de la lista.
     */
    public DELinkList() {
        first = null;
        last = null;
    }

    /** 
     * Devuelve el primer elemento de la lista.
     * @return DeLink<T>
     * @throws NullPointerException
     */
    public DeLink<T> firstNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        return first;
    }

    /** 
     * Devuelve el ultimo elemento de la lista.
     * @return DeLink<T>
     * @throws NullPointerException
     */
    public DeLink<T> lastNode() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("la lista esta vacia ");
        }
        return last;
    }

    /**
     * Devuelve el tamaño de la lista.
     * @return int cantidad de nodos.
     */
    public int size() {
        DeLink<T> current = first;
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
        DeLink<T> newLink = new DeLink<T>(key);
        DeLink<T> previous = null;
        DeLink<T> current = first;
        
        while (current != null && key.compareTo(current.getdData()) < 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null)
            insertFirst(key);
        else {
            previous.setNext(newLink);
            newLink.setNext(current);
            if(current == null) last = newLink;
        }
    }

    /**
     * Inserta un nuevo nodo en la lista en orden creciente.
     * @param key dato para el nuevo nodo
     */
    public void menorNode(T key) {
        DeLink<T> newLink = new DeLink<T>(key);
        DeLink<T> previous = null;
        DeLink<T> current = first;
        
        while (current != null && key.compareTo(current.getdData()) > 0) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null)
            insertFirst(key);
        else {
            previous.setNext(newLink);
            newLink.setNext(current);
            if(current == null) last = newLink;
        }
    }

    /**
     * Actualiza el dato de un nodo con un dato nuevo.
     * @param datoActual el dato del nodo que se busca en la lista
     * @param datoNuevo el nuevo dato por el que se cambia datoActual
     * @throws NullPointerException
     */
    public void updateNode(T datoActual, T datoNuevo) throws NullPointerException {
        DeLink<T> current = first;
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
     * Actualiza el dato de un nodo, busca el nodo por posicion.
     * @param index posicion del nodo por actualizar
     * @param datoNuevo dato por el que se cambia el dato del nodo
     * @throws NullPointerException
     */
    public void updateNodeAt(int index, T datoNuevo) throws NullPointerException {
        DeLink<T> current = first;

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
     * @param dato dato del nodo que se va a eliminar
     * @return DeLink<T>
     * @throws NullPointerException
     */
    public DeLink<T> deletLink(T dato) throws NullPointerException {
        DeLink<T> current = first;
        DeLink<T> temp = first;
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

    /** 
     * Elimina el nodo de una posición en la lista.
     * @param index posicion del nodo por eliminar
     * @return DeLink<T>
     * @throws NullPointerException
     */
    public DeLink<T> deleteAt(int index) throws NullPointerException {
        DeLink<T> current = first;
        DeLink<T> temp = null;

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

    /** 
     * Elimina todos los datos de la lista.
     * @throws NullPointerException
     */
    public void deleteAll() throws NullPointerException {
        first = null;
        last = null;
    }

    /**
     * Busca un nodo en la lista y devuelve su posicion.
     * @param value dato del nodo que se busca
     * @return int posicion del nodo en la lista
     * @throws NullPointerException
     */
    public int find(T value) throws NullPointerException {
        DeLink<T> current = first;
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
        DeLink<T> newLink = new DeLink<T>(dd);
        
        if(isEmpty()) last = newLink;

        newLink.setNext(first);
        first = newLink;
    }

    /** 
     * Elimina el primer elemento de la lista.
     * @return DeLink<T>
     * @throws NullPointerException
     */
    public DeLink<T> deleteFirst() throws NullPointerException{
        DeLink<T> temp = first;

        if (isEmpty()) {
            throw new NullPointerException("La lista esta vacia.");
        }
        
        if(first.getNext() == null) last = null;
        
        first = first.getNext();
        return temp;
    }

    /** 
     * Inserta un elemento al final de la lista.
     * @param dato dato del nodo por insertar
     */
    public void insertLast(T dato) {
        DeLink<T> newLink = new DeLink<T>(dato);
        DeLink<T> current = first;

        if(!isEmpty()){
            while(current.getNext() != null) {
                current = current.getNext(); 
            }
            current.setNext(newLink);
        }
        else first = newLink;

        last = newLink;
    }

    /** 
     * Elimina el ultimo elemento de la lista.
     * @return DeLink<T>
     * @throws NullPointerException
     */
    public DeLink<T> deletetLast() throws NullPointerException{
        DeLink<T> current = first;
        DeLink<T> temp = first;

        if(isEmpty())
            throw new NullPointerException("La lista esta vacia.");
        
        while(current.getNext().getNext() != null) {
            current = current.getNext();
        }
        temp = current.getNext();
        current.setNext(null);
        last = current;

        return temp;
    }

    /**
     * Imrpime el contenido de la lista.
     */
    public void displayList() {
        System.out.print("List (first--> ");
        DeLink<T> current = first;

        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }
}
