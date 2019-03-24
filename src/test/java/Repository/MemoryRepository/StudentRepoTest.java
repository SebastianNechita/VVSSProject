package Repository.MemoryRepository;

import Domain.Student;
import Exceptions.ValidatorException;
import Validator.IValidator;
import Validator.StudentValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentRepoTest {
    StudentRepo repo;
    @Before
    public void setUp() {
        repo = new StudentRepo(new StudentValidator());
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

    @Test
    public void addStudentName() {
        try {
            repo.save(new Student("1", "Sebi", 935, "sebinechita@yahoo.com", "Prof. Laura Diosan"));
        } catch (ValidatorException e) {
            assert false;
        }
        assertEquals(repo.size(), 1);
    }

    @Test
    public void addStudentNameNull() {
        try {
            repo.save(new Student("1", null, 935, "sebinechita@yahoo.com", "Prof. Laura Diosan"));
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
    }

    @Test
    public void addStudentNameEmpty() {
        try {
            repo.save(new Student("1", "", 935, "sebinechita@yahoo.com", "Prof. Laura Diosan"));
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
    }

    //TODO addStudentId...

    @Test
    public void addStudentEmail() {
        try {
            repo.save(new Student("1", "emi", 935, "abc@gmail.com", "Prof. Laura Diosan"));
            assert true;
        } catch (ValidatorException e) {
            assert false;
        }
        assertEquals(repo.size(), 1);
    }

    @Test
    public void addStudentEmailNull() {
        try {
            repo.save(new Student("1", "emi", 935, null, "Prof. Laura Diosan"));
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
    }

    @Test
    public void addStudentEmailEmpty() {
        try {
            repo.save(new Student("1", "emi", 935, "", "Prof. Laura Diosan"));
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
    }

    @Test
    public void addStudentEmailWrong() {
        try {
            repo.save(new Student("1", "emi", 935, "abc.com", "Prof. Laura Diosan"));
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
    }

    @Test
    public void addStudentGroup() {
        try {
            repo.save(new Student("1", "emi", 935, "abc@gmail.com", "Prof. Laura Diosan"));
            assert true;
        } catch (ValidatorException e) {
            assert false;
        }
        assertEquals(repo.size(), 1);
    }

    @Test
    public void addStudentGroupWrong() {
        try {
            repo.save(new Student("1", "emi", -123, "abc@gmail.com", "Prof. Laura Diosan"));
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
    }

    @Test
    public void addStudentIndrumator() {
        try {
            repo.save(new Student("1", "emi", 935, "abc@gmail.com", "Prof. Laura Diosan"));
            assert true;
        } catch (ValidatorException e) {
            assert false;
        }
        assertEquals(repo.size(), 1);
    }

    @Test
    public void addStudentIndrumatorEmpty() {
        try {
            repo.save(new Student("1", "emi", 935, "abc@gmail.com", ""));
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
    }
}