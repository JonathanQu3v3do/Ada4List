package Link;
/**
 * La clase Link representa cada Nodo de la Lista.
 * @author: Andrea Torres y Jonathan Quevedo
 * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
 */
public class Link<T> {
    private T dData; // dato que guarda el nodo
    private Link<T> next; // referencia al siguiente nodo de la lista

    /**
     * Constructor para Link con referencia null al siguiente nodo.
     * @param dd contiene los datos de un nodo
     */
    public Link(T dd) {
        dData = dd;
        next = null;
    }

    /**
     * Imrpime el contenido del nodo
     */
    public void displayLink() {
        System.out.print("{" + getdData() + "} ");
    }

    /**
     * Devuelve el dato guardado en el nodo
     * @return T dato guardado en el nodo
     */
    public T getdData() {
        return dData;
    }
    /**
     * Establece el dato almacenado en el nodo
     * @param dData dato a guardar en el nodo
     */
    public void setdData(T dData) {
        this.dData = dData;
    }

    /**
     * Devuelve la referencia al siguiente nodo de la lista.
     * @return Link<T> referencia al siguiente nodo de la lista
     */
    public Link<T> getNext() {
        return next;
    }
    /**
     * Establece la referencia al siguiente nodo de la lista
     * @param next nueva referencia al siguiente nodo de la lista
     */
    public void setNext(Link<T> next) {
        this.next = next;
    }
}