package lesson208;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lesson208.config.ConfigLoadData;
import lesson208.repositories.EmploeesRepositories;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LoadDataIntoRepositoryTests {

    @Autowired
    private ConfigLoadData configLoadData;

    @Test
    public void ConfigLoadData_test(){
        configLoadData.loadDataIntoRepository();
        var repo = configLoadData.getRepository();

        assertThat(repo).as(EmploeesRepositories.class.getName());
        assertThat(repo.count()).isGreaterThan(0);
    }

}
