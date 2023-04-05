package com.example.burerrands_hanyu.Activity;

import static android.view.KeyCharacterMap.load;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.burerrands_hanyu.Activity.R;

public class ShowDetailActivity extends AppCompatActivity {
private TextView addToCartBtn;
private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt;
private ImageView plusBtn, minusBtn, picFood;
private FoodDomain object;
int numberOrder = 1;
private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        managementCart = new ManegementCart(this);


        initView();
        getBundle();
    }

    private void getBundle(){
        object = (FoodDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this);
            .load(drawableResourceId);
            .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClckListener(new View.OnClckListener(){
            @Override
            public void onClick(View view){
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClckListener(new View.OnClckListener(){
            @Override
            public void onClick(View view){
                if(numberOrder > 1){
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initView(){
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.feeTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood = findViewById(R.id.picfood);
    }

}