package lesson208.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Emploee {
    @Id
    private String id;
    private int userIdent;
    private String fullName;
    private int department;
    private int salary;

    public static int getValueForUserIdent(){
        int min = 10000, max = 20000;

        return  (int) (Math.random() * (max - min) + min);
    }
    public static String getRandomUUID(){
        return UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emploee emploee = (Emploee) o;
        return userIdent == emploee.userIdent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdent);
    }
}
