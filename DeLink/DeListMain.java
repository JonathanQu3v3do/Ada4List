package DeLink;

public class DeListMain {
    public static void main(String[] args) throws NullPointerException {
        DELinkList list = new DELinkList();
        try {
            list.insertFirst(8);
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

            list.deletLink(10);
            list.displayList();
            System.out.println("ultimo: " + list.lastNode().getdData());

            list.deleteAll();
            list.displayList();

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}