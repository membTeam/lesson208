package lesson208.exceptionAPI;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class EmployeeAccessErrorException extends RuntimeException {
    public EmployeeAccessErrorException(String err) {
        super(err);
    }
}
