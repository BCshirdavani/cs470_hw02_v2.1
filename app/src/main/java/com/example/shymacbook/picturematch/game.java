package com.example.shymacbook.picturematch;

import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class game extends AppCompatActivity {

    private TextView showName;
    int clickCount;
    ImageView card_1;
    int card_1_ID;
    ImageView card_2;
    int card_2_ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        clickCount = 0;

        showName = (TextView) findViewById(R.id.nameSpot);
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            String textEntered = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
            showName.setText(textEntered);
        }
    }

    public void flip(View view) {
        clickCount++;
        if (clickCount == 1){
            // assign card 1
            card_1_ID = view.getId();
            card_1 = (ImageView)findViewById(card_1_ID);
            Log.d("card clicks", "card 1 assigned");
            Log.d("card clicks", "card click counter: " + clickCount);
            // flip image
            card_1.setBackgroundResource(R.color.red);
        }
        if (clickCount == 2){
            // do comparison here, now that 2 cards are selected
            // assign card 2
            card_2_ID = view.getId();
            card_2 = (ImageView)findViewById(card_2_ID);
            Log.d("card clicks", "card 2 assigned");
            Log.d("card clicks", "card click counter: " + clickCount);
            // flip image
            
            // compare stuff

            // if they match, reward! and reset the clicks to 0

        }
        if (clickCount == 3){
            Log.d("card clicks", "card click counter: " + clickCount);
            // not a match, reset the cards and counter



            clickCount = 0;
            Log.d("card clicks", "card click counter reset to " + clickCount);
        }
    }






}
