package Link;

/**
 * La clase Link
 * representa cada Nodo de la Lista, y tiene sólo dos atributos:
 * la data que contiene y la referencia al siguiente Nodo de la Lista.
 * 
 * @author: Andrea torres y Jonathan Quevedo
 * 
 * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
 * 
 */

public class Link<T> {
    private T dData;
    private Link<T> next;

    /**
     * 
     * Constructor para link
     * 
     * @param dd El parámetro dd contiene datos de un nodo y ademas tiene una liga
     *           al siguiente nodo
     * 
     */

    public Link(T dd) {
        dData = dd;
        next = null;
    }

    /**
     * 
     * Método que imrpime el contenido del nodo
     * 
     */

    public void displayLink() {
        System.out.print("{" + getdData() + "} ");
    }

    /**
     * @return T
     */
    public T getdData() {
        return dData;
    }

    /**
     * @param dData
     */
    public void setdData(T dData) {
        this.dData = dData;
    }

    /**
     * @return Link<T>
     */
    public Link<T> getNext() {
        return next;
    }

    /**
     * @param next
     */
    public void setNext(Link<T> next) {
        this.next = next;
    }
} // Cierre de la clase