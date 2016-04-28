package efood.com.mvp_sqlite.Views;

/**
 * Created by loc on 27/04/2016.
 */
// trả thông báo về views
public interface LoginViews {
    // nếu thông báo thành công
    void LoginSuccess();
    void LoginFaild(String text);

}


