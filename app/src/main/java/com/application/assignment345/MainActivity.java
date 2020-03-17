package com.application.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
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
    ImageView image;
    double tip;
    double totalPrice;
    int quantity;
    double priceOfSelectedItem;

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
        image=findViewById(R.id.OrderImage);

        btn=findViewById(R.id.button);
        final int[] imageArray = {
                R.drawable.demo,
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4,
                R.drawable.pic5,
                R.drawable.pic6,
                R.drawable.pic7,
                R.drawable.pic8,
                R.drawable.pic9,
                R.drawable.pic10
        };

        final double[] priceArray = {0,5.99,4.99,8.99,7.99,12.99,6.00,7.00,5.00,5.00,10.99};


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Write code to perform some action when progress is changed.
                if(fromUser){
                    System.out.println("Progress of SeekBar " + progress);
                    quantity=seekBar.getProgress();
                    Toast.makeText(MainActivity.this, "Quantity " + quantity, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Write code to perform some action when touch is started.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Write code to perform some action when touch is stopped.
                // Toast.makeText(MainActivity.this, "Quantity " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  mealprice.setText(sp.getSelectedItemPosition());
                int index = sp.getSelectedItemPosition();
                System.out.println("index of selected item " + index);
                System.out.println("Price of item " + priceArray[index]);
                mealprice.setText("CAD $" + priceArray[index]);
                priceOfSelectedItem=priceArray[index];
                System.out.println("Price of Selected item " + priceOfSelectedItem);
                image.setImageResource(imageArray[index]);
                totalPrice=quantity*priceOfSelectedItem;
                System.out.println("Total price with quantity " + totalPrice);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(rg.getCheckedRadioButtonId()==R.id.radioButton1){
                    tip=totalPrice*0.1;
                    System.out.println("Tip selected "+tip);
                }
                else if(rg.getCheckedRadioButtonId()==R.id.radioButton2){
                    tip=totalPrice*0.2;
                    System.out.println("Tip selected "+tip);
                }
                else if(rg.getCheckedRadioButtonId()==R.id.radioButton3){
                    tip=totalPrice*0.25;
                    System.out.println("Tip selected "+tip);
                }

            }
        });








    }
}
