package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
ListView listView;
	AlertDialog.Builder builder;
Button btn_show,btn_hide;
String values[]={"Html","css","bootstrap","android","Html","css","bootstrap","android"};
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		listView= findViewById(R.id.list1);
		btn_show = findViewById(R.id.btn_show);
		btn_hide = findViewById(R.id.btn_hide);
		btn_show.setOnClickListener(this);
		btn_hide.setOnClickListener(this);

		ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,values);
		listView.setAdapter(arrayAdapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				builder=new AlertDialog.Builder(ListActivity.this,R.style.Theme_AlertDialogStyle);
				builder.setMessage("sneha");
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				})	;
				builder.setTitle("sneha");
				AlertDialog alertDialog = builder.create();

				alertDialog.show();
			}
		});


		registerForContextMenu(listView);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_context,menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public void onClick(View v) {
		LinearLayout linearLayout;
		switch(v.getId())
		{
			case R.id.btn_show:
				linearLayout = findViewById(R.id.linear_one);
				linearLayout.setVisibility(View.VISIBLE);
				break ;

			case R.id.btn_hide:
				linearLayout = findViewById(R.id.linear_one);
				linearLayout.setVisibility(View.GONE);
				break;
		}
	}
}
