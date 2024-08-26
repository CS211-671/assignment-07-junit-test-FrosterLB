package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {

    private static final String DIRECTORY_NAME = "data";
    private static final String FILE_NAME = "student-list.csv";
    private StudentListFileDatasource datasource = new StudentListFileDatasource(DIRECTORY_NAME, FILE_NAME);

    @Test
    void testReadData() {
        StudentList list = datasource.readData();

        assertEquals(5, list.getStudents().size());
        assertNotNull(list.findStudentById("6410450001"));
    }

    @Test
    void testWriteData() {
        StudentList list = new StudentList();
        list.addNewStudent("6410450001", "Tim Berners-Lee", 45.5);
        list.addNewStudent("6410450002", "Barbara Liskov", 42.7);
        list.addNewStudent("6410450003", "Alan Turing", 46.2);
        list.addNewStudent("6410450004", "John McCarthy", 43.8);
        list.addNewStudent("6410450005", "Alan Kay", 46.0);

        datasource.writeData(list);

        StudentList readList = datasource.readData();
        assertEquals(5, readList.getStudents().size());

        assertEquals("Tim Berners-Lee", readList.findStudentById("6410450001").getName());
        assertEquals(45.5, readList.findStudentById("6410450001").getScore());
        assertEquals("Barbara Liskov", readList.findStudentById("6410450002").getName());
        assertEquals(42.7, readList.findStudentById("6410450002").getScore());
        assertEquals("Alan Turing", readList.findStudentById("6410450003").getName());
        assertEquals(46.2, readList.findStudentById("6410450003").getScore());
        assertEquals("John McCarthy", readList.findStudentById("6410450004").getName());
        assertEquals(43.8, readList.findStudentById("6410450004").getScore());
        assertEquals("Alan Kay", readList.findStudentById("6410450005").getName());
        assertEquals(46.0, readList.findStudentById("6410450005").getScore());
    }
}
