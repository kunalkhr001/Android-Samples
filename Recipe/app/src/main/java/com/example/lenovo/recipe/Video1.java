package com.example.lenovo.recipe;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

public class Video1 extends AppCompatActivity {


    VideoView videoView;
    ImageView btnPlayPause;

    String videoURL="http://r7---sn-aigllnzz.googlevideo.com/videoplayback?mt=1507732641&ms=au&expire=1507754420&source=youtube&mv=u&key=yt6&ipbits=0&itag=18&mime=video%2Fmp4&ip=149.13.117.213&lmt=1386675866481827&ei=VC3eWaq3LsbkV8WUsNAF&dur=535.336&sparams=dur%2Cei%2Cid%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Csource%2Cexpire&ratebypass=yes&id=o-ACs394AVOLf8prPkS2a5pPNzAmlQpIjM22NeZG3KlYRW&pl=24&mm=31&signature=A3E4FC928A8B64B251C9BCB5545D8AE23B75A965.5D44DA4EF1BCD8D662A3C50989E4777D735991E0&mn=sn-aigllnzz&title=Rajma+Masala+-+Sanjeev+Kapoor%27s+Kitchen";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video1);

            videoView=(VideoView) findViewById(R.id.videoView);
        btnPlayPause=(ImageButton) findViewById(R.id.btn_play_pause);
        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if(!videoView.isPlaying())
                    {
                        Uri uri=Uri.parse(videoURL);
                        videoView.setVideoURI(uri);
                        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                btnPlayPause.setImageResource(R.drawable.ic_play);
                                videoView.start();

                            }
                        });
                    }

                    else
                    {
                        videoView.pause();
                        btnPlayPause.setImageResource(R.drawable.ic_play);
                    }

                }catch (Exception e){

                }
                videoView.requestFocus();
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
                {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                        mediaPlayer.setLooping(true);
                        videoView.start();
                        btnPlayPause.setImageResource(R.drawable.ic_action_name);
                    }
                });


            }
        });


    }

}
