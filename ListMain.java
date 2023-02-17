public class ListMain {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        try {
            list.insertFirst(5);
            list.insertFirst(6);
            list.insertFirst(10);
            list.displayList();

            list.firstNode();
            list.LastNode();

        } catch (IsEmptyException e) {

            e.printStackTrace();
        }

    }
}
