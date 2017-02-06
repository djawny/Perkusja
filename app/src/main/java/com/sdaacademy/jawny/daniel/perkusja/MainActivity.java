package com.sdaacademy.jawny.daniel.perkusja;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer bassSample;
    private MediaPlayer drumSample;
    private MediaPlayer gongSample;
    private MediaPlayer paleczkiSample;
    private MediaPlayer cymbalSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bassSample = MediaPlayer.create(this, R.raw.bass);
        drumSample = MediaPlayer.create(this, R.raw.drum1);
        gongSample = MediaPlayer.create(this, R.raw.gong);
        paleczkiSample = MediaPlayer.create(this, R.raw.paleczki);
        cymbalSample = MediaPlayer.create(this, R.raw.cymbal);
    }

    public void hitDrum(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                playSample(bassSample);
                break;
            case R.id.imageView2:
                playSample(drumSample);
                break;
            case R.id.imageView3:
                playSample(gongSample);
                break;
            case R.id.imageView4:
                playSample(paleczkiSample);
                break;
            case R.id.imageView5:
                playSample(cymbalSample);
                break;
            default:
                Log.v(getClass().getSimpleName(), "Button not supported.");
                break;
        }
    }

    private void playSample(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bassSample.release();
        drumSample.release();
        gongSample.release();
        paleczkiSample.release();
        cymbalSample.release();
    }
}
