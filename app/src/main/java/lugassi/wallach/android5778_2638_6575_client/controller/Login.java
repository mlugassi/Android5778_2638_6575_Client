package lugassi.wallach.android5778_2638_6575_client.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lugassi.wallach.android5778_2638_6575_client.R;
import lugassi.wallach.android5778_2638_6575_client.model.backend.DBManagerFactory;
import lugassi.wallach.android5778_2638_6575_client.model.backend.DB_manager;

public class Login extends Activity implements View.OnClickListener {

    private DB_manager db_manager;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView linkSignupTextView;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        db_manager = DBManagerFactory.getManager();
        findViews();
    }

    private void findViews() {
        userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        linkSignupTextView = (TextView) findViewById(R.id.linkSignupTextView);
        errorTextView = (TextView) findViewById(R.id.errorTextView);

        linkSignupTextView.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    private boolean checkValues() {
        if (TextUtils.isEmpty(userNameEditText.getText().toString())) {
            userNameEditText.setError(getString(R.string.exceptionEmptyFileds));
            return false;
        }
        if (TextUtils.isEmpty(passwordEditText.getText().toString())) {
            passwordEditText.setError(getString(R.string.exceptionEmptyFileds));
            return false;
        }
        if (userNameEditText.getText().toString().length() > 25) {
            userNameEditText.setError(getString(R.string.exceptionUserName));
            return false;
        }
        return true;
    }


    void login() {
        if(!checkValues())
            return;
        Intent intent = new Intent(Login.this, MainNavigation.class);
        String result = db_manager.checkUser(userNameEditText.getText().toString(), passwordEditText.getText().toString());
        if(result.contains("Success")) {
            finish();
            Login.this.startActivity(intent);
        }
        else
        {
            errorTextView.setText(result);
            errorTextView.setVisibility(View.VISIBLE);
        }
    }

    void signup() {
        Intent intent = new Intent(Login.this, AddCustomer.class);
        Login.this.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == loginButton)
            login();
        else
            signup();

    }
}
