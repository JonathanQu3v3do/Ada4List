package DoublyLink;

public class DoublyListMain {
    
    /** 
     * @param args
     * @throws NullPointerException
     */
    public static void main(String[] args) throws NullPointerException {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        DoublyLinkedList<String> list2 = new DoublyLinkedList<String>();
        try {
            list2.mayorNode("a");
            list2.mayorNode("z");
            list2.mayorNode("c");
            list2.displayList();
            list2.updateNodeAt(2, "t");
            list2.displayList();

            System.out.print("El primer dato de la lista es: " + list2.firstNode().getdData() +"\n");
            System.out.print("El ultimo dato de la lista es: " + list2.lastNode().getdData() + "\n");
            System.out.println("el tamaño de la lista es: " + list2.size());

            
            list.insertFirst(8);
            list.insertLast(9);
            list.menorNode(6);
            list.menorNode(10);
            list.menorNode(7);
            list.displayList();
            
            System.out.print("El primer dato de la lista es: " + list.firstNode().getdData() +"\n");

            System.out.print("El ultimo dato de la lista es: " + list.lastNode().getdData() + "\n");
            
            System.out.println("el tamaño de la lista es: " + list.size());

            int value = 1;
            System.out.println("El valor " + value + " esta en la posicion: " +list.find(value));

            list.updateNode(8, 9);
            list.displayList();

            list.updateNodeAt(0, 2);
            list.displayList();

            list.deletLink(7);
            list.displayList();
            System.out.println("ultimo: " + list.lastNode().getdData());

            list.deletetLast();
            list.displayList();

            list.deleteAll();
            list.displayList();

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
