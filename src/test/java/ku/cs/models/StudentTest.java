package ku.cs.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class StudentTest {

    @Test
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }

    @Test
    void testChangeName(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.changeName("New Name");
        assertEquals("New Name", s.getName());
    }
    @Test
    void testGrade() {
        Student s = new Student("6xxxxxxxx", "StudentTest", 50.0);
        String grade = s.grade();
        assertEquals("F", grade);
    }

    @Test
    void testIsId() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertTrue(s.isId("6xxxxxxxx"));
        assertFalse(s.isId("7yyyyyyyy"));
    }

    @Test
    void testToString() {
        Student s = new Student("6xxxxxxxx", "StudentTest", 45.15);
        String expected = "{id: '6xxxxxxxx', name: 'StudentTest', score: 45.15}";
        assertEquals(expected, s.toString());
    }
}