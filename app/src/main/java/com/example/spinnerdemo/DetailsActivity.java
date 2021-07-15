package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView Title,Color,Type,ItemP;
    EditText quantity;
    Button back, cart;
    public static double FinalPrice=0;

    double totalprice=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Title=findViewById(R.id.txvTitle);
        Color=findViewById(R.id.txvProtein);
        Type=findViewById(R.id.txvCalories);
        quantity=findViewById(R.id.txvQuantity);
        back=findViewById(R.id.btnBack);
        cart=findViewById(R.id.btnAddCart);
        Title.setText(MainActivity.caObj.getName());
        Color.setText(MainActivity.caObj.getColor());
        Type.setText(MainActivity.caObj.getType());
        ItemP=findViewById(R.id.itemPrice);
        double p=Double.parseDouble(MainActivity.caObj.getPrice());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double q=Double.parseDouble(quantity.getText().toString());
                totalprice=q*p;
                ItemP.setText(totalprice+" $");
                FinalPrice+=totalprice;
            }
        });
    }
}