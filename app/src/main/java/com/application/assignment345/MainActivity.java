package com.application.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    EditText mealprice;
    RadioGroup rg;
    TextView amount;
    CheckBox check;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = findViewById(R.id.seekBar);
        sp=findViewById(R.id.spinner);
        mealprice=findViewById(R.id.priceTextView);
        rg=findViewById(R.id.groupRB);
        amount=findViewById(R.id.amountTextView);
        check=findViewById(R.id.checkBox);
        btn=findViewById(R.id.button);


        final int[] imageArray = {1,2,3,4};
        final double[] priceArray = {0,10.99,30,20};

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  mealprice.setText(sp.getSelectedItemPosition());
                int index = sp.getSelectedItemPosition();
                System.out.println("Progress of Spiiner " + index);
                System.out.println("Price of Price " + priceArray[index]);
                mealprice.setText("CAD$" + priceArray[index]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // Write code to perform some action when progress is changed.
                    if(fromUser){
                        System.out.println("Progress of SeekBar " + progress);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // Write code to perform some action when touch is started.
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // Write code to perform some action when touch is stopped.
                    Toast.makeText(MainActivity.this, "Quantity " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
                }
            });




    }
}
