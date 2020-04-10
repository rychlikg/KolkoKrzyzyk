package com.example.kukoikrzyyk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void DwochGraczy(View view)
    {
        Intent intent = new Intent(this, DwuchGraczyJedenEkran.class);
        startActivity(intent);
    }
    public void Bot (View view)
    {
        Intent intent = new Intent(this, wyborFigury.class);
        startActivity(intent);
    }
    public void onClick(View view)
    {

    }
}
