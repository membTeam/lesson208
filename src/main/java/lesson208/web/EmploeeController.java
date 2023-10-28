package lesson208.web;

import lesson208.config.ConfigLoadData;
import lesson208.models.Emploee;
import lesson208.models.EmploeeResponce;
import lesson208.servises.EmploeeControllerServEmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/departments")
public class EmploeeController {

    @Autowired
    private EmploeeControllerServEmpl emploeeServEmpl;

    @GetMapping(path = "max-salary/{department}")
    public Emploee maxSalary(@PathVariable("department") Integer department ){
        return emploeeServEmpl.maxSalary(department);
    }

    @GetMapping(path = "min-salary/{department}")
    public Emploee minSalary(@PathVariable("department") Integer department ){
        return emploeeServEmpl.minSalary(department);
    }

    @GetMapping("/all/{department}")
    public List<Emploee> allEmploeeForDepartment(@PathVariable("department") Integer department){
        return emploeeServEmpl.allEmploeeForDepartment(department);
    }

    @GetMapping("/all")
    public List<EmploeeResponce> allEmploee(){
        return emploeeServEmpl.allEmploee();
    }

    @GetMapping("/amount-department")
    public Integer amountDepartment(){
        return emploeeServEmpl.amountDepartment();
    }

    @GetMapping("/list-department")
    public Set<Integer> listDepartment(){
        return emploeeServEmpl.listDepartment();
    }

}
