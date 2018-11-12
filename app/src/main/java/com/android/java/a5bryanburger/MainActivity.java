package com.android.java.a5bryanburger;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {


    SeekBar redSB;
    SeekBar greenSB;
    SeekBar blueSB;
    RadioButton backgroundRadio;
    RadioButton textRadio;
    CheckBox backgroundCheckBox;
    CheckBox textCheckBox;
    RadioGroup picker;

    TextView redTV;
    TextView blueTV;
    TextView greenTV;
    TextView redLabel;
    TextView textView;
    TextView backgroundImg;
    TextView backgroundHex;
    TextView textHex;
    TableLayout table;




    int red = 100;
    int green = 100;
    int blue = 100;
    String textHexString;
    String backgroundHexString;
    String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redSB = findViewById(R.id.redSB);
        greenSB = findViewById(R.id.greenSB);
        blueSB = findViewById(R.id.blueSB);

        redTV = findViewById(R.id.redTV);
        greenTV = findViewById(R.id.greenTV);
        blueTV = findViewById(R.id.blueTV);
        redLabel = findViewById(R.id.redLabel);
        textView = findViewById(R.id.textView);
        backgroundImg = findViewById(R.id.backgroundImg);
        backgroundHex = findViewById(R.id.backgroundHex);
        textHex = findViewById(R.id.textHex);

        backgroundCheckBox = findViewById(R.id.backgroundCheckBox);
        textCheckBox = findViewById(R.id.textCheckBox);
        textRadio = findViewById(R.id.textRadio);
        backgroundRadio = findViewById(R.id.backgroundRadio);
        picker = findViewById(R.id.picker);

        table = findViewById(R.id.table);


        redSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redTV.setText(String.valueOf(progress));
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenTV.setText(String.valueOf(progress));
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueTV.setText(String.valueOf(progress));
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        backgroundCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(backgroundCheckBox.isChecked())
                    backgroundHex.setVisibility(View.VISIBLE);
                else
                    backgroundHex.setVisibility(View.GONE);
            }
        });
        textCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(textCheckBox.isChecked())
                    textHex.setVisibility(View.VISIBLE);
                else
                    textHex.setVisibility(View.GONE);
            }
        });



        picker.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                switch(rb.getText().toString()){
                    case "Background Color":
                        flag = "background";
                        break;
                    case "Text Color":
                        flag = "text";
                        break;
                }
            }
        });

    }

    private void updateColor(){
        red = redSB.getProgress();
        green = greenSB.getProgress();
        blue = blueSB.getProgress();

        if(flag == "background"){
            backgroundImg.setBackgroundColor(Color.rgb(red, green, blue));
            backgroundHexString = String.format("#%02X%02X%02X", red, green, blue);
            backgroundHex.setText(backgroundHexString);
        }
        else if(flag == "text"){
            textView.setTextColor(Color.rgb(red, green, blue));
            textHexString = String.format("#%02X%02X%02X", red, green, blue);
            textHex.setText(textHexString);
        }



    }
}