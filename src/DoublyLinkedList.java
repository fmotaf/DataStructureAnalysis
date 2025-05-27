public class DoublyLinkedList {
    private TransactionNode head;
    private TransactionNode tail;

    public void add(Transaction data) {
        TransactionNode newNode = new TransactionNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean removeById(String id) {
        TransactionNode current = head;
        while (current != null) {
            if (current.data.getId().equals(id)) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;
                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Transaction findById(String id) {
        TransactionNode current = head;
        while (current != null) {
            if (current.data.getId().equals(id)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void printAll() {
        TransactionNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
