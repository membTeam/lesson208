package lesson208.servises;

import lesson208.config.ConfigLoadData;
import lesson208.models.Emploee;
import lesson208.models.EmploeeService;

import java.util.*;
import java.util.stream.Collectors;

public class EmploeeServEmpl implements EmploeeServ {

    private Map<Integer, Emploee> mapEmploee;
    private Set<Integer> setDepartment;

    public EmploeeServEmpl(ConfigLoadData configLoadData){
        configLoadData.loadDataIntoRepository();
        var repo = configLoadData.getRepository();

        mapEmploee = new HashMap<>();
        for (Emploee item : repo.loadAllEmploee()) {
            mapEmploee.put(item.getUserIdent(), item);
        }

        setDepartment = mapEmploee.values().stream().map(item-> item.getDepartment()).collect(Collectors.toSet());
    }

    private int existsDepartment(int department){
        return (int) setDepartment.stream()
                .filter(item -> item == department)
                .count();
    }

    @Override
    public List<Emploee> allEmploeeForDepartment(int department) {

        if (existsDepartment(department) == 0){
            return new ArrayList<>();
        }

         return mapEmploee.values().stream()
                 .filter(item -> item.getDepartment() == department )
                 .collect(Collectors.toList());
    }

    @Override
    public List<EmploeeService> allEmploee() {

        var streamDepartment = mapEmploee.values()
                .stream().map((item) -> item.getDepartment())
                .collect(Collectors.toSet());

        var result = streamDepartment.stream().map(item -> {
            var lsEmploee = mapEmploee.values()
                    .stream().filter(emploee -> emploee.getDepartment() == item)
                    .collect(Collectors.toList());

            var emploeeServuce = EmploeeService
                    .builder().listEmploee(lsEmploee)
                    .department(item)
                    .build();

            return emploeeServuce;
        });

        return result.collect(Collectors.toList());
    }

    @Override
    public Integer minSalary(int department) {

        if (existsDepartment(department) == 0){
            return 0;
        }

        var stream = mapEmploee.values()
                .stream()
                .filter(item -> item.getDepartment() == department  );

        var result = stream.min(new CompareEmploee());

        return result.get().getSalary();
    }

    @Override
    public Integer maxSalary(int department) {

        if (existsDepartment(department) == 0){
            return 0;
        }

        var stream = mapEmploee.values()
                .stream()
                .filter(item -> item.getDepartment() == department  );

        var result = stream.max(new CompareEmploee());

        return result.get().getSalary();
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
