package com.valjulshingmail.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private MediaPlayer mPlayer;
    private int currentSong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int number = intent.getIntExtra("BUTTON NUMBER", 1);

        TextView tv = (TextView) findViewById(R.id.song_name);
        String songName;

        switch (number) {
            case 1:
                currentSong = R.raw.song1;
                songName = "Pain - Shut your mouth";
                break;
            case 2:
                currentSong = R.raw.song2;
                songName = "Morgan James - Shut up and dance";
                break;
            case 3:
                currentSong = R.raw.song3;
                songName = "Rag'n'Bone Man – Human";
                break;
            case 4:
                currentSong = R.raw.song4;
                songName = "Pentatonix - Sing";
                break;
            default:
                throw new UnknownError();
        }
        mPlayer = MediaPlayer.create(SecondActivity.this, currentSong);
        tv.setText(songName);
        mPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPlayer == null) {
            mPlayer = MediaPlayer.create(com.valjulshingmail.myapplication.SecondActivity.this, currentSong);
        }

        mPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
    }
}
