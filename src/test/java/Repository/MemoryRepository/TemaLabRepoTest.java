package Repository.MemoryRepository;

import Domain.TemaLab;
import Exceptions.ValidatorException;
import Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TemaLabRepoTest {
    TemaLabRepo repo;
    TemaLab assignment;
    @Before
    public void setUp() {
        repo = new TemaLabRepo(new TemaLabValidator());
        assignment = new TemaLab(new Integer(10), "descriere", 13, 13);
    }

    public void addWithCrash(){
        try {
            repo.save(assignment);
            assert false;
        } catch (ValidatorException e) {
            assert true;
        }
        assertEquals(repo.size(), 0);
    }

    public void addWithoutCrash(){
        try {
            repo.save(assignment);
        } catch (ValidatorException e) {
            assert false;
        }
        assertEquals(repo.size(), 1);
    }

    @Test
    public void addAssignmentIdPositive() {
        assignment.setId(1);
        addWithoutCrash();
    }

    @Test
    public void addAssignmentIdZero() {
        assignment.setId(0);
        addWithoutCrash();
    }

    //Test 1
    @Test
    public void addAssigmentNull(){
        try {
            repo.save(null);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        } catch (ValidatorException e) {
            assert false;
        }
        assertEquals(repo.size(), 0);
    }

    //Test 2
    @Test
    public void addAssignmentIdNull() {
        assignment.setId(null);
        addWithCrash();
    }

    //Test 3
    @Test
    public void addAssignment() {
        addWithoutCrash();
    }



}