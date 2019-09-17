package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 for cross 1 for zero
    int turn=0;
    int gameState[]={2,2,2,2,2,2,2,2,2};
    int winningPositions[][]= {{0,1,2},{0,4,8},{0,3,6},{3,4,5},{6,7,8},{1,4,7},{2,5,8},{2,4,6}};
    public void dropIn(View view)
    {

        ImageView counter= (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter] == 2) {
        counter.setTranslationY(-1000f);
            gameState[tappedCounter]=turn;
            if (turn == 0) {
                counter.setImageResource(R.drawable.zero);
                turn = 1;
            } else {
                counter.setImageResource(R.drawable.zero);
                turn = 0;
            }

            counter.animate().translationYBy(1000f).rotation(3600f).setDuration(30);
            for(int[] winningPosition : winningPositions ){
                if(gameState[winningPosition[0]]==gameState[winningPosition[1]]  && gameState[winningPosition[1]]==gameState[winningPosition[2]] && gameState[winningPosition[0]] !=2){
                    String winner ="  ";
                    //System.out.println("Arpit looses kajal jeet gayi"+gameState[winningPosition[0]]);
                    if(gameState[winningPosition[0]] == 0){
                        winner="cross1";
                    }
                    else if(gameState[winningPosition[0]] == 1){
                        winner = "zero1";
                    }
                    else winner="No one";

                    TextView winnerText  = (TextView) findViewById(R.id.winnerMsg);
                    winnerText.setText(winner + " has won!");

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);


                }

            }
        }
    }

    public void PlayAgain(View view){
        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
