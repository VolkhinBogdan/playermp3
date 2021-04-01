package com.example.playermp3;

import android.app.Service;
import android.content.Intent;

import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class PlayerServise extends Service {
    public MediaPlayer mp;

    @Override
    public void onCreate() {
        super.onCreate();
        //Toast.makeText(this,"Servise created",Toast.LENGTH_SHORT).show();
        mp=MediaPlayer.create(this,R.raw.song);
        mp.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();

        if (intent.getBooleanExtra("pause", true))
        {
           mp.pause();
        }
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        Toast.makeText(this,"Servise destroyed",Toast.LENGTH_SHORT).show();

    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }


}

