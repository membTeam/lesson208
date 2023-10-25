package lesson208.servises;

import lesson208.config.ConfigLoadData;
import lesson208.exceptionAPI.EmployeeAccessErrorException;
import lesson208.exceptionAPI.EmployeeNotDataException;
import lesson208.models.Emploee;
import lesson208.models.EmploeeResponce;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


public class EmploeeControllerServEmpl implements EmploeeControllerServ {

    private List<Emploee> listEmploee;
    private Set<Integer> setDepartment;

    private final String MESSAGE_ERR = "Ошибка доступа. Откройте позже";
    public EmploeeControllerServEmpl(ConfigLoadData configLoadData){
        configLoadData.loadDataIntoRepository();
        listEmploee = configLoadData.getRepository().loadAllEmploee();

        setDepartment = listEmploee
                .stream()
                .map( item -> item.getDepartment())
                .collect(Collectors.toSet());
    }

    private void existsDepartment(int department) throws EmployeeNotDataException {
        if (!setDepartment.contains(department)) {
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
        return setDepartment.stream().map( item -> {
            var lsEmploee = listEmploee
                    .stream()
                    .filter(emploee -> emploee.getDepartment() == item)
                    .collect(Collectors.toList());

            return new EmploeeResponce(item, lsEmploee);
        }).collect(Collectors.toList());
    }

    @Override
    public Emploee minSalary(int department) {

        existsDepartment(department);

        return listEmploee.stream()
                .filter( item -> item.getDepartment() == department)
                .min(CompareEmploee::compare)
                .orElseThrow(()-> {throw new EmployeeAccessErrorException(MESSAGE_ERR);});
    }

    @Override
    public Emploee maxSalary(int department) {

        existsDepartment(department);

        return listEmploee.stream()
                .filter( item -> item.getDepartment() == department  )
                .max(CompareEmploee::compare)
                .orElseThrow(()-> {throw new EmployeeAccessErrorException(MESSAGE_ERR);});
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
