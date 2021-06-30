import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Node tail;
    private int size;

    private class Node {
        private Node prev;
        private Transaction data;
        private Node next;

        public Node(Node prev, Transaction data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void addTransaction(Transaction data) {
        if (size == 0) {
            tail = new Node(tail, null, tail);
            Node newNode = new Node(tail, data, tail);
            tail.prev = newNode;
            tail.next = newNode;
            size++;
        } else {
            Node newNode = new Node(tail.prev, data, tail);
            tail.prev.next = newNode;
            tail.prev = newNode;
            size++;
        }
    }

    @Override
    public void deleteTransaction(UUID id) throws TransactionNotFoundException {
        if (size == 0) {
            throw new TransactionNotFoundException("TransactionNotFoundException");
        } else {
            Node tmp = tail.next;

            while (tmp.data.getId() != id && tmp != tail) {
                tmp = tmp.next;
            }

            if (tmp == tail) {
                throw new TransactionNotFoundException("TransactionNotFoundException");
            } else {
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
                tmp.data = null;
                tmp.next = null;
                tmp.prev = null;
            }
        }
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] result = new Transaction[size];

        int i = 0;

        for (Node temp = tail.next; temp != tail; temp = temp.next) {
            result[i++] = temp.data;
        }

        return result;
    }

    public TransactionsLinkedList TransactionsLinkedList(){
        return (new TransactionsLinkedList());
    }

    public int getSize() {
        return size;
    }
}