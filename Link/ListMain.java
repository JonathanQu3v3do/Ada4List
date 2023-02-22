package Link;

public class ListMain {
    public static void main(String[] args) throws NullPointerException {
        LinkList<Integer> list = new LinkList<Integer>();
        LinkList<String> list2 = new LinkList<String>();
        
        try {
            list2.mayorNode("a");
            list2.mayorNode("z");
            list2.mayorNode("c");
            list2.displayList();

            
            System.out.print("El primer dato de la lista es: " + list2.firstNode().getdData() +"\n");

            System.out.print("El ultimo dato de la lista es: " + list2.lastNode().getdData() + "\n");
            
            System.out.println("el tamaño de la lista es: " + list2.size());

            //int value = 1;
            //System.out.println("El valor " + value + " esta en la posicion: " +list2.find(value));

           // list.updateNode(8, 9);
            //list.displayList();

            //list.updateNodeat(0, 2);
            //list.displayList();

            //list.deleteAll();
            //list.displayList();

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
