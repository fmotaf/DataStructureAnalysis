package main;

import java.util.Objects;

// this is a doubly linked list Node (or Link)
public class Link {

    private StudentData data = null;
    private Link next = null;
    private Link previous = null;

    public Link(){
        this.data = null;
        this.next = null;
        this.previous = null;
    }

    public Link(StudentData data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public StudentData getData() {
        return data;
    }

    public void setData(StudentData data) {
        this.data = data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Link getPrevious() {
        return previous;
    }

    public void setPrevious(Link previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Link{" +
                "data=" + data +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Link link)) return false;
        return Objects.equals(data, link.data) && Objects.equals(next, link.next) && Objects.equals(previous, link.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next, previous);
    }
}
