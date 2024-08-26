package ku.cs.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    @Test
    public void testAddNewStudent() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("620000001", "StudentTest1");

        Student student = studentList.findStudentById("620000001");
        assertNotNull(student);
        assertEquals("StudentTest1", student.getName());
    }

    @Test
    public void testAddNewStudentWithScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("620000002", "StudentTest2", 75.5);

        Student student = studentList.findStudentById("620000002");
        assertNotNull(student);
        assertEquals("StudentTest2", student.getName());
        assertEquals(75.5, student.getScore());
    }

    @Test
    public void testAddNewStudentWithDuplicateId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("620000003", "StudentTest1");
        studentList.addNewStudent("620000003", "StudentTest2");

        ArrayList<Student> students = studentList.getStudents();
        assertEquals(1, students.size());
        assertEquals("StudentTest1", students.get(0).getName());
    }

    @Test
    public void testFindStudentById() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("620000004", "StudentTest1");

        Student student = studentList.findStudentById("620000004");
        assertNotNull(student);
        assertEquals("StudentTest1", student.getName());
    }

    @Test
    public void testGiveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("620000005", "StudentTest");

        studentList.giveScoreToId("620000005", 90.0);

        Student student = studentList.findStudentById("620000005");
        assertEquals(90.0, student.getScore());
    }

    @Test
    public void testViewGradeOfId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("620000006", "StudentTest", 85.0);

        String grade = studentList.viewGradeOfId("620000006");
        assertEquals("F", grade);
    }

    @Test
    public void testViewGradeOfNonExistentId() {
        StudentList studentList = new StudentList();

        String grade = studentList.viewGradeOfId("620000007");
        assertNull(grade);
    }
}