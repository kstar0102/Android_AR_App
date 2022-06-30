package com.google.ar.sceneform.samples.augmentedimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestActivity extends AppCompatActivity {
    ImageView image;
    VideoView Video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String imagePath = getIntent().getStringExtra("iamgeurl");
//
//        String videourl = getIntent().getStringExtra("videoUrl");

        image = (ImageView) findViewById(R.id.testImage);
        Video = (VideoView) findViewById(R.id.myvideoview);
        try {
            File f = new File(imagePath, "Image.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            image.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        Video.setVideoURI(Uri.parse(imagePath + "/test.mp4"));
        Video.setMediaController(new MediaController(this));
        Video.requestFocus();

        Video.start();

    }
}
