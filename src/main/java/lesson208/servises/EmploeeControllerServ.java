package lesson208.servises;

import lesson208.models.Emploee;
import lesson208.models.EmploeeResponce;

import java.util.List;
import java.util.Set;

public interface EmploeeControllerServ {
    List<Emploee> allEmploeeForDepartment(int department);
    List<EmploeeResponce> allEmploee();

    Emploee minSalary(int department);
    Emploee maxSalary(int department);

    Integer amountDepartment();

    Set<Integer> listDepartment();

}
