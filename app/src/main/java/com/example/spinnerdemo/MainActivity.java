package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String CarNames[]={"SantaFe","Audi","BMW","Jaguar","Mercedes"};
    ArrayList<Car> CarList=new ArrayList<>();
    public static Car caObj;
    TextView Price,FinalPrice;
    ImageView CarImg;
    Spinner sp;
    Button ShowMore,PlaceOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        Price=findViewById(R.id.txvPrice);
        CarImg=findViewById(R.id.imgCar);
        sp=findViewById(R.id.sp);
        ShowMore=findViewById(R.id.btnShowMore);
        PlaceOrder=findViewById(R.id.btnPlace);
        FinalPrice=findViewById(R.id.txvFinal);
        //create an array adapter
        ArrayAdapter aa=new ArrayAdapter( this, R.layout.support_simple_spinner_dropdown_item,CarNames);
        sp.setAdapter(aa);
        //implement the spinner event
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Price.setText(CarList.get(position).getPrice());
                CarImg.setImageResource(CarList.get(position).getImg());
                caObj=CarList.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),DetailsActivity.class);
                startActivity(intent);
            }
        });
        PlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            FinalPrice.setText((DetailsActivity.FinalPrice+" $"));
            DetailsActivity.FinalPrice=0;
            }
        });
    }
    public void fillData(){
        CarList.add(new Car("SantaFe","56000",R.mipmap.s,"Rainforest","Automatic"));
        CarList.add(new Car("Audi","60000",R.mipmap.a,"Black","Automatic"));
        CarList.add(new Car("BMW","50000",R.mipmap.b,"White","Automatic"));
        CarList.add(new Car("Jaguar","90000",R.mipmap.jaguar,"Yellow","F-Type"));
        CarList.add(new Car("Mercedes","87000",R.mipmap.mercedes,"Green","Tiptronic"));
    }
}