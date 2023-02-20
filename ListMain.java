public class ListMain {
    public static void main(String[] args) throws NullPointerException {
        LinkList list = new LinkList();
        try {
            list.insertFirst(8);
            list.menorNode(6);
            list.menorNode(10);
            list.menorNode(7);
            list.displayList();
            
            System.out.print("El primer dato de la lista es: " + list.firstNode().getdData() +"\n");

            System.out.print("El ultimo dato de la lista es: " + list.LastNode().getdData() + "\n");
            
            System.out.println("el tamaño de la lista es: " + list.size());

             int value = 1;
             System.out.println("El valor " + value + " esta en la posicion: " +list.find(value));

            // list.deleLink(7);
            // list.displayList();

            // list.firstNode();
            // list.LastNode();

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
