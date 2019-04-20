package Service.TxtFileService;

import Exceptions.ValidatorException;
import Repository.TxtFileRepository.NotaFileRepo;
import Repository.TxtFileRepository.StudentFileRepo;
import Repository.TxtFileRepository.TemaLabFileRepo;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class ServiceTest {
    StudentFileRepo studentRepo;
    StudentService studentService;
    TemaLabFileRepo assignmentRepo;
    TemaLabService assignmentService;
    NotaFileRepo gradeRepo;
    NotaService gradeService;
    @Before
    public void init() throws IOException {
        studentRepo = new StudentFileRepo("a.txt", new StudentValidator());
        studentService = new StudentService(studentRepo);
        assignmentRepo = new TemaLabFileRepo("b.txt", new TemaLabValidator());
        assignmentService = new TemaLabService(assignmentRepo);
        gradeRepo = new NotaFileRepo("c.txt", new NotaValidator());
        gradeService = new NotaService(gradeRepo);
    }

    @Test
    public void addGradeIntegration() {
        try{
            studentService.add(new String[]{"1", "Emy", "935", "emy@emy.emy", "yme"});
            assignmentService.add(new String[]{"2", "Emy", "12", "12"});
            Integer studentId = StreamSupport.stream(studentService.getAll().spliterator(), false).findFirst().get().getId();
            Integer assignmentId = StreamSupport.stream(assignmentService.getAll().spliterator(), false).findFirst().get().getId();
            gradeService.add(new String[]{"3", studentId.toString(), assignmentId.toString(), "5", "2019-03-07T10:11:30"});
        }
        catch (ValidatorException e) {
            assert(false);
        }
        assert(gradeService.size() == 1);
    }

    @Test
    public void addGradeIntegrationTopDown() {
        try{
            studentService.add(new String[]{"1", "Emy", "935", "emy@emy.emy", "yme"});
            assignmentService.add(new String[]{"2", "Emy", "12", "12"});
            Integer studentId = StreamSupport.stream(studentService.getAll().spliterator(), false).findFirst().get().getId();
            Integer assignmentId = StreamSupport.stream(assignmentService.getAll().spliterator(), false).findFirst().get().getId();
            gradeService.add(new String[]{"3", studentId.toString(), assignmentId.toString(), "5", "2019-03-07T10:11:30"});
        }
        catch (ValidatorException e) {
            assert(false);
        }
        assert(gradeService.size() == 1);
    }

    @Test
    public void addAssignmentIntegrationTopDown() {
        assert(studentService.size() == 0);
        assert(assignmentService.size() == 0);
        try{
            studentService.add(new String[]{"1", "Emy", "935", "emy@emy.emy", "yme"});
            assignmentService.add(new String[]{"2", "Emy", "12", "12"});
        }
        catch (ValidatorException e) {
            assert(false);
        }
        assert(studentService.size() == 1);
        assert(assignmentService.size() == 1);
    }
}