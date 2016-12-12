package Test;

/**
 * Created by TH-221 on 30.11.2016.
 */
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named
public class MessageServerBean {

    public String getMessage() {
        return "Hello World!";
    }
}