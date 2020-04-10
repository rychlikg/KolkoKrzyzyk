package com.example.kukoikrzyyk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;
import android.os.Bundle;

public class Bot extends AppCompatActivity implements View.OnClickListener {
    boolean kolkoPierwsze = true;
    boolean pierwszaGra = true;
    boolean graczKolko;
    String znak = "";
    int zmienna = 0;

    int kolko = 0;
    int krzyzyk = 0;
    int ruch = 0;

    TextView gracz;
    TextView bot;

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
        setContentView(R.layout.activity_bot);

        gracz = findViewById(R.id.graczWynik);
        bot = findViewById(R.id.botWynik);
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

        int wybor = getIntent().getIntExtra("wybor",1);
        if(wybor == 1) {
            graczKolko = true;
        }else if (wybor == 2) {
            graczKolko = false;
        }
        ktoPierwszy();
    }

    public void ruchBota() {

        boolean wolne = false;
        if (graczKolko) {
            znak = "X";
        }
        else {
            znak = "O";
        }
        if (ruch == 0) {
            zmienna = (int) (Math.random() * 9) + 1;

            if (zmienna == 1)
                pole00.setText(znak);
            else if (zmienna == 2)
                pole01.setText(znak);
            else if (zmienna == 3)
                pole02.setText(znak);
            else if (zmienna == 4)
                pole10.setText(znak);
            else if (zmienna == 5)
                pole11.setText(znak);
            else if (zmienna == 6)
                pole12.setText(znak);
            else if (zmienna == 7)
                pole20.setText(znak);
            else if (zmienna == 8)
                pole21.setText(znak);
            else if (zmienna == 9)
                pole22.setText(znak);

        }
        else{
            while (!wolne){
                zmienna = (int) (Math.random() * 9) + 1;
                if (zmienna == 1 && pole00.getText().equals("")){
                    pole00.setText(znak);
                    wolne = true;
                }
                else if (zmienna == 2 && pole01.getText().equals("")){
                    pole01.setText(znak);
                    wolne = true;
                }
                else if (zmienna == 3 && pole02.getText().equals("")){
                    pole02.setText(znak);
                    wolne = true;
                }
                else if (zmienna == 4 && pole10.getText().equals("")){
                    pole10.setText(znak);
                    wolne = true;
                }
                else if (zmienna == 5 && pole11.getText().equals("")){
                    pole11.setText(znak);
                    wolne = true;
                }
                else if (zmienna == 6 && pole12.getText().equals("")){
                    pole12.setText(znak);
                    wolne = true;
                }
                else if (zmienna == 7 && pole20.getText().equals("")){
                    pole20.setText(znak);
                    wolne = true;
                }
                else if (zmienna == 8 && pole21.getText().equals("")){
                    pole21.setText(znak);
                    wolne = true;
                }
                else if (zmienna == 9 && pole22.getText().equals("")){
                    pole22.setText(znak);
                    wolne = true;
                }

            }
        }
        ruch++;
       // czyWygrana();
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
            } else ruchBota();
        }else {
            ((Button) view).setText("X");
            if(czyWygrana()){
                nowaGra();
            }
            else ruchBota();

        }
        if(ruch == 9)
        {
            remis();
        }
    }

    public void remis(){
        Toast.makeText(this, "Remis", Toast.LENGTH_SHORT).show();
        try {
            synchronized(this){
                wait(3000);
            }
        }
        catch(InterruptedException ex){
        }
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
                if(graczKolko) {
                    gracz.setText(String.valueOf(kolko));
                }
                else bot.setText((String.valueOf(kolko)));

            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                if(graczKolko){
                    bot.setText(String.valueOf(krzyzyk));
                }
                else gracz.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
        if(pole10.getText() != "" && pole10.getText().equals(pole11.getText())&& pole10.getText().equals(pole12.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                if(graczKolko) {
                    gracz.setText(String.valueOf(kolko));
                }
                else bot.setText((String.valueOf(kolko)));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                if(graczKolko){
                    bot.setText(String.valueOf(krzyzyk));
                }
                else gracz.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
        if(pole20.getText() != "" &&pole20.getText().equals(pole21.getText())&& pole20.getText().equals(pole22.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                if(graczKolko) {
                    gracz.setText(String.valueOf(kolko));
                }
                else bot.setText((String.valueOf(kolko)));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                if(graczKolko){
                    bot.setText(String.valueOf(krzyzyk));
                }
                else gracz.setText(String.valueOf(krzyzyk));
            }
            //return true;
        }
        if(pole00.getText() != "" &&pole00.getText().equals(pole10.getText())&& pole20.getText().equals(pole00.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                if(graczKolko) {
                    gracz.setText(String.valueOf(kolko));
                }
                else bot.setText((String.valueOf(kolko)));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                if(graczKolko){
                    bot.setText(String.valueOf(krzyzyk));
                }
                else gracz.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
        if(pole01.getText() != "" &&pole01.getText().equals(pole11.getText())&& pole01.getText().equals(pole21.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                if(graczKolko) {
                    gracz.setText(String.valueOf(kolko));
                }
                else bot.setText((String.valueOf(kolko)));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                if(graczKolko){
                    bot.setText(String.valueOf(krzyzyk));
                }
                else gracz.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
        if(pole02.getText() != "" &&pole02.getText().equals(pole12.getText())&& pole02.getText().equals(pole22.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                if(graczKolko) {
                    gracz.setText(String.valueOf(kolko));
                }
                else bot.setText((String.valueOf(kolko)));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                if(graczKolko){
                    bot.setText(String.valueOf(krzyzyk));
                }
                else gracz.setText(String.valueOf(krzyzyk));
            }
            return true;
        }
        if(pole00.getText() != "" &&pole00.getText().equals(pole11.getText())&& pole00.getText().equals(pole22.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                if(graczKolko) {
                    gracz.setText(String.valueOf(kolko));
                }
                else bot.setText((String.valueOf(kolko)));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                if(graczKolko){
                    bot.setText(String.valueOf(krzyzyk));
                }
                else gracz.setText(String.valueOf(krzyzyk));
            }
            return true;

        }
        if(pole02.getText() != "" &&pole02.getText().equals(pole11.getText())&& pole02.getText().equals(pole20.getText())) {
            if (kolkoPierwsze) {
                Toast.makeText(getApplicationContext(), "Kólko wygrywa", Toast.LENGTH_SHORT).show();
                kolko++;
                if(graczKolko) {
                    gracz.setText(String.valueOf(kolko));
                }
                else bot.setText((String.valueOf(kolko)));
            } else {
                Toast.makeText(getApplicationContext(), "Krzyżyk wygrywa", Toast.LENGTH_SHORT).show();
                krzyzyk++;
                if(graczKolko){
                    bot.setText(String.valueOf(krzyzyk));
                }
                else gracz.setText(String.valueOf(krzyzyk));
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
                kolkoPierwsze = false;
                if(!graczKolko) {
                    ruchBota();
                }
            }
            if(i == 2){
                Toast.makeText(getApplicationContext(),"Krzyżyk zaczyna",Toast.LENGTH_SHORT).show();
                kolkoPierwsze = true;
                if(graczKolko) {
                    ruchBota();
                }
            }
            pierwszaGra = false;
        }else if (kolkoPierwsze){
            kolkoPierwsze = false;
            Toast.makeText(getApplicationContext(),"Krzyżyk zaczyna",Toast.LENGTH_SHORT).show();
            if(graczKolko) {
                ruchBota();
            }
        } else {
            Toast.makeText(getApplicationContext(),"Kółko zaczyna",Toast.LENGTH_SHORT).show();
            kolkoPierwsze = true;
            if(!graczKolko) {
                ruchBota();
            }
        }
    }

    public void PowrotDGJE(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
