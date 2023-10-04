package com.example.gato_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
TextView p1, p2, p3, ga;
Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recibird();
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void recibird(){
        Bundle re = getIntent().getExtras();
        int pu1 = re.getInt("Puntaje1");
        int pu2 = re.getInt("Puntaje2");
        int pu3 = re.getInt("Empate");
        p1 = (TextView) findViewById(R.id.p1);
        p1.setText(String.valueOf(pu1));
        p2 = (TextView) findViewById(R.id.p2);
        p2.setText(String.valueOf(pu2));
        p3 = (TextView) findViewById(R.id.p3);
        p3.setText(String.valueOf(pu3));

        ga = (TextView) findViewById(R.id.ga);
        if (pu1 > pu2) {
            ga.setText("Jugador 1");
        } else if (pu2 > pu1) {
            ga.setText("Jugador 2");
        } else {
            ga.setText("Empate");
        }
    }

}