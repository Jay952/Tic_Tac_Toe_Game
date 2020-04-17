package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;
    //0-x
    //1-0
    int activeplayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    //0-x
    //1-0
    //2-Null

    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playaTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if(!gameactive){
            gameactive = true;

            for(int i=0; i<gamestate.length; i++){
                gamestate[i] = 2;
            }
            ((ImageView)findViewById(R.id.im1)).setImageResource(0);
            ((ImageView)findViewById(R.id.im2)).setImageResource(0);
            ((ImageView)findViewById(R.id.im3)).setImageResource(0);
            ((ImageView)findViewById(R.id.im4)).setImageResource(0);
            ((ImageView)findViewById(R.id.im5)).setImageResource(0);
            ((ImageView)findViewById(R.id.im6)).setImageResource(0);
            ((ImageView)findViewById(R.id.im7)).setImageResource(0);
            ((ImageView)findViewById(R.id.im8)).setImageResource(0);
            ((ImageView)findViewById(R.id.im9)).setImageResource(0);
        }

        if(gamestate[tappedImage] == 2){

            gamestate[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer == 0){
                img.setImageResource(R.mipmap.ic_launcher_cross_foreground);
                activeplayer =1;
                TextView status = findViewById(R.id.status);
                status.setText("O tern:Tap to Play Gaurank");
            }
            else{
                img.setImageResource(R.mipmap.ic_launcher_circle_foreground);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X tern:Tap to Play Rudrakshi");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        //Check if player has won
        for(int[] winPosition: winPositions){


            if(gamestate[winPosition[0]] == gamestate[winPosition[1]] && gamestate[winPosition[1]] == gamestate[winPosition[2]] && gamestate[winPosition[0]]!=2){
                //Somebody Has Won findout who?
                String winnerstr;
                if(gamestate[winPosition[0]] == 0){
                    winnerstr = "Rudrakshi Won,Gourank will play first Now";
                }else{
                    winnerstr = "Gourank Won,Rudu will play first Now";
                }
                //update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);
                gameactive = false;
                if(!gameactive){

                    for(int i=0; i<gamestate.length; i++){
                        gamestate[i] = 2;
                    }
                    ((ImageView)findViewById(R.id.im1)).setImageResource(0);
                    ((ImageView)findViewById(R.id.im2)).setImageResource(0);
                    ((ImageView)findViewById(R.id.im3)).setImageResource(0);
                    ((ImageView)findViewById(R.id.im4)).setImageResource(0);
                    ((ImageView)findViewById(R.id.im5)).setImageResource(0);
                    ((ImageView)findViewById(R.id.im6)).setImageResource(0);
                    ((ImageView)findViewById(R.id.im7)).setImageResource(0);
                    ((ImageView)findViewById(R.id.im8)).setImageResource(0);
                    ((ImageView)findViewById(R.id.im9)).setImageResource(0);



                }
            }


        }


    }

    public void gameReset(View view){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
