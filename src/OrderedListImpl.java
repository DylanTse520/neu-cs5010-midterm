import java.util.function.Predicate;

public class OrderedListImpl<E extends Comparable<E>> implements OrderedList<E> {

    Node<E> head;

    public OrderedListImpl() {
        head = null;
    }

    @Override
    public void add(E val) {
        Node<E> newNode = new Node<>(val);

        // if list is null
        if (head == null) {
            head = newNode;
            return;
        }

        Node<E> current = head;

        // if val is the smallest amongst the all
        if (val.compareTo(current.val) < 0) {
            newNode.next = current;
            head = newNode;
            return;
        }

        while (current.next != null) {
            if (val.compareTo(current.val) >= 0 && val.compareTo(current.next.val) < 0) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }

        current.next = newNode;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        int sizeCount = 0;
        Node<E> current = head;

        while (sizeCount < index) {
            sizeCount++;
            current = current.next;
        }

        return current.val;
    }

    @Override
    public int size() {
        int sizeCount = 0;
        Node<E> current = head;

        while (current != null) {
            sizeCount++;
            current = current.next;
        }

        return sizeCount;
    }

    @Override
    public OrderedList<E> subList(Predicate<E> pred) {
        OrderedList<E> newList = new OrderedListImpl<>();
        for (int i = 0; i < this.size(); i++) {
            if (pred.test(this.get(i))) {
                newList.add(this.get(i));
            }
        }
        return newList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> current = head;

        while (current != null) {
            result.append(current.val.toString());
            current = current.next;
            if (current != null) {
                result.append(" ");
            }
        }

        return result.toString();
    }

}
