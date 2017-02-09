package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import entity.SignUp;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.SignUpPage;
import utils.ExcelReader;

import java.io.IOException;

import static steps.BaseSteps.pageStore;

/**
 * Created by tester1 on 2/9/2017.
 */
public class SignUpSteps extends BaseSteps implements En {
    public SignUpSteps() {
        Given("^user sign up$", () -> {
            String fileName= "signUp";
            String dataId= "signUpDetails";
            SignUp signUp= new ExcelReader(fileName).getSignUpDetails(dataId);

        });
    }
}
