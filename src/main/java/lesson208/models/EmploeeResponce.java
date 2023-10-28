package lesson208.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EmploeeResponce {

    private int department;
    private List<Emploee> listEmploee;

}
