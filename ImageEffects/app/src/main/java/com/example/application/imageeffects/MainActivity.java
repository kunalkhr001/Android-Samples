package com.example.application.imageeffects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView myImageView;
    Drawable myApple;
    Bitmap bitmapImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImageView=(ImageView) findViewById(R.id.myImageView);
        myApple= ResourcesCompat.getDrawable(getResources(),R.drawable.apple,null);
        bitmapImage=((BitmapDrawable)myApple).getBitmap();
        Bitmap newphoto=invertImage(bitmapImage);
        myImageView.setImageBitmap(newphoto);

    }

    public static Bitmap invertImage(Bitmap original)
    {
        Bitmap finalImage=Bitmap.createBitmap(original.getWidth(),original.getHeight(),original.getConfig());
        int A,R,G,B,pixelcolor;
        int height=original.getHeight();
        int width=original.getWidth();

        for(int y=0;y<height;y++)
        {
            for(int x=0;x<width;x++)
            {
                pixelcolor=original.getPixel(x,y);
                A=Color.alpha(pixelcolor);
                R=255- Color.red(pixelcolor);
                G=255- Color.green(pixelcolor);
                B=255- Color.blue(pixelcolor);

                finalImage.setPixel(x,y,Color.argb(A,R,G,B));
            }
        }
        return finalImage;
    }
}
