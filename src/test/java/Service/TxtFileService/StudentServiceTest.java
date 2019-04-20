package Service.TxtFileService;

import Exceptions.ValidatorException;
import Repository.TxtFileRepository.StudentFileRepo;
import Validator.StudentValidator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class StudentServiceTest {
    StudentFileRepo studentRepo;
    StudentService studentService;
    @Before
    public void init() throws IOException {
        studentRepo = new StudentFileRepo("a.txt", new StudentValidator());
        studentService = new StudentService(studentRepo);
    }

    @Test
    public void addStudent() {

        assert(studentService.size() == 0);
        try{
            studentService.add(new String[]{"1", "Emy", "935", "emy@emy.emy", "yme"});
        }
        catch (ValidatorException e) {
            assert(false);
        }
        assert(studentService.size() == 1);
    }

    @Test
    public void addStudentTopDown() {

        assert(studentService.size() == 0);
        try{
            studentService.add(new String[]{"1", "Emy", "935", "emy@emy.emy", "yme"});
        }
        catch (ValidatorException e) {
            assert(false);
        }
        assert(studentService.size() == 1);
    }

}