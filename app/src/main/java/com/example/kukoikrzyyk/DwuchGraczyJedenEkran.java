package com.example.kukoikrzyyk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DwuchGraczyJedenEkran extends AppCompatActivity implements View.OnClickListener {

    boolean kolkoPierwsze = true;
    boolean pierwszaGra = true;

    int kolko = 0;
    int krzyzyk = 0;
    int ruch = 0;

    TextView kolkowynik;
    TextView krzyzykwynik;

    Button pole00;
    Button pole01;
    Button pole02;
    Button pole10;
    Button pole11;
    Button pole12;
    Button pole20;
    Button pole21;
    Button pole22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dwuch_graczy_jeden_ekran);
        ktoPierwszy();

        kolkowynik = findViewById(R.id.kolkowynik);
        krzyzykwynik = findViewById(R.id.krzyzykwynik);

        pole00 = findViewById(R.id.pole00);
        pole00.setOnClickListener(this);
        pole01 = findViewById(R.id.pole01);
        pole01.setOnClickListener(this);
        pole02 = findViewById(R.id.pole02);
        pole02.setOnClickListener(this);
        pole10 = findViewById(R.id.pole10);
        pole10.setOnClickListener(this);
        pole11 = findViewById(R.id.pole11);
        pole11.setOnClickListener(this);
        pole12 = findViewById(R.id.pole12);
        pole12.setOnClickListener(this);
        pole20 = findViewById(R.id.pole20);
        pole20.setOnClickListener(this);
        pole21 = findViewById(R.id.pole21);
        pole21.setOnClickListener(this);
        pole22 = findViewById(R.id.pole22);
        pole22.setOnClickListener(this);

    }

    public void onClick(View view)
    {
        //Gdy próba kliknięcia na zajęte pole
        if(!((Button) view).getText().equals("")){
            Toast.makeText(getApplicationContext(),"Pole już zajęte",Toast.LENGTH_SHORT).show();
            return;
        }
        ruch++;

        if(kolkoPierwsze){
            ((Button) view).setText("O");
            if(czyWygrana()){
                nowaGra();
            }else kolkoPierwsze = false;

        }else {
            ((Button) view).setText("X");
            if(czyWygrana()){
                nowaGra();
            } else kolkoPierwsze = true;

        }
        if(ruch == 9)
        {
            remis();
        }
    }

    public void remis(){
            Toast.makeText(this, "Remis", Toast.LENGTH_SHORT).show();
            nowaGra();
    }
    public void nowaGra()
    {
        ruch = 0;
        pole00.setText("");
        pole01.setText("");
        pole02.setText("");
        pole10.setText("");
        pole11.setText("");
        pole12.setText("");
        pole20.setText("");
        pole21.setText("");
        pole22.setText("");
        ktoPierwszy();

    }
    public boolean czyWygrana()
    {
        if(pole00.getText() != "" && pole00.getText().equals(pole01.getText())&& pole00.getText().equals(pole02.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                kolkowynik.setText(String.valueOf(kolko));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                krzyzykwynik.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
       if(pole10.getText() != "" && pole10.getText().equals(pole11.getText())&& pole10.getText().equals(pole12.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                kolkowynik.setText(String.valueOf(kolko));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                krzyzykwynik.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
        if(pole20.getText() != "" &&pole20.getText().equals(pole21.getText())&& pole20.getText().equals(pole22.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                kolkowynik.setText(String.valueOf(kolko));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                krzyzykwynik.setText(String.valueOf(krzyzyk));
            }
            //return true;
        }
        if(pole00.getText() != "" &&pole00.getText().equals(pole10.getText())&& pole20.getText().equals(pole00.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                kolkowynik.setText(String.valueOf(kolko));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                krzyzykwynik.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
        if(pole01.getText() != "" &&pole01.getText().equals(pole11.getText())&& pole01.getText().equals(pole21.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                kolkowynik.setText(String.valueOf(kolko));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                krzyzykwynik.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
        if(pole02.getText() != "" &&pole02.getText().equals(pole12.getText())&& pole02.getText().equals(pole22.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                kolkowynik.setText(String.valueOf(kolko));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                krzyzykwynik.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
        if(pole00.getText() != "" &&pole00.getText().equals(pole11.getText())&& pole00.getText().equals(pole22.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                kolkowynik.setText(String.valueOf(kolko));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                krzyzykwynik.setText(String.valueOf(krzyzyk));
            }
            return true;

        }
        if(pole02.getText() != "" &&pole02.getText().equals(pole11.getText())&& pole02.getText().equals(pole20.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                kolkowynik.setText(String.valueOf(kolko));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                krzyzykwynik.setText(String.valueOf(krzyzyk));
            }
           return true;
        }
        return false;
    }

    public void ktoPierwszy(){
        if(pierwszaGra == true)
       {
            int i = (int)Math.random()*2+1;
            if(i == 1){
                Toast.makeText(getApplicationContext(),"Kółko zaczyna",Toast.LENGTH_SHORT).show();
                kolkoPierwsze = true;
            }
            if(i == 2){
                Toast.makeText(getApplicationContext(),"Krzyżyk zaczyna",Toast.LENGTH_SHORT).show();
                kolkoPierwsze = false;
            }
            pierwszaGra = false;
        }else if (kolkoPierwsze){
            kolkoPierwsze = false;
            Toast.makeText(getApplicationContext(),"Krzyżyk zaczyna",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Kółko zaczyna",Toast.LENGTH_SHORT).show();
            kolkoPierwsze = true;
        }
    }

    public void PowrotDGJE(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
