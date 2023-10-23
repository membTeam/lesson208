package lesson208;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lesson208.models.Emploee;


@SpringBootTest
public class EmploeeStaticMethodTests {

    @Test
    public void getValueForUserIdent_test(){
        var rand = Emploee.getValueForUserIdent();

        var rand2 = Emploee.getValueForUserIdent();
        var rand3 = Emploee.getValueForUserIdent();

        assertThat(rand).isGreaterThan(9999);
        assertThat(rand2).isGreaterThan(9999);
        assertThat(rand3).isGreaterThan(9999);

        List<Integer> lsResult = List.of(rand, rand2, rand3);
        System.out.println(lsResult);

    }

}
