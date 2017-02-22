package vmokshagroup.com.mvparchitecturesamplecode;


import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by anshikas on 16-01-2017.
 */

public class LoginInteractorImp implements LoginInteractor {
    @Override
    public void login(final String usrname, final String passwordname, final OnLoginFinishedListener listener) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;

                if(TextUtils.isEmpty(usrname)){
                    listener.onUsernameError();
                    error=true;

                }
                if(TextUtils.isEmpty(passwordname)){
                    listener.OnPasswordFailed();
                    error=true;
                }
                if(!error){
                    listener.onSuccess();
                }

            }
        },1000);

    }
}
