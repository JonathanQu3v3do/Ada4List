package DoublyLink;
/**
 * La clase DoublyLink representa cada Nodo de la Lista.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
 */
public class DoublyLink<T> {
    private T dData; // dato que guarda el nodo
    private DoublyLink<T> previous; // referencia al nodo anterior de la lista
    private DoublyLink<T> next; // referencia al siguiente nodo de la lista

    /**
     * Constructor para DoublyLink con referencia null al nodo anterior y siguiente.
     * @param dd contiene los datos de un nodo
     */
    public DoublyLink(T dd ) {
        dData = dd;
        previous = null;
        next = null;
    }

    /**
     * Imrpime el contenido del nodo.
     */
    public void displayLink() {
        System.out.print("{" + getdData() + "} ");
    }

    /**
     * Devuelve el dato guardado en el nodo.
     * @return T dato guardado en el nodo
     */
    public T getdData() {
        return dData;
    }
    /**
     * Establece el dato almacenado en el nodo.
     * @param dData dato a guardar en el nodo
     */
    public void setdData(T dData) {
        this.dData = dData;
    }
    
    /**
     * Establece la referencia al nodo anterior de la lista.
     * @param previous nueva referencia al nodo anterior de la lista
     */
    public void setPrevious(DoublyLink<T> previous) {
        this.previous = previous;
    }
    /** 
     * Devuelve la referencia al nodo anterior de la lista.
     * @return DoublyLink<T>
     */
    public DoublyLink<T> getPrevious() {
        return previous;
    }

    /** 
     * Devuelve la referencia al siguiente nodo de la lista.
     * @return DoublyLink<T>
     */
    public DoublyLink<T> getNext() {
        return next;
    }
    /**
     * Establece la referencia al siguiente nodo de la lista.
     * @param next nueva referencia al siguiente nodo de la lista
     */
    public void setNext(DoublyLink<T> next) {
        this.next = next;
    }
}
