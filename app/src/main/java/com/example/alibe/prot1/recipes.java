package com.example.alibe.prot1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class recipes extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgbtnrec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        imgbtnrec = (ImageButton) findViewById(R.id.imageButton5);
        imgbtnrec.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton5:
                Intent intent = new Intent(this, viewRecipe.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
