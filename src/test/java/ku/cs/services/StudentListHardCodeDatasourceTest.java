package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {

    @Test
    void testReadData() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        StudentList list = datasource.readData();

        assertEquals(4, list.getStudents().size());
        assertNotNull(list.findStudentById("6410400001"));
    }

    @Test
    void testWriteData() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        StudentList list = new StudentList();
        list.addNewStudent("6410400006", "New Student", 50.0);

        datasource.writeData(list);
    }
}