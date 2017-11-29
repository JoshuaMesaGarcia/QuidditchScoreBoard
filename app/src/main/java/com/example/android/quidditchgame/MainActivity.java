package com.example.android.quidditchgame;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreHouseA = 0;
    int scoreHouseB = 0;
    LinearLayout linearHB;
    LinearLayout linearHA;
    Button bttnSHB;
    Button bttnSHA;
    private Spinner selectHA;
    private Spinner selectHB;
    ImageView bannerHA;
    ImageView bannerHB;
    Button bttnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearHB = (LinearLayout) findViewById(R.id.linearB);
        linearHA = (LinearLayout) findViewById(R.id.linearA);
        bttnSHB = (Button) findViewById(R.id.buttonSB);
        bttnSHA = (Button) findViewById(R.id.buttonSA);
        selectHA = (Spinner) findViewById(R.id.select_houseA);
        selectHB = (Spinner) findViewById(R.id.select_houseB);
        bannerHA = (ImageView) findViewById(R.id.bannerHouseA);
        bannerHB = (ImageView) findViewById(R.id.bannerHouseB);
        bttnStart = (Button) findViewById(R.id.startButton);

        selectHA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Slytherin"))
                {
                    bannerHA.setImageDrawable(null);
                    linearHA.setBackgroundColor(Color.parseColor("#1a472a"));
                    bannerHA.setBackgroundResource(R.drawable.slytherinbanner);
                    bttnSHA.setBackgroundColor(Color.parseColor("#1a472a"));
                }
                else if(selectedItem.equals("Ravenclaw")){
                    bannerHA.setImageDrawable(null);
                    linearHA.setBackgroundColor(Color.parseColor("#283593"));
                    bannerHA.setBackgroundResource(R.drawable.ravenclawbanner);
                    bttnSHA.setBackgroundColor(Color.parseColor("#283593"));
                }
                else if(selectedItem.equals("Gryffindor")){
                    bannerHA.setImageDrawable(null);
                    linearHA.setBackgroundColor(Color.parseColor("#ae0001"));
                    bannerHA.setBackgroundResource(R.drawable.gryffindorbanner);
                    bttnSHA.setBackgroundColor(Color.parseColor("#ae0001"));
                }
                else if(selectedItem.equals("Hufflepuff")){
                    bannerHA.setImageDrawable(null);
                    linearHA.setBackgroundColor(Color.parseColor("#003319"));
                    bannerHA.setBackgroundResource(R.drawable.hufflepuffbanner);
                    bttnSHA.setBackgroundColor(Color.parseColor("#003319"));
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {
                bannerHA.setImageDrawable(null);
                linearHA.setBackgroundColor(Color.WHITE);
            }


        });

        selectHB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Slytherin"))
                {
                    bannerHB.setImageDrawable(null);
                    linearHB.setBackgroundColor(Color.parseColor("#1a472a"));
                    bannerHB.setBackgroundResource(R.drawable.slytherinbanner);
                    bttnSHB.setBackgroundColor(Color.parseColor("#1a472a"));
                }
                else if(selectedItem.equals("Ravenclaw")){
                    bannerHB.setImageDrawable(null);
                    linearHB.setBackgroundColor(Color.parseColor("#283593"));
                    bannerHB.setBackgroundResource(R.drawable.ravenclawbanner);
                    bttnSHB.setBackgroundColor(Color.parseColor("#283593"));
                }
                else if(selectedItem.equals("Gryffindor")){
                    bannerHB.setImageDrawable(null);
                    linearHB.setBackgroundColor(Color.parseColor("#ae0001"));
                    bannerHB.setBackgroundResource(R.drawable.gryffindorbanner);
                    bttnSHB.setBackgroundColor(Color.parseColor("#ae0001"));
                }
                else if(selectedItem.equals("Hufflepuff")){
                    bannerHB.setImageDrawable(null);
                    linearHB.setBackgroundColor(Color.parseColor("#003319"));
                    bannerHB.setBackgroundResource(R.drawable.hufflepuffbanner);
                    bttnSHB.setBackgroundColor(Color.parseColor("#003319"));
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {
                bannerHB.setImageDrawable(null);
                linearHB.setBackgroundColor(Color.WHITE);
            }
        });

        bttnSHA.setEnabled(false);
        bttnSHB.setEnabled(false);
        actionButtons(false);
    }

    public void  startMatchButton(View View){
        selectHB.setEnabled(false);
        selectHA.setEnabled(false);
        bttnSHA.setEnabled(true);
        bttnSHB.setEnabled(true);
        actionButtons(true);
        bttnStart.setVisibility(View.INVISIBLE);
    }

    public void scoreIncreaseTA (View scoreOn){
        String score = scoreOn.getTag().toString();
        int result = Integer.parseInt(score);
        scoreHouseA = scoreHouseA + result;
        displayScoreA(scoreHouseA);
    }

    public void scoreIncreaseTB (View scoreOn){
        String score = scoreOn.getTag().toString();
        int result = Integer.parseInt(score);
        scoreHouseB = scoreHouseB + result;
        displayScoreB(scoreHouseB);
    }

    public void scoreSnitchA (View View){
        scoreHouseA = scoreHouseA + 150;
        displayScoreA(scoreHouseA);

        bttnSHA.setEnabled(false);
        bttnSHB.setEnabled(false);

        actionButtons(false);
    }

    public void scoreSnitchB (View View){
        scoreHouseB = scoreHouseB + 150;
        displayScoreB(scoreHouseB);

        bttnSHA.setEnabled(false);
        bttnSHB.setEnabled(false);

        actionButtons(false);
    }

    public void newMatch (View View){
        scoreHouseB = 0;
        scoreHouseA = 0;
        displayScoreB(scoreHouseB);
        displayScoreA(scoreHouseA);
        actionButtons(true);
        bttnSHB.setEnabled(true);
        bttnSHA.setEnabled(true);
        bttnStart.setVisibility(View.VISIBLE);
        selectHB.setEnabled(true);
        selectHA.setEnabled(true);
        linearHA.setBackgroundColor(Color.parseColor("#ffff"));
        linearHB.setBackgroundColor(Color.parseColor("#ffff"));
    }

    private void displayScoreA(int Number){
        TextView scoreTeamA = (TextView) findViewById(R.id.pointsTeamA);
        scoreTeamA.setText("" + Number);
    }

    private void displayScoreB(int Number){
        TextView scoreTeamB = (TextView) findViewById(R.id.pointsTeamB);
        scoreTeamB.setText("" + Number);
    }

    private void actionButtons(boolean parameter){

        for(int x = 0; x < linearHB.getChildCount(); x++){
            View linearHBV =  linearHB.getChildAt(x);
            linearHBV.setEnabled(parameter);
        }

        for(int y = 0; y < linearHA.getChildCount(); y++){
            View linearHAV =  linearHA.getChildAt(y);
            linearHAV.setEnabled(parameter);
        }
    }
}
