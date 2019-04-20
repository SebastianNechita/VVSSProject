package Service.TxtFileService;

import Exceptions.ValidatorException;
import Repository.TxtFileRepository.StudentFileRepo;
import Repository.TxtFileRepository.TemaLabFileRepo;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TemaLabServiceTest {
    TemaLabFileRepo assignmentRepo;
    TemaLabService assignmentService;
    StudentFileRepo studentRepo;
    StudentService studentService;
    @Before
    public void init() throws IOException {
        studentRepo = new StudentFileRepo("a.txt", new StudentValidator());
        studentService = new StudentService(studentRepo);
        assignmentRepo = new TemaLabFileRepo("b.txt", new TemaLabValidator());
        assignmentService = new TemaLabService(assignmentRepo);
    }

    @Test
    public void addAssignment() {
        assert(assignmentService.size() == 0);
        try{
            assignmentService.add(new String[]{"2", "Emy", "12", "12"});
        }
        catch (ValidatorException e) {
            assert(false);
        }
        assert(assignmentService.size() == 1);
    }


}