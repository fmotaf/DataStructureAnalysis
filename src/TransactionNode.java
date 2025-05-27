public class TransactionNode {
    Transaction data;
    TransactionNode prev;
    TransactionNode next;

    public TransactionNode(Transaction data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

