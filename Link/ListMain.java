package Link;

public class ListMain {
    /**
     * 
     * Esta es la clase ListMain del programa
     * 
     * 
     * @author: Andrea Torres y Jonathan Quevedo
     * 
     * 
     * @see <https://github.com/JonathanQu3v3do/Ada4List.git>
     * 
     */

    /**
     * @param args
     * @throws NullPointerException
     */
    public static void main(String[] args) throws NullPointerException {

        LinkList<Integer> list = new LinkList<Integer>();
        LinkList<String> list2 = new LinkList<String>();

        try {
            list.insertFirst(8);
            list.insertFirst(9);
            list.insertFirst(7);
            list.insertFirst(11);
            list.displayList();
            System.out.println("El primer elemento de la lista es: " + list.firstNode().getdData());
            System.out.println("El ultimo elemento de la lista es: " + list.lastNode().getdData());
            System.out.println("El tamaño de la lista es: " + list.size());
            list.deleteFirst();
            list.deleteFirst();
            list.deleteFirst();
            list.deleteFirst();

            list.mayorNode(81);
            list.mayorNode(2);
            list.mayorNode(86);
            list.mayorNode(3);
            list.updateNode(2, 1);
            list.updateNodeat(0, 82);
            list.displayList();
            list.deleteAt(1);
            list.displayList();
            System.out.println("El valor 82 esta en la posicion: " + list.find(82));

            System.out.println("El primer elemento de la lista es: " + list.firstNode().getdData());
            System.out.println("El ultimo elemento de la lista es: " + list.lastNode().getdData());
            System.out.println("El tamaño de la lista es: " + list.size());
            list.deleteAll();
            System.out.println("se elimino el contenido de la lista");

            list2.menorNode("a");
            list2.menorNode("z");
            list2.menorNode("c");
            list2.displayList();

            System.out.print("El primer dato de la lista es: " + list2.firstNode().getdData() + "\n");
            System.out.print("El ultimo dato de la lista es: " + list2.lastNode().getdData() + "\n");
            System.out.println("el tamaño de la lista es: " + list2.size());

            System.out.println("El valor a esta en la posicion: " + list2.find("a"));

            list2.updateNode("a", "b");
            list2.displayList();

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
} //Cierre de la clase 
