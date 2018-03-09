package com.example.shymacbook.picturematch;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
    private ColorDrawable drawable_first;
    private ColorDrawable drawable_second;
    private Integer card_f_int;
    private Integer card_s_int;
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
    private Integer[] colorArray;
    private ImageView[] cardArray;
    private String bg_color;


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
        Integer[] colorArray = {R.color.red, R.color.blue, R.color.yellow, R.color.red, R.color.blue, R.color.yellow};
        Integer[] flipArray = {0,0,0,0,0,0};

        for (int i = 0; i < 6 ; i++) {
            cardArray[i].setBackgroundColor(colorArray[i]);
        }

        Log.d("game mod", "image view colors set onCreate");

//        cardArray[0].setVisibility(View.INVISIBLE);
//        cardArray[1].setVisibility(View.INVISIBLE);
//        cardArray[2].setVisibility(View.INVISIBLE);
//        cardArray[3].setVisibility(View.INVISIBLE);
//        cardArray[4].setVisibility(View.INVISIBLE);
//        cardArray[5].setVisibility(View.INVISIBLE);
//        Log.d("game mod", "image view visibility changed onCreate");


        cardArray[0].setImageAlpha(10);
        cardArray[1].setImageAlpha(255);
        cardArray[2].setImageAlpha(10);
        cardArray[3].setImageAlpha(255);
        cardArray[4].setImageAlpha(10);
        cardArray[5].setImageAlpha(255);
        Log.d("game mod", "image view alpha's changed onCreate");

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
            card_first.setImageAlpha(1);
            drawable_first = (ColorDrawable) card_first.getBackground();
            card_f_int = Integer.parseInt(card_first.getTag().toString());      //---------------- integer card ID
//            card_first.setVisibility(View.VISIBLE);
        }
        if (clickCount == 2){
            card_second = (ImageView)findViewById(view.getId());
            card_s_int = Integer.parseInt(card_second.getTag().toString());     //---------------- integer card ID
            Log.d("card clicks", "card_second assigned");
            card_first.setImageAlpha(1);
//            card_first.setVisibility(View.VISIBLE);
            if (card_first.getBackground().equals(card_second.getBackground()) ){
//            if (card_first.getSolidColor() == card_second.getSolidColor()){
                clickCount = 0;
                Log.d("card clicks reset", "card click counter: " + clickCount);
                Toast.makeText(this, "MATCH!", Toast.LENGTH_SHORT).show();
            }
            else if ( !(card_first.getBackground().equals(card_second.getBackground())) ){
                Toast.makeText(this, "wrong...", Toast.LENGTH_SHORT).show();
                clickCount = 0;
                Log.d("card clicks reset", "card click counter: " + clickCount);
                card_first.setImageAlpha(10);
                card_second.setImageAlpha(10);
//                card_first.setVisibility(View.INVISIBLE);
//                card_second.setVisibility(View.INVISIBLE);

            }
        }
    }




}
