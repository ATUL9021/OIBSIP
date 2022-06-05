package com.example.guessthenumbergame;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
Button selectNumber,changeNumber;
EditText guessingNumber;
TextView result;
int randomNumber,guessedNumber,attempt=0;
Random random=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectNumber=findViewById(R.id.selectNumber);
        changeNumber=findViewById(R.id.changeNumber);
        result=findViewById(R.id.result);
        guessingNumber=findViewById(R.id.guessingNumber);

        randomNumber=random.nextInt(100);
        selectNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String valueAtGuessTheNumber;
                    valueAtGuessTheNumber=guessingNumber.getText().toString();
                    guessedNumber=Integer.parseInt(valueAtGuessTheNumber);
                    attempt++;
                    if(guessedNumber == randomNumber){
                        result.setText("Congratulations! Your Guessed It Right in "+attempt+" Attempts");

                        Toast.makeText(getApplicationContext(),"Congratulations! Your Guessed It Right in "+attempt+" Attempts",Toast.LENGTH_SHORT).show();

                    }
                    else if(guessedNumber  > randomNumber){
                        result.setText("Please Enter Smaller Number");
                    }
                    else if(guessedNumber < randomNumber){
                        result.setText("Please Enter Greater Number");
                    }
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Please Enter Appropriate value",Toast.LENGTH_SHORT).show();
                }


            }
        });

        changeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber=random.nextInt(100);
                attempt=0;
                result.setText("");
                guessingNumber.setText("");
            }
        });

    }
}