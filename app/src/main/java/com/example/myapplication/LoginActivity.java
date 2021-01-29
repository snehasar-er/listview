package com.example.myapplication;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
	EditText userName, password;
	Button login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		userName = findViewById(R.id.username);
		password=findViewById(R.id.password);
		login = findViewById(R.id.login);

		login.setOnClickListener(this);
	}

	void emptyFieldsValidation()
	{
	String name =userName.getText().toString();
	String pass = password.getText().toString();
	if(name.isEmpty() && name.length() ==0)
	{
		userName.setError("Please enter username");
	}
	if(pass.isEmpty() && pass.length()==0)
	{
		password.setError("Please enter password");
	}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.login :
				emptyFieldsValidation();
				if(userName.getText().toString().equals(Constants.admin) && password.getText().toString().equals(String.valueOf(Constants.password)))
				{
					Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
					startActivity(intent);
				}
				else {
					Toast.makeText(LoginActivity.this ,"Please enter vallidate credential ",Toast.LENGTH_LONG).show();
				}
				break;
		}
	}
}
