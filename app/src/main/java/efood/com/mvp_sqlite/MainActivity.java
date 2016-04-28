package efood.com.mvp_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import efood.com.mvp_sqlite.Presenter.LoginPresenterImp;
import efood.com.mvp_sqlite.Views.LoginViews;

public class MainActivity extends AppCompatActivity implements LoginViews {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    LoginPresenterImp resenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        resenter = new LoginPresenterImp(this);
        resenter.SetView(this);
        edtUsername = (EditText) findViewById(R.id.editsText);
        edtPassword = (EditText) findViewById(R.id.editText2);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resenter.Login((edtUsername.getText().toString()), edtPassword.getText().toString());
            }
        });
    }

    @Override
    public void LoginSuccess() {
        startActivity(new Intent(getApplicationContext(), LoadUser.class));
        finish();
    }

    @Override
    public void LoginFaild(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
}
