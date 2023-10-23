package lesson208.servises;

import lesson208.models.Emploee;

import java.util.Comparator;

public class CompareEmploee implements Comparator<Emploee> {
    @Override
    public int compare(Emploee emploee, Emploee t1) {
        Integer salary = emploee.getSalary();
        Integer salary1 = t1.getSalary();

        return salary.compareTo(salary1);
    }
}
