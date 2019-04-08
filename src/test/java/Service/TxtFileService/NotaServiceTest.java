package Service.TxtFileService;

import Exceptions.ValidatorException;
import Repository.TxtFileRepository.NotaFileRepo;
import Validator.NotaValidator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class NotaServiceTest {
    NotaFileRepo gradeRepo;
    NotaService gradeService;
    @Before
    public void init() throws IOException {
        gradeRepo = new NotaFileRepo("c.txt", new NotaValidator());
        gradeService = new NotaService(gradeRepo);
    }

    @Test
    public void addGrade() {
        try{
            gradeService.add(new String[]{"3", "1", "2", "5", "2019-03-07T10:11:30"});
        }
        catch (ValidatorException e) {
            assert(false);
        }
        assert(gradeService.size() == 1);
    }


}