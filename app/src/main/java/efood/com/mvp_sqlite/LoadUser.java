package efood.com.mvp_sqlite;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import efood.com.mvp_sqlite.Adapter.LoadAlluserAdapter;
import efood.com.mvp_sqlite.Model.User;
import efood.com.mvp_sqlite.Presenter.LoadListuserPresenterImp;
import efood.com.mvp_sqlite.Views.LoadListview;

public class LoadUser extends AppCompatActivity implements LoadListview {
    ListView listview;
    LoadAlluserAdapter alluserAdapter;
    LoadListuserPresenterImp loadListuserPresenterImp;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_user);
        listview = (ListView) findViewById(R.id.listview);
        list = new ArrayList<>();
        alluserAdapter = new LoadAlluserAdapter(list);
        loadListuserPresenterImp = new LoadListuserPresenterImp(this);
        loadListuserPresenterImp.SetView(this);
        loadListuserPresenterImp.LoadAllUser();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    @Override
    public void LoadAll(ArrayList<User> list) {
        this.list = list;
        alluserAdapter = new LoadAlluserAdapter(list);
        listview.setAdapter(alluserAdapter);
    }

    @Override
    public void ReLoad(ArrayList<User> list) {
        alluserAdapter.notifyDataSetChanged();
        listview.setAdapter(alluserAdapter);
    }

    @Override
    public void showLoadingBar() {

    }

    @Override
    public void hideLoadingBar() {

    }

    @Override
    public void InsertSuccess() {
        Toast.makeText(getApplicationContext(), "Thêm Thành công ", Toast.LENGTH_SHORT).show();
        loadListuserPresenterImp.ReLoad();
    }

    @Override
    public void InsertFaild() {
        Toast.makeText(getApplicationContext(), "Thêm không  Thành công ", Toast.LENGTH_SHORT).show();
    }

    private void Dialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_adduser);
        dialog.setTitle("them nguoi moi");
        dialog.show();
        final EditText edtUsername, edtPass, edtRoleId;
        Button button = (Button) dialog.findViewById(R.id.button);
        edtUsername = (EditText) dialog.findViewById(R.id.editText);
        edtPass = (EditText) dialog.findViewById(R.id.editText3);
        edtRoleId = (EditText) dialog.findViewById(R.id.editText4);
        //
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Stusername = edtUsername.getText().toString();
                String StPass = edtPass.getText().toString();
                String StRoleId = edtRoleId.getText().toString();
                int RelerId = Integer.valueOf(StRoleId);
                User user = new User(Stusername, StPass, RelerId);
                loadListuserPresenterImp.Insert(user);
                dialog.dismiss();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.them) Dialog();
        return super.onOptionsItemSelected(item);
    }
}

