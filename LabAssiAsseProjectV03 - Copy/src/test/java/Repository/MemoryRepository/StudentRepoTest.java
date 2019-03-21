package Repository.MemoryRepository;

import Domain.Student;
import Exceptions.ValidatorException;
import Validator.IValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentRepoTest {
    StudentRepo repo;
    @Before
    public void setUp() {
        repo = new StudentRepo(entity -> {

        });
    }

    @Test
    public void addStudent() {
        try {
            repo.save(new Student("1", "Sebi", 935, "sebinechita@yahoo.com", "Prof. Laura Diosan"));
        } catch (ValidatorException e) {
            assert false;
        }
        assertEquals(repo.size(), 1);
    }
}