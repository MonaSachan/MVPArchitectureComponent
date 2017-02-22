package vmokshagroup.com.mvparchitecturesamplecode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements LoginView,View.OnClickListener{

    private ProgressBar progressBar;
    EditText mUserName,mPassword;
    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName= (EditText) findViewById(R.id.username);
        mPassword= (EditText) findViewById(R.id.password);
        progressBar= (ProgressBar) findViewById(R.id.progressbar);
        presenter=new LoginPresenterImpl(this);
        findViewById(R.id.login_btn).setOnClickListener(this);

    }

    @Override
    public void showProgressdialog() {
        progressBar.setVisibility(View.VISIBLE);


    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void userNameValidate() {

        mUserName.setError("Username should not be blank");

    }

    @Override
    public void PasswordValidation() {
        mPassword.setError("Password should not be blank");

    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(MainActivity.this,SignUpActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
      presenter.validateCredential(mUserName.getText().toString(),mPassword.getText().toString());

    }
}
