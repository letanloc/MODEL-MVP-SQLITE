package efood.com.mvp_sqlite.Presenter;

import efood.com.mvp_sqlite.Model.User;
import efood.com.mvp_sqlite.Views.LoadListview;

/**
 * Created by loc on 28/04/2016.
 */
public interface LoadUserPresenter extends Presenter<LoadListview> {
    void onshowload();

    void Onhideload();

    void LoadAllUser();

    void ReLoad();

    void Insert(User user);


}
