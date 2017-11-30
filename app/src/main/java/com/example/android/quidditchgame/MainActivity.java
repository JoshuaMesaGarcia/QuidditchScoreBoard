package com.example.android.quidditchgame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Global variables
    int scoreHouseA = 0; // The score of House A (Left)
    int scoreHouseB = 0; // The score of House A (Left)
    LinearLayout linearHB;
    LinearLayout linearHA;
    Button bttnSHB; // Button Snitch Catched House B
    Button bttnSHA; // Button Snitch Catched House A
    private Spinner selectHA; // Menu to select House A
    private Spinner selectHB; // Menu to select House A
    ImageView bannerHA;
    ImageView bannerHB;
    Button bttnStart; // Button Start Match


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //We need to create the variables here because this method create this variables at the
        //begginning of the application
        linearHB = (LinearLayout) findViewById(R.id.linearB);
        linearHA = (LinearLayout) findViewById(R.id.linearA);
        bttnSHB = (Button) findViewById(R.id.buttonSB);
        bttnSHA = (Button) findViewById(R.id.buttonSA);
        selectHA = (Spinner) findViewById(R.id.select_houseA);
        selectHB = (Spinner) findViewById(R.id.select_houseB);
        bannerHA = (ImageView) findViewById(R.id.bannerHouseA);
        bannerHB = (ImageView) findViewById(R.id.bannerHouseB);
        bttnStart = (Button) findViewById(R.id.startButton);

        // We select a house from the menu and depending the selected choice the another spinner will change
        selectHA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Slytherin")) {
                    bannerHA.setImageDrawable(null); // Remove the image from the previous House
                    linearHA.setBackgroundColor(Color.parseColor("#1a472a")); // Color of the house on the layout
                    bannerHA.setBackgroundResource(R.drawable.slytherinbanner); // Set the banner
                    bttnSHA.setBackgroundColor(Color.parseColor("#1a472a"));  // Color of the house on the Button

                    //Change dynamically the menu of House B thats allows no repetition in House A
                    ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(
                            MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, new String[] {
                            "--Houses--","Gryffindor", "Ravenclaw","Hufflepuff" });
                    spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectHB.setAdapter(spinnerAdapter2);


                } else if (selectedItem.equals("Ravenclaw")) {
                    bannerHA.setImageDrawable(null);
                    linearHA.setBackgroundColor(Color.parseColor("#283593"));
                    bannerHA.setBackgroundResource(R.drawable.ravenclawbanner);
                    bttnSHA.setBackgroundColor(Color.parseColor("#283593"));


                    ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(
                            MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, new String[] {
                            "--Houses--","Gryffindor", "Slytherin","Hufflepuff" });
                    spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectHB.setAdapter(spinnerAdapter2);

                } else if (selectedItem.equals("Gryffindor")) {
                    bannerHA.setImageDrawable(null);
                    linearHA.setBackgroundColor(Color.parseColor("#ae0001"));
                    bannerHA.setBackgroundResource(R.drawable.gryffindorbanner);
                    bttnSHA.setBackgroundColor(Color.parseColor("#ae0001"));

                    ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(
                            MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, new String[] {
                            "--Houses--","Ravenclaw", "Slytherin","Hufflepuff" });
                    spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectHB.setAdapter(spinnerAdapter2);

                } else if (selectedItem.equals("Hufflepuff")) {
                    bannerHA.setImageDrawable(null);
                    linearHA.setBackgroundColor(Color.parseColor("#003319"));
                    bannerHA.setBackgroundResource(R.drawable.hufflepuffbanner);
                    bttnSHA.setBackgroundColor(Color.parseColor("#003319"));

                    ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(
                            MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item, new String[] {
                            "--Houses--","Gryffindor", "Slytherin","Ravenclaw" });
                    spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectHB.setAdapter(spinnerAdapter2);

                }
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {
                bannerHA.setImageDrawable(null);
                linearHA.setBackgroundColor(Color.WHITE);
            }
        });

        selectHB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Slytherin")) {
                    bannerHB.setImageDrawable(null);
                    linearHB.setBackgroundColor(Color.parseColor("#1a472a"));
                    bannerHB.setBackgroundResource(R.drawable.slytherinbanner);
                    bttnSHB.setBackgroundColor(Color.parseColor("#1a472a"));

                } else if (selectedItem.equals("Ravenclaw")) {
                    bannerHB.setImageDrawable(null);
                    linearHB.setBackgroundColor(Color.parseColor("#283593"));
                    bannerHB.setBackgroundResource(R.drawable.ravenclawbanner);
                    bttnSHB.setBackgroundColor(Color.parseColor("#283593"));

                } else if (selectedItem.equals("Gryffindor")) {
                    bannerHB.setImageDrawable(null);
                    linearHB.setBackgroundColor(Color.parseColor("#ae0001"));
                    bannerHB.setBackgroundResource(R.drawable.gryffindorbanner);
                    bttnSHB.setBackgroundColor(Color.parseColor("#ae0001"));

                } else if (selectedItem.equals("Hufflepuff")) {
                    bannerHB.setImageDrawable(null);
                    linearHB.setBackgroundColor(Color.parseColor("#003319"));
                    bannerHB.setBackgroundResource(R.drawable.hufflepuffbanner);
                    bttnSHB.setBackgroundColor(Color.parseColor("#003319"));

                }
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {
                bannerHB.setImageDrawable(null);
                linearHB.setBackgroundColor(Color.WHITE);
            }
        });

        bttnSHA.setEnabled(false); //Because is the creation of the game we want that everything is turned of
        bttnSHB.setEnabled(false);
        actionButtons(false);
        bannerHB.setVisibility(View.INVISIBLE);
        bannerHA.setVisibility(View.INVISIBLE);
    }

    // Method that initiate the match
    public void startMatchButton(View View) {
        String strSelectHA = selectHA.getItemAtPosition(selectHA.getSelectedItemPosition()).toString();
        String strSelectHB = selectHB.getItemAtPosition(selectHB.getSelectedItemPosition()).toString();
        if((strSelectHA != "--Houses--")&&(strSelectHB != "--Houses--")){ //If the selection of both houses are different than Houses the game can start
            selectHB.setEnabled(false);
            selectHA.setEnabled(false);
            bttnSHA.setEnabled(true);
            bttnSHB.setEnabled(true);
            actionButtons(true);
            bttnStart.setVisibility(View.INVISIBLE);
            bannerHA.setVisibility(View.VISIBLE);
            bannerHB.setVisibility(View.VISIBLE);
        }else{
            selectHB.setEnabled(true);
            selectHA.setEnabled(true);
            bttnSHA.setEnabled(false);
            bttnSHB.setEnabled(false);
            actionButtons(false);
            bttnStart.setVisibility(View.VISIBLE);
        }
    }

    // Methods to score points and then set into the screen
    public void scoreIncreaseTA(View scoreOn) {
        String score = scoreOn.getTag().toString(); //Get the value of the tag of that button
        int result = Integer.parseInt(score); // Cast the string into int
        scoreHouseA = scoreHouseA + result;
        displayScoreA(scoreHouseA);//Goes to this method -> which will display the result
    }

    public void scoreIncreaseTB(View scoreOn) {
        String score = scoreOn.getTag().toString();
        int result = Integer.parseInt(score);
        scoreHouseB = scoreHouseB + result;
        displayScoreB(scoreHouseB);
    }

    //Methods that implement the catching of the Snitch
    public void scoreSnitchA(View View) {
        scoreHouseA = scoreHouseA + 150;
        displayScoreA(scoreHouseA);

        bttnSHA.setEnabled(false);
        bttnSHB.setEnabled(false);

        actionButtons(false);
    }

    public void scoreSnitchB(View View) {
        scoreHouseB = scoreHouseB + 150;
        displayScoreB(scoreHouseB);

        bttnSHA.setEnabled(false);
        bttnSHB.setEnabled(false);

        actionButtons(false);
    }

    //Method to start a new Match - Everything has to be disable
    public void newMatch(View View) {
        scoreHouseB = 0;
        scoreHouseA = 0;
        displayScoreB(scoreHouseB);
        displayScoreA(scoreHouseA);
        actionButtons(false);
        bttnSHB.setEnabled(false);
        bttnSHA.setEnabled(false);
        bttnStart.setVisibility(View.VISIBLE);
        selectHB.setEnabled(true);
        selectHA.setEnabled(true);
        bannerHB.setVisibility(View.INVISIBLE);
        bannerHA.setVisibility(View.INVISIBLE);
        linearHB.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearHA.setBackgroundColor(Color.parseColor("#FFFFFF"));
        bttnSHA.setBackgroundColor(Color.parseColor("#d6d6d6"));
        bttnSHB.setBackgroundColor(Color.parseColor("#d6d6d6"));

        //This allows that at least one of the houses has houses on the menu wich it means the match cannot start
        ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, new String[] {
                "--Houses--","Ravenclaw", "Slytherin","Hufflepuff" });
        spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectHB.setAdapter(spinnerAdapter2);
    }

    //
    private void displayScoreA(int Number) {
        TextView scoreTeamA = (TextView) findViewById(R.id.pointsTeamA);
        scoreTeamA.setText("" + Number);
    }

    private void displayScoreB(int Number) {
        TextView scoreTeamB = (TextView) findViewById(R.id.pointsTeamB);
        scoreTeamB.setText("" + Number);
    }

    //Method to disable every score button from every LinearLayout
    private void actionButtons(boolean parameter) {

        for (int x = 0; x < linearHB.getChildCount(); x++) {
            View linearHBV = linearHB.getChildAt(x);
            linearHBV.setEnabled(parameter);
        }

        for (int y = 0; y < linearHA.getChildCount(); y++) {
            View linearHAV = linearHA.getChildAt(y);
            linearHAV.setEnabled(parameter);
        }
    }
}
