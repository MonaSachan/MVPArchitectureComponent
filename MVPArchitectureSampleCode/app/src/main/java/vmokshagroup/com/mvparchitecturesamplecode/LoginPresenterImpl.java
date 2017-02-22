package vmokshagroup.com.mvparchitecturesamplecode;

import static vmokshagroup.com.mvparchitecturesamplecode.R.id.username;

/**
 * Created by anshikas on 16-01-2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    LoginView loginView;
    LoginInteractor loginInteractor;

    LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
       this.loginInteractor=new LoginInteractorImp();

    }

    @Override
    public void validateCredential(String username, String password) {
        if (loginView == null) {
            loginView.userNameValidate();
            loginView.PasswordValidation();
        }

        loginInteractor.login(username,password,this);

    }


    @Override
    public void onUsernameError() {

        if (loginView != null) {
            loginView.userNameValidate();
            loginView.hideProgressBar();

        }
    }

    @Override
    public void OnPasswordFailed() {

        if (loginView != null) {
            loginView.PasswordValidation();
            loginView.hideProgressBar();

        }

    }

    @Override
    public void onSuccess() {
        loginView.navigateToHome();

    }
}
