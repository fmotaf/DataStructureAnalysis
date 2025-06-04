package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;
import main.Link;
import main.StudentData;

class TestDoubleLinkedList {

    @Test
    void iterator() {
        DoubleLinkedList list = new DoubleLinkedList();
        StudentData s1 = new StudentData("1", 20, "M", 2, 1, 1, false, 90, 8, "Good", 3, "High", "Good", 8, true, 80);
        StudentData s2 = new StudentData("2", 21, "F", 3, 2, 2, true, 95, 7, "Average", 2, "Medium", "Average", 7, false, 85);
        list.add(s1);
        list.add(s2);
        int count = 0;
        for (Link l : list) {
            assertNotNull(l.getData());
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    void add() {
        DoubleLinkedList list = new DoubleLinkedList();
        StudentData s1 = new StudentData("1", 20, "M", 2, 1, 1, false, 90, 8, "Good", 3, "High", "Good", 8, true, 80);
        list.add(s1);
        assertEquals(s1, list.iterator().next().getData());
    }

    @Test
    void removeById() {
        DoubleLinkedList list = new DoubleLinkedList();
        StudentData s1 = new StudentData("1", 20, "M", 2, 1, 1, false, 90, 8, "Good", 3, "High", "Good", 8, true, 80);
        StudentData s2 = new StudentData("2", 21, "F", 3, 2, 2, true, 95, 7, "Average", 2, "Medium", "Average", 7, false, 85);
        list.add(s1);
        list.add(s2);
        assertTrue(list.removeById("1"));
        assertNull(list.findById("1"));
        assertNotNull(list.findById("2"));
    }

    @Test
    void findById() {
        DoubleLinkedList list = new DoubleLinkedList();
        StudentData s1 = new StudentData("1", 20, "M", 2, 1, 1, false, 90, 8, "Good", 3, "High", "Good", 8, true, 80);
        list.add(s1);
        assertEquals(s1, list.findById("1"));
        assertNull(list.findById("999"));
    }

    @Test
    void delete() {
        DoubleLinkedList list = new DoubleLinkedList();
        StudentData s1 = new StudentData("1", 20, "M", 2, 1, 1, false, 90, 8, "Good", 3, "High", "Good", 8, true, 80);
        StudentData s2 = new StudentData("2", 21, "F", 3, 2, 2, true, 95, 7, "Average", 2, "Medium", "Average", 7, false, 85);
        list.add(s1);
        list.add(s2);
        list.delete();
        assertNull(list.findById("2"));
        assertNotNull(list.findById("1"));
        list.delete();
        assertNull(list.findById("1"));
    }

    @Test
    void removeFromEmptyList() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertFalse(list.removeById("1"));
        assertNull(list.findById("1"));
    }

    @Test
    void deleteOnEmptyList() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.delete(); // Não deve lançar exceção
        assertNull(list.findById("1"));
    }

    @Test
    void iteratorOnEmptyList() {
        DoubleLinkedList list = new DoubleLinkedList();
        int count = 0;
        for (Link l : list) {
            count++;
        }
        assertEquals(0, count);
    }

    @Test
    void addAndRemoveMultiple() {
        DoubleLinkedList list = new DoubleLinkedList();
        StudentData s1 = new StudentData("1", 20, "M", 2, 1, 1, false, 90, 8, "Good", 3, "High", "Good", 8, true, 80);
        StudentData s2 = new StudentData("2", 21, "F", 3, 2, 2, true, 95, 7, "Average", 2, "Medium", "Average", 7, false, 85);
        StudentData s3 = new StudentData("3", 22, "M", 4, 3, 3, false, 88, 9, "Excellent", 4, "High", "Excellent", 9, true, 90);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        assertTrue(list.removeById("2"));
        assertNull(list.findById("2"));
        assertNotNull(list.findById("1"));
        assertNotNull(list.findById("3"));
    }

    @Test
    void removeNonExistent() {
        DoubleLinkedList list = new DoubleLinkedList();
        StudentData s1 = new StudentData("1", 20, "M", 2, 1, 1, false, 90, 8, "Good", 3, "High", "Good", 8, true, 80);
        list.add(s1);
        assertFalse(list.removeById("999"));
    }

    @Test
    void testToString() {
        DoubleLinkedList list = new DoubleLinkedList();
        assertTrue(list.toString().contains("DoublyLinkedList"));
    }

    @Test
    void printAll() {
        DoubleLinkedList list = new DoubleLinkedList();
        list.printAll(); // Apenas para cobrir o método, sem assert
    }
}