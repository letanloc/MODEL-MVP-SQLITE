package efood.com.mvp_sqlite.Presenter;

import android.content.Context;

import efood.com.mvp_sqlite.Model.User;
import efood.com.mvp_sqlite.Views.LoginViews;

/**
 * Created by loc on 27/04/2016.
 */
public class LoginPresenterImp implements LoginResenter {
    User user;
    LoginViews loginViews;

    public LoginPresenterImp(Context context) {
        this(new User(context));
    }

    public LoginPresenterImp(User user) {
        this.user = user;
    }

    @Override
    public void Login(String UserName, String Password) {
        if (user.login(UserName, Password)) loginViews.LoginSuccess();
        else loginViews.LoginFaild("đăng nhập không thành công");
    }

    @Override
    public void SetView(LoginViews view) {
        this.loginViews = view;
    }
}
