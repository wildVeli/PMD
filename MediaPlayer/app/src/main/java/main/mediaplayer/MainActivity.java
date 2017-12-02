package main.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton play;
    ImageButton next;
    ImageButton back;
    MediaPlayer mediaPlayer;
    ArrayList<Integer> songs;
    ArrayList<String> titles;
    Integer actualSong;
    TextView title;
    ImageView imageSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songs = new ArrayList<Integer>();
        titles = new ArrayList<>();
        imageSong=(ImageView)findViewById(R.id.imageSong);
        songs.add(R.raw.level1);
        songs.add(R.raw.level2);
        songs.add(R.raw.level3);
        songs.add(R.raw.titlescreen);
        titles.add("JuhanJunkala Chiptunes:Stage1");
        titles.add("JuhanJunkala Chiptunes:Stage2");
        titles.add("JuhanJunkala Chiptunes:Stage3");
        titles.add("JuhanJunkala Chiptunes:StageTitleScreen");
        title=(TextView)findViewById(R.id.songName);


        actualSong=0;
        mediaPlayer= MediaPlayer.create(this,songs.get(actualSong));
        title.setText(titles.get(actualSong));
        setImageSong();

        play=(ImageButton)findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    play.setImageResource(android.R.drawable.ic_media_play);

                }else{
                    mediaPlayer.start();
                    setImageSong();
                    play.setImageResource(android.R.drawable.ic_media_pause);

                }
            }
        });
        next=(ImageButton)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.release();
                if(actualSong==(songs.size()-1)){
                    actualSong=0;
                }else{
                    actualSong++;

                }
                play.setImageResource(android.R.drawable.ic_media_pause);
                mediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(actualSong));
                title.setText(titles.get(actualSong));
                setImageSong();
                mediaPlayer.start();

            }
        });
        back=(ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.release();
                if(actualSong!=0){
                    actualSong--;
                }else{
                    actualSong=songs.size()-1;
                }
                play.setImageResource(android.R.drawable.ic_media_pause);
                mediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(actualSong));
                title.setText(titles.get(actualSong));
                setImageSong();
                mediaPlayer.start();
            }
        });
    }
    private void setImageSong(){
        switch (actualSong){
            case(0):
                imageSong.setImageResource(R.drawable.hastesky2);
                break;
            case(1):
                imageSong.setImageResource(R.drawable.icesky2);
                break;
            case(2):
                imageSong.setImageResource(R.drawable.rocksky2);
                break;
            case(3):
                imageSong.setImageResource(R.drawable.lightningmagenta3);
                break;

        }
    }
}
