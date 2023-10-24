package lesson208.servises;

import lesson208.config.ConfigLoadData;
import lesson208.exceptionAPI.EmployeeNotDataException;
import lesson208.models.Emploee;
import lesson208.models.EmploeeResponce;

import java.util.*;
import java.util.stream.Collectors;

public class EmploeeControllerServEmpl implements EmploeeControllerServ {

    private List<Emploee> listEmploee;
    private Set<Integer> setDepartment;

    public EmploeeControllerServEmpl(ConfigLoadData configLoadData){

        configLoadData.loadDataIntoRepository();
        listEmploee = configLoadData.getRepository().loadAllEmploee();

        setDepartment = listEmploee
                .stream()
                .map( item -> item.getDepartment())
                .collect(Collectors.toSet());
    }

    private void existsDepartment(int department){
        var count = setDepartment.stream()
                .filter(item -> item == department)
                .count();

        if (count == 0) {
            throw new EmployeeNotDataException("Отдел не найден");
        }
    }


    @Override
    public List<Emploee> allEmploeeForDepartment(int department) {

        existsDepartment(department);

         return listEmploee.stream()
                 .filter( item -> item.getDepartment() == department)
                 .collect(Collectors.toList());
    }

    @Override
    public List<EmploeeResponce> allEmploee() {

        var result = setDepartment.stream().map( item -> {
            var lsEmploee = listEmploee
                    .stream()
                    .filter(emploee -> emploee.getDepartment() == item)
                    .collect(Collectors.toList());

            return new EmploeeResponce(item, lsEmploee);
        });

        return result.collect(Collectors.toList());
    }

    @Override
    public Emploee minSalary(int department) {

        existsDepartment(department);

        var stream = listEmploee
                .stream()
                .filter( item -> item.getDepartment() == department  );

        var result = stream.min(CompareEmploee::compare);

        return result.get();
    }

    @Override
    public Emploee maxSalary(int department) {

        existsDepartment(department);

        var stream = listEmploee
                .stream()
                .filter( item -> item.getDepartment() == department  );

        var result = stream.max(CompareEmploee::compare);

        return result.get();
    }

    @Override
    public Integer amountDepartment() {
         return setDepartment.size();
    }

    @Override
    public Set<Integer> listDepartment() {
        return setDepartment;
    }

}
