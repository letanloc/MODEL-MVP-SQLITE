package efood.com.mvp_sqlite.Views;

import java.util.ArrayList;

import efood.com.mvp_sqlite.Model.User;

/**
 * Created by loc on 28/04/2016.
 */
public interface LoadListview {
    void LoadAll(ArrayList<User> list);

    void ReLoad(ArrayList<User> list);

    void showLoadingBar();

    void hideLoadingBar();

    void InsertSuccess();

    void InsertFaild();
}

