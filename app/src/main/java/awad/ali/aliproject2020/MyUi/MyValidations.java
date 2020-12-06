package awad.ali.aliproject2020.MyUi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyValidations {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "((?=.[a-z])(?=.\\d)(?=.[A-Z])(?=.[@#$%!]).{8,40})";
    public MyValidations() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validatePasword(final String password) {

        matcher = pattern.matcher(password);
        return matcher.matches();

    }

}
