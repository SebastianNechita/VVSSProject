package Service.TxtFileService;

import Exceptions.ValidatorException;
import Repository.TxtFileRepository.TemaLabFileRepo;
import Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TemaLabServiceTest {
    TemaLabFileRepo assignmentRepo;
    TemaLabService assignmentService;
    @Before
    public void init() throws IOException {
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