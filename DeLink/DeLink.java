package DeLink;
/**
 * La clase DeLink representa cada Nodo de la Lista.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
 */
public class DeLink<T> {
    private T dData; // dato que guarda el nodo
    private DeLink<T> next; // referencia al siguiente nodo de la lista

    /**
     * Constructor para DeLink con referencia null al nodo siguiente.
     * @param dd contiene los datos de un nodo
     */
    public DeLink(T dd ) {
        dData = dd;
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
     * Devuelve la referencia al siguiente nodo de la lista.
     * @return DeLink<T>
     */
    public DeLink<T> getNext() {
        return next;
    }
    /**
     * Establece la referencia al siguiente nodo de la lista.
     * @param next nueva referencia al siguiente nodo de la lista
     */
    public void setNext(DeLink<T> next) {
        this.next = next;
    }
}
