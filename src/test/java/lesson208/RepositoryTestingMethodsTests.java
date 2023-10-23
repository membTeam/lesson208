package lesson208;

import lesson208.config.ConfigLoadData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lesson208.models.Emploee;

@SpringBootTest
public class RepositoryTestingMethodsTests {

    @Autowired
    private ConfigLoadData configLoadData;

    @Test
    public void getAllRowsEmploee(){
        configLoadData.loadDataIntoRepository();

        var repo = configLoadData.getRepository();

        var result = repo.loadAllEmploee();

        assertThat(result).as(ArrayList.class.getName());

    }
}
