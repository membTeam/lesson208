package lesson208.servises;

import lesson208.models.Emploee;
import lesson208.models.EmploeeService;

import java.util.List;
import java.util.Set;

public interface EmploeeServ {
    List<Emploee> allEmploeeForDepartment(int department);
    List<EmploeeService> allEmploee();

    Integer minSalary(int department);
    Integer maxSalary(int department);

    Integer amountDepartment();

    Set<Integer> listDepartment();

}
