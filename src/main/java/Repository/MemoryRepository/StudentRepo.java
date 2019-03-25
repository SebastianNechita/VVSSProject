package Repository.MemoryRepository;
import Validator.IValidator;
import Domain.Student;

public class StudentRepo extends AbstractCrudRepo<Integer, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}