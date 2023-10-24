package lesson208.exceptionAPI;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotDataException extends RuntimeException {
    public EmployeeNotDataException(String err){
        super(err);
    }
}
