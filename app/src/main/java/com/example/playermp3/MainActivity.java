package com.example.playermp3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnTouchListener {

    ImageView img;

    boolean imaged = true;
    Bitmap bitmap;

    public boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.start);
          img.setOnTouchListener(this);

    }


     @Override
     public boolean onTouch(View v, MotionEvent event) {
         if (imaged == false) {
             bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pause);

             imaged = true;

             Intent intent = new Intent(MainActivity.this, PlayerServise.class);
             startService(intent);

         }
         if (imaged == true) {
             bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.start);

             startService(new Intent(MainActivity.this, PlayerServise.class).putExtra("pause", true));


             imaged = false;
         }
         img.setImageBitmap(bitmap);
         return false;
     }
 /*
    @Override
    public void onClick(View v) {
        if (imaged == false) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pause);

// присваиваем ImageView

            //img.setImageBitmap();

            //img.setImageDrawable(getDrawable(R.drawable.pause));
            // img.setImageResource(R.drawable.pause);
            imaged = true;

            Intent intent = new Intent(MainActivity.this, PlayerServise.class);
            startService(intent);

        }
        if (imaged == true) {
           bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.start);

            startService(new Intent(MainActivity.this, PlayerServise.class).putExtra("pause", true));


            imaged = false;
        }
        img.setImageBitmap(bitmap);
    }
*/
    //  public void startClick(View view)
    // {if(imaged==false)
    //{
    //    Intent intent = new Intent(this,PlayerServise.class);
    //   startService(intent);
    //   img.setImageResource(R.drawable.pause);
    //     imaged=true;
    //}

    // }
    //public void stopClick(View view)
    //{
    //     Intent intent = new Intent(this,PlayerServise.class);
    //    stopService(intent);

    // }

    //public void onPauseClick(View view)
    ///{
    //   if(imaged==true)
    ///  {
    ///     startService(new Intent(this, PlayerServise.class).putExtra("pause", true));
    ///     img.setImageResource(R.drawable.start);
    ///    imaged=false;
    // }

    // }

}