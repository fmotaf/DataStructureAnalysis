package main;

import java.util.Iterator;

public class DoubleLinkedList implements Iterable<Link> {
    private Link head;
    private Link tail;

    private Iterator<Link> iterator;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.iterator = iterator;
    }

    @Override
    public Iterator<Link> iterator() {
        return new Iterator<Link>() {
            private Link current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Link next() {
                Link temp = current;
                current = current.getNext();
                return temp;
            }
        };
    }

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
        Iterator<Link> it = this.iterator();
        while (it.hasNext()) {
            Link current = it.next();
            if (current.getData().getStudentId().equals(id)) {
                if (current.getPrevious() != null) current.getPrevious().setNext(current.getNext());
                else head = current.getNext();
                if (current.getNext() != null) current.getNext().setPrevious(current.getPrevious());
                else tail = current.getPrevious();
                return true;
            }
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

    // Delete the last Node/Link in the list
    public void delete(){
        if (tail == null) return; // Lista vazia
        if (tail.getPrevious() == null) { // Só um elemento
            head = tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
    }

    // Ordena por studentId (String)
    public void sortById() {
        boolean swapped;
        do {
            swapped = false;
            Link current = head;
            while (current != null && current.getNext() != null) {
                if (current.getData().getStudentId().compareTo(current.getNext().getData().getStudentId()) > 0) {
                    StudentData temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }

    // Ordena por idade (int)
    public void sortByAge() {
        boolean swapped;
        do {
            swapped = false;
            Link current = head;
            while (current != null && current.getNext() != null) {
                if (current.getData().getAge() > current.getNext().getData().getAge()) {
                    StudentData temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }

    // Ordena por qualquer atributo usando Comparator<StudentData>
    public void sort(java.util.Comparator<StudentData> comparator) {
        boolean swapped;
        do {
            swapped = false;
            Link current = head;
            while (current != null && current.getNext() != null) {
                if (comparator.compare(current.getData(), current.getNext().getData()) > 0) {
                    StudentData temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
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
