package com.example.aartiapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class GalleryShow extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer m;

    ImageView artistImage;
    TextView LeftTime;
    TextView RightTime;
    SeekBar mseekBar;
    Button prevButton;
    Button playbutton;
    Button nextButton;
    int imageResource;
    String Titletext;
    int SongResource;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        getIncomingIntent();




        mseekBar.setMax(m.getDuration());

        mseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                {
                    m.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    void SetUpUi()
    {
        m=new MediaPlayer();
        m=MediaPlayer.create(getApplicationContext(),SongResource);

        artistImage=(ImageView)findViewById(R.id.imageView);
        LeftTime=(TextView) findViewById(R.id.lefttv);
        RightTime=(TextView)findViewById(R.id.righttv);
        mseekBar=(SeekBar)findViewById(R.id.mseekBar);
        prevButton=(Button) findViewById(R.id.playPrev);
        playbutton=(Button) findViewById(R.id.playbutton);
        nextButton=(Button) findViewById(R.id.playNext);

        prevButton.setOnClickListener(this);
        playbutton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }


    @Override
    protected void onDestroy() {
        if(m !=null && m.isPlaying() )
        {
            m.stop();
            m.release();
            m=null;
        }

        super.onDestroy();
    }

    @Override
    public void onClick(View v) {


        switch (v.getId())
        { case R.id.playPrev:

            break;

            case R.id.playbutton:
                if(m.isPlaying())
                    pauseMusic();
                else
                    playMusic();

                break;

            case R.id.playNext:


                break;
        }
    }


    void pauseMusic()
    {
        if(m!=null)
        {
            m.pause();
            playbutton.setBackgroundResource(android.R.drawable.ic_media_play);
        } }

    void playMusic() {
        if (m != null) {
            m.start();
            playbutton.setBackgroundResource(android.R.drawable.ic_media_pause);
        }
    }


    private void getIncomingIntent()
    {
        if(getIntent().hasExtra("title"))
            Log.d("Intent","hasdata");

        imageResource=getIntent().getIntExtra("image",R.drawable.black);
       Titletext=getIntent().getStringExtra("title");
       SongResource=getIntent().getIntExtra("song",0);

        SetUpUi();
        setIntentdata(imageResource,Titletext);
    }

    private void setIntentdata(int imageResource,String Titletext)
    { TextView Title=findViewById(R.id.titledata);
        ImageView imageViewGallery=findViewById(R.id.imageView);
        View Relativeback=findViewById(R.id.backgroundviewblur);
    Title.setText(Titletext);


       Glide.with(this)
               .load(imageResource)
               .into(imageViewGallery);

       


Log.d("new clicked",""+imageResource);
    }
}
