package com.example.kukoikrzyyk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class wyborFigury extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybor_figury);
    }

    public void Kolko (View view)
    {
        Intent intent = new Intent(this, Bot.class);
        intent.putExtra("wybor", 1);
        startActivity(intent);
    }
    public void Krzyzyk (View view)
    {
        Intent intent = new Intent(this, Bot.class);
        intent.putExtra("wybor", 2);
        startActivity(intent);
    }

}
