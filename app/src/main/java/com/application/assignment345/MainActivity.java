package com.application.assignment345;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    EditText mealprice;
    RadioGroup rg;
    EditText amount;
    CheckBox check;
    Button btn;
    ImageView image;
    double tip;
    double totalPrice;
    double tax=0.13;
    double priceWithTaxes;
    int quantity;
    double priceOfSelectedItem;
    String roundTip;
    double ActualTip;
    String FinalPrice;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar seekBar = findViewById(R.id.seekBar);
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




        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  mealprice.setText(sp.getSelectedItemPosition());
                index = sp.getSelectedItemPosition();
                System.out.println("index of selected item " + index);
                System.out.println("Price of item " + priceArray[index]);
                mealprice.setText("CAD $" + priceArray[index]);
                priceOfSelectedItem=priceArray[index];
                System.out.println("Price of Selected item " + priceOfSelectedItem);
                image.setImageResource(imageArray[index]);


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
                    quantity=seekBar.getProgress();
                    totalPrice=seekBar.getProgress()*priceOfSelectedItem;
                    System.out.println("Total price with quantity " + totalPrice);
                    Toast.makeText(MainActivity.this, "Quantity  " + quantity, Toast.LENGTH_SHORT).show();
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



        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(rg.getCheckedRadioButtonId()==R.id.radioButton1){
                    tip=totalPrice*0.1;
                    roundTip = String.format("%.2f", tip);
                    System.out.println("Tip selected "+roundTip+" and total Price : "+totalPrice);

                    ActualTip=Double.parseDouble(roundTip);
                    priceWithTaxes=totalPrice+tip+ActualTip;
                    System.out.println("Price after Taxes "+priceWithTaxes);
                    FinalPrice=String.valueOf(String.format("%.2f", priceWithTaxes));
                    amount.setText("$"+FinalPrice);
                    System.out.println("Final Price : "+FinalPrice);

                }
                else if(rg.getCheckedRadioButtonId()==R.id.radioButton2){
                    tip=totalPrice*0.15;
                    roundTip = String.format("%.2f", tip);
                    System.out.println("Tip selected "+roundTip+" and total Price : "+totalPrice);

                    ActualTip=Double.parseDouble(roundTip);
                    priceWithTaxes=totalPrice+tip+ActualTip;
                    System.out.println("Price after Taxes "+priceWithTaxes);
                    FinalPrice=String.valueOf(String.format("%.2f", priceWithTaxes));
                    amount.setText("$"+FinalPrice);
                    System.out.println("Final Price : "+FinalPrice);
                }
                else if(rg.getCheckedRadioButtonId()==R.id.radioButton3){
                    tip=totalPrice*0.2;
                    roundTip = String.format("%.2f", tip);
                    System.out.println("Tip selected "+roundTip+" and total Price : "+totalPrice);

                    ActualTip=Double.parseDouble(roundTip);
                    priceWithTaxes=totalPrice+tip+ActualTip;
                    System.out.println("Price after Taxes "+priceWithTaxes);
                    FinalPrice=String.valueOf(String.format("%.2f", priceWithTaxes));
                    amount.setText("$"+FinalPrice);
                    System.out.println("Final Price : "+FinalPrice);
                }

            }
        });






        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check.isChecked() && index>0 && quantity>0 ){
                    Toast.makeText(MainActivity.this, "Order confirmed..  " , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                   intent.putExtra("order","whole eggs");
                   intent.putExtra("quant","2");
                   intent.putExtra("prices","4.99");
                    startActivity(intent);
                }

                else{
                    Toast.makeText(MainActivity.this, "Please input all fields  " , Toast.LENGTH_SHORT).show();
                }

            }
        });












    }
}
