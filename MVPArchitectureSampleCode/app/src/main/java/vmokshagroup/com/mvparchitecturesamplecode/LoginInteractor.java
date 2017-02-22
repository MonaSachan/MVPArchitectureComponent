package vmokshagroup.com.mvparchitecturesamplecode;

/**
 * Created by anshikas on 16-01-2017.
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener {
        void onUsernameError();

        void OnPasswordFailed();

        void onSuccess();

    }


    void login(String usrname,String passwordname,OnLoginFinishedListener listener);

}
