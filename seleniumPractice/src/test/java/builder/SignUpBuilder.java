package builder;

import entity.SignUp;

/**
 * Created by tester1 on 2/9/2017.
 */
public class SignUpBuilder  {
    SignUp signUp=new SignUp();

    public SignUpBuilder firstName(String firstName) {
        signUp.setFirstName(firstName);
        return this;
    }

    public SignUpBuilder lastName(String lastName) {
        signUp.setLastName(lastName);
        return this;
    }

    public SignUpBuilder emailID(String emailID) {
        signUp.setEmailId(emailID);
        return this;
    }

    public SignUpBuilder password(String password) {
        signUp.setPassword(password);
        return this;
    }

    public SignUp build() {
        return signUp;
    }
}
