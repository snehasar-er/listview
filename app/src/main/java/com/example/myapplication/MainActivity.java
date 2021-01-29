package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.song);
		mediaPlayer.start();


//        Pause activity start
		Thread thread = new Thread(){
			@Override
			public void run() {

				try{
					sleep(5000);
				} catch (Exception e1){
					e1.printStackTrace();
				} finally {
					Intent intent = new Intent(MainActivity.this, LoginActivity.class);
					startActivity(intent);
				}
			}
		};
		thread.start();
		//  Pause activity end
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
		mediaPlayer.stop();
	}
	}
