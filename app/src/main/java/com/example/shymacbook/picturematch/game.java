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
import android.widget.Toast;


public class game extends AppCompatActivity {

    private TextView showName;
    private int clickCount;
    private ImageView card_first;
    private ImageView card_second;
    private ImageView card_0;
    private ImageView card_1;
    private ImageView card_2;
    private ImageView card_3;
    private ImageView card_4;
    private ImageView card_5;
    private int card_0_ID;
    private int card_1_ID;
    private int card_2_ID;
    private int card_3_ID;
    private int card_4_ID;
    private int card_5_ID;
    private Integer[] flipArray = {0,0,0,0,0,0};
    private String[] colorArray;
    private ImageView[] cardArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        clickCount = 0;

        card_0 = (ImageView)findViewById(R.id.card0);
        card_1 = (ImageView)findViewById(R.id.card1);
        card_2 = (ImageView)findViewById(R.id.card2);
        card_3 = (ImageView)findViewById(R.id.card3);
        card_4 = (ImageView)findViewById(R.id.card4);
        card_5 = (ImageView)findViewById(R.id.card5);


        ImageView[] cardArray = {card_0, card_1,  card_2, card_3, card_4, card_5};
        String[] colorArray = {"red", "blue", "yellow", "red", "blue", "yellow"};
        Integer[] flipArray = {0,0,0,0,0,0};

        cardArray[0].setBackgroundResource(R.color.red);
        cardArray[1].setBackgroundResource(R.color.blue);
        cardArray[2].setBackgroundResource(R.color.yellow);
        cardArray[3].setBackgroundResource(R.color.red);
        cardArray[4].setBackgroundResource(R.color.blue);
        cardArray[5].setBackgroundResource(R.color.yellow);

        cardArray[0].setVisibility(View.INVISIBLE);
        cardArray[1].setVisibility(View.INVISIBLE);
        cardArray[2].setVisibility(View.INVISIBLE);
        cardArray[3].setVisibility(View.INVISIBLE);
        cardArray[4].setVisibility(View.INVISIBLE);
        cardArray[5].setVisibility(View.INVISIBLE);

        showName = (TextView) findViewById(R.id.nameSpot);
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            String textEntered = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
            showName.setText(textEntered);
        }
    }

    public void flip(View view) {
        clickCount++;
        Log.d("card clicks", "card click counter: " + clickCount);
        if (clickCount == 1){
            card_first = (ImageView)findViewById(view.getId());
            Log.d("card clicks", "card_first assigned");
//            card_first.setImageAlpha(1);
            card_first.setVisibility(View.VISIBLE);
        }
        if (clickCount == 2){
            card_second = (ImageView)findViewById(view.getId());
            Log.d("card clicks", "card_second assigned");
//            card_first.setImageAlpha(1);
            card_first.setVisibility(View.VISIBLE);
            if (card_first.getBackground().equals(card_second.getBackground())){
                clickCount = 0;
                Log.d("card clicks reset", "card click counter: " + clickCount);
                Toast.makeText(this, "MATCH!", Toast.LENGTH_SHORT).show();
            }
            else if ( !(card_first.getBackground().equals(card_second.getBackground())) ){
                Toast.makeText(this, "wrong...", Toast.LENGTH_SHORT).show();
                clickCount = 0;
                Log.d("card clicks reset", "card click counter: " + clickCount);
//                card_first.setImageAlpha(0);
//                card_second.setImageAlpha(0);
                card_first.setVisibility(View.INVISIBLE);
                card_second.setVisibility(View.INVISIBLE);

            }
        }
    }




}
