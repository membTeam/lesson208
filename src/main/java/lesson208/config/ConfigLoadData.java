package lesson208.config;

import lesson208.models.Emploee;
import lesson208.repositories.EmploeesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigLoadData {

    @Autowired
    private EmploeesRepositories repo;

    @Bean
    public EmploeesRepositories getRepository() {
        return repo;
    }

    @Bean
    public void loadDataIntoRepository(){
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

        } catch (Exception ex) {
            System.out.println("err: " + ex.getMessage());
        }
    }
}
