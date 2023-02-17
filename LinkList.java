public class LinkList {
    private Link first;

    public LinkList() {
        first = null;

    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(double dd) {
        Link newLink = new Link(dd);
        newLink.setNext(first);
        // newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = null;
        if (!isEmpty()) {
            temp = first;
            first = first.getNext();
            // first = first.next;
        }
        return temp;
    }

    public void displayList() {
        System.out.print("List (first--> ");
        Link current = first;

        // Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
            // current = current.next;
        }
        System.out.println("<--last)");
    }

}
