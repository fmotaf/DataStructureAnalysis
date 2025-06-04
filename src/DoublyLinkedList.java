public class DoublyLinkedList {
    private Link head;
    private Link tail;

    public void add(StudentData data) {
        Link newNode = new Link(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
    }

    public boolean removeById(String id) {
        Link current = head;
        while (current != null) {
            if (current.getData().getStudentId().equals(id)) {
                if (current.getPrevious() != null) current.getPrevious().setNext(current.getNext());
                else head = current.getNext();
                if (current.getNext() != null) current.getNext().setPrevious(current.getPrevious());
                else tail = current.getPrevious();
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public StudentData findById(String id) {
        Link current = head;
        while (current != null) {
            if (current.getData().getStudentId().equals(id)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    public void printAll() {
        Link current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
