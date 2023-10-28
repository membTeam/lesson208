package lesson208.config;

import lesson208.models.Emploee;
import lesson208.repositories.EmploeesRepositories;
import lesson208.servises.EmploeeControllerServEmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ConfigLoadData implements CommandLineRunner {

    @Autowired
    private EmploeesRepositories repo;

    @Autowired
    private EmploeeControllerServEmpl emploeeControllerServEmpl ;

    @Override
    public void run(String... args)  {
        try {
            repo.deleteAll();

            repo.save(new Emploee(null, 0, "Даниил Андрианов", 1, 50000));
            repo.save(new Emploee(null, 0, "Кирилл Артемов", 2, 40000));
            repo.save(new Emploee(null, 0, "Денис Артамонов", 1, 65000));
            repo.save(new Emploee(null, 0, "Илья Афанасьев", 2, 70000));
            repo.save(new Emploee(null, 0, "Егор Борисов", 3, 80000));
            repo.save(new Emploee(null, 0, "София Васильева", 3, 50000));
            repo.save(new Emploee(null, 0, "София Бородина", 1, 45000));
            repo.save(new Emploee(null, 0, "Алиса Беляева", 3, 900000));

            emploeeControllerServEmpl.fill(repo);

        } catch (Exception ex) {
            System.out.println("err: " + ex.getMessage());
        }
    }

}
