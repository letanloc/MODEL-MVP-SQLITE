package efood.com.mvp_sqlite.Presenter;

import efood.com.mvp_sqlite.Views.LoginViews;

/**
 * Created by loc on 27/04/2016.
 */
public interface LoginResenter extends Presenter<LoginViews> {
    // tạo một phương thức login
    // chuwacs các phương thức sử lí chính như insert update delete
    void Login(String UserName, String Password);
}
