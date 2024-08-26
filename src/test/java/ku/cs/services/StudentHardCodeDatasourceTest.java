package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList list = datasource.readData();

        assertEquals(4, list.getStudents().size());
        assertNotNull(list.findStudentById("6410400001"));
    }
}
