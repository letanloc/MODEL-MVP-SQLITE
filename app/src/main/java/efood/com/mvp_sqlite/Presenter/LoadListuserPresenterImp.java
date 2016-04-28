package efood.com.mvp_sqlite.Presenter;

import android.content.Context;

import efood.com.mvp_sqlite.Model.User;
import efood.com.mvp_sqlite.Views.LoadListview;

/**
 * Created by loc on 28/04/2016.
 */
public class LoadListuserPresenterImp implements LoadUserPresenter {
    LoadListview loadListview;
    User user;

    public LoadListuserPresenterImp(Context context) {
        this(new User(context));
    }

    public LoadListuserPresenterImp(User user) {
        this.user = user;
    }

    @Override
    public void SetView(LoadListview view) {
        loadListview = view;
    }


    @Override
    public void onshowload() {
        // thưc hinee show va thực hiên hide
        loadListview.showLoadingBar();
    }

    @Override
    public void Onhideload() {
        loadListview.hideLoadingBar();
    }

    @Override
    public void LoadAllUser() {
        loadListview.LoadAll(user.LoadUser());
    }

    @Override
    public void ReLoad() {
        loadListview.ReLoad(user.LoadUser());
    }

    @Override
    public void Insert(User user) {
        long va = this.user.Insert(user);
        if (va != -1) loadListview.InsertSuccess();
        else loadListview.InsertFaild();
    }


}
