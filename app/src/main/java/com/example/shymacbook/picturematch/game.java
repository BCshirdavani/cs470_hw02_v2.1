package com.example.shymacbook.picturematch;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class game extends AppCompatActivity {

    private TextView showName;
    int clickCount;
    ImageView card_1;
    int card_1_ID;
    ImageView card_2;


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
//            card_1 = (ImageView)findViewById(card_1_ID);
            card_1 = (ImageView)findViewById(R.id.card_1_ID);
            // flip image
        }
        if (clickCount == 2){
            // do comparison here, now that 2 cards are selected

            // assign card 2

            // flip image

            // compare stuff

            // reset click count for the future clicks
            clickCount = 0;
        }
    }

}
