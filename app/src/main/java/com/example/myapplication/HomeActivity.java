package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
	Button btn_popup ,close_btn;
	AlertDialog.Builder builder;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast toast = Toast.makeText(getApplicationContext(),
				"in HomeActivity",
				Toast.LENGTH_SHORT);

		toast.show();
		setContentView(R.layout.activity_home);
        btn_popup = findViewById(R.id.popup);
        close_btn = findViewById(R.id.close_btn);
        btn_popup.setOnClickListener(this);
		close_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
			case R.id.popup:
				PopupMenu popupMenu =new PopupMenu(HomeActivity.this,btn_popup);
				popupMenu.inflate(R.menu.menu_popup_list);
				popupMenu.show();
				popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch(item.getItemId()) {
							case R.id.html:
								Toast.makeText(HomeActivity.this,"Html",Toast.LENGTH_SHORT).show();
								break;
							case R.id.css:
								Toast.makeText(HomeActivity.this,"css",Toast.LENGTH_SHORT).show();
								break;
							case R.id.bootstrap:
								Toast.makeText(HomeActivity.this,"bootstrap",Toast.LENGTH_SHORT).show();
								break;
						}
						return true;
					}
				});
				break;
			case R.id.close_btn :
				builder=new AlertDialog.Builder(this);
				builder.setMessage("Do you want to close an application ?");
				builder.setCancelable(false);
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finishAffinity();
					}
				});
				builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});

						AlertDialog alertDialog = builder.create();
				        alertDialog.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_options,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		switch(item.getItemId())
		{
			case R.id.options_html :
				Toast.makeText(HomeActivity.this,"Html",Toast.LENGTH_SHORT).show();
				break;
			case R.id.options_css :
				Toast.makeText(HomeActivity.this,"css",Toast.LENGTH_SHORT).show();
				break;
			case R.id.options_bootstrap:
				Toast.makeText(HomeActivity.this,"bootstrap",Toast.LENGTH_SHORT).show();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
