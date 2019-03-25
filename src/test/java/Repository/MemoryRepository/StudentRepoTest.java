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
    Student genericStudent;
    @Before
    public void setUp() {
        repo = new StudentRepo(new StudentValidator());
        genericStudent = new Student(12, "abc", 12, "a@b.com", "indrumator");
    }

    public void addWithCrash(){
        try {
            repo.save(genericStudent);
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
        assertEquals(repo.size(), 0);
    }

    public void addWithoutCrash(){
        try {
            repo.save(genericStudent);
        } catch (ValidatorException e) {
            assert false;
        }
        assertEquals(repo.size(), 1);
    }

    @Test
    public void addStudent() throws ValidatorException {
        repo.save(genericStudent);
        assertEquals(repo.size(), 1);    }

    //Test 1
    @Test
    public void addStudentNameNull() {
        genericStudent.setNume(null);
        addWithCrash();

    }

    //Test 2
    @Test
    public void addStudentName() {
        genericStudent.setNume("a");
        addWithoutCrash();
    }
    //Test 3
    @Test
    public void addStudentNameEmpty() {
        genericStudent.setNume("");
        addWithCrash();
    }
    //Test 4
    @Test
    public void addStudentNameOfSize2() {
        genericStudent.setNume("ab");
        addWithoutCrash();
    }
    //Test the id
    //Test 5
    @Test
    public void addStudentIdZero() {
        genericStudent.setId(0);
        addWithCrash();
    }
    //Test 6
    @Test
    public void addStudentIdNegative() {
        genericStudent.setNume("ab");
        addWithoutCrash();
    }
    //Test 7
    @Test
    public void addStudentId1() {
        genericStudent.setId(1);
        addWithoutCrash();
    }
    //Test 8
    @Test
    public void addStudentId2() {
        genericStudent.setId(2);
        addWithoutCrash();
    }
    //Test 9
    @Test
    public void addStudentEmailNull() {
        genericStudent.setEmail(null);
        addWithCrash();
    }
    //Test 10
    @Test
    public void addStudentEmailEmpty() {
        genericStudent.setEmail("");
        addWithCrash();
    }
    //Test 11
    @Test
    public void addStudentEmail() {
        genericStudent.setEmail("@");
        addWithoutCrash();
    }
    //Test 12
    @Test
    public void addStudentEmailLen2() {
        genericStudent.setEmail("a@");
        addWithoutCrash();
    }

    @Test
    public void addStudentEmailWrong() {
        addStudentEmailEmpty();
    }
    //Test 13
    @Test
    public void addStudentGroupWrong() {
        genericStudent.setGrupa(-1);
        addWithCrash();
    }
    //Test 14
    @Test
    public void addStudentGroupWrong2() {
        genericStudent.setGrupa(-2);
        addWithCrash();
    }
    //Test 15
    @Test
    public void addStudentGroup() {
        genericStudent.setGrupa(0);
        addWithoutCrash();
    }
    //Test 16
    @Test
    public void addStudentGroup1() {
        genericStudent.setGrupa(1);
        addWithoutCrash();
    }
    //Test 17
    @Test
    public void addStudentIndrumatorNull() {
        genericStudent.setIndrumator(null);
        addWithCrash();
    }
    //Test 18
    @Test
    public void addStudentIndrumatorEmpty() {
        genericStudent.setIndrumator("");
        addWithCrash();
    }
    //Test 19
    @Test
    public void addStudentIndrumator() {
        genericStudent.setIndrumator("a");
        addWithoutCrash();
    }
    //Test 20
    @Test
    public void addStudentIndrumator2() {
        genericStudent.setIndrumator("ab");
        addWithoutCrash();
    }




}