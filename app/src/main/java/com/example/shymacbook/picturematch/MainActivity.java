package com.example.shymacbook.picturematch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button playBUTTON;
    private EditText nameIN;
    private String nameEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playBUTTON = (Button) findViewById(R.id.play_button);
        nameIN = (EditText) findViewById(R.id.name_input);

        playBUTTON.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  nameEntered = nameIN.getText().toString();
                  Intent startChildActivityIntent = new Intent(MainActivity.this, game.class);
                  startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, nameEntered);
                  startActivity(startChildActivityIntent);
              }
            }
        );

    }


    public void playNow(View view) {

    }
}
