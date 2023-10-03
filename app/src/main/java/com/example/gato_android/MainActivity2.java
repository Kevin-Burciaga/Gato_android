package com.example.gato_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gato_android.R;

public class MainActivity2 extends AppCompatActivity  implements View.OnClickListener {
    Button br, bs;
    int [] gato=new  int[9];
    int aleatorio=0, tiradas=0;
    ImageView i1, i2,i3, i4, i5, i6, i7, i8, i9;
    boolean ganar=false, ganar2=false, notirar=false;
    private static int j1=0, j2=0;
    TextView p1, p2;

    int jugador=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        i1 = (ImageView) findViewById(R.id.i1);
        i2 = (ImageView) findViewById(R.id.i2);
        i3 = (ImageView) findViewById(R.id.i3);
        i4 = (ImageView) findViewById(R.id.i4);
        i5 = (ImageView) findViewById(R.id.i5);
        i6 = (ImageView) findViewById(R.id.i6);
        i7 = (ImageView) findViewById(R.id.i7);
        i8 = (ImageView) findViewById(R.id.i8);
        i9 = (ImageView) findViewById(R.id.i9);
        p1 = (TextView) findViewById(R.id.player1);
        p2 = (TextView) findViewById(R.id.player2);
        for (int i=0;i <= 8; i++){
            gato[i]=0;
        }
        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
        i5.setOnClickListener(this);
        i6.setOnClickListener(this);
        i7.setOnClickListener(this);
        i8.setOnClickListener(this);
        i9.setOnClickListener(this);
        borrar();
        aleatorio=(int)(8*Math.random())+1;
        actulizarM();
        bs=(Button) findViewById(R.id.btnS);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        br=(Button) findViewById(R.id.btnR);
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reiniciar(MainActivity2.this);
            }
        });
    }

    @Override
    public void onClick(View v) {
        boolean tiro=false;
        int tag = Integer.parseInt(v.getTag().toString());
        switch (tag){
            case 1:
                if (gato[0]==0 && jugador==1){
                    i1.setImageResource(R.drawable.x);
                    gato[0]=1;
                    tiro=true;
                }
                if (gato[0]==0 && jugador==2){
                    i1.setImageResource(R.drawable.oo);
                    gato[0]=2;
                    tiro=true;
                }
                break;
            case 2:
                if (gato[1]==0 && jugador==1){
                    i2.setImageResource(R.drawable.x);
                    gato[1]=1;
                    tiro=true;
                }
                if (gato[1]==0 && jugador==2){
                    i2.setImageResource(R.drawable.oo);
                    gato[1]=2;
                    tiro=true;
                }
                break;
            case 3:
                if (gato[2]==0 && jugador==1){
                    i3.setImageResource(R.drawable.x);
                    gato[2]=1;
                    tiro=true;
                }
                if (gato[2]==0 && jugador==2){
                    i3.setImageResource(R.drawable.oo);
                    gato[2]=2;
                    tiro=true;
                }
                break;
            case 4:
                if (gato[3]==0 && jugador==1){
                    i4.setImageResource(R.drawable.x);
                    gato[3]=1;
                    tiro=true;
                }
                if (gato[3]==0 && jugador==2){
                    i4.setImageResource(R.drawable.oo);
                    gato[3]=2;
                    tiro=true;
                }
                break;
            case 5:
                if (gato[4]==0 && jugador==1){
                    i5.setImageResource(R.drawable.x);
                    gato[4]=1;
                    tiro=true;
                }
                if (gato[4]==0 && jugador==2){
                    i5.setImageResource(R.drawable.oo);
                    gato[4]=2;
                    tiro=true;
                }
                break;
            case 6:
                if (gato[5]==0 && jugador==1){
                    i6.setImageResource(R.drawable.x);
                    gato[5]=1;
                    tiro=true;
                }
                if (gato[5]==0 && jugador==2){
                    i6.setImageResource(R.drawable.oo);
                    gato[5]=2;
                    tiro=true;
                }
                break;
            case 7:
                if (gato[6]==0 && jugador==1){
                    i7.setImageResource(R.drawable.x);
                    gato[6]=1;
                    tiro=true;
                }
                if (gato[6]==0 && jugador==2){
                    i7.setImageResource(R.drawable.oo);
                    gato[6]=2;
                    tiro=true;
                }
                break;
            case 8:
                if (gato[7]==0 && jugador==1){
                    i8.setImageResource(R.drawable.x);
                    gato[7]=1;
                    tiro=true;
                }
                if (gato[7]==0 && jugador==2){
                    i8.setImageResource(R.drawable.oo);
                    gato[7]=2;
                    tiro=true;
                }
                break;

            case 9:
                if (gato[8]==0 && jugador==1){
                    i9.setImageResource(R.drawable.x);
                    gato[8]=1;
                    tiro=true;
                }
                if (gato[8]==0 && jugador==2){
                    i9.setImageResource(R.drawable.oo);
                    gato[8]=2;
                    tiro=true;
                }
                break;
        }

        if (tiro==true){
            if (jugador==1){
                jugador=2;
            }else {
                jugador=1;
            }
        }
        tiradas++;
        if (Ganador(1)) {
            ganar = true;
        }
        if (Ganador(2)) {
            ganar2 = true;
        }
        checa();

    }

    public boolean Ganador(int jugador) {
        int[][] combinacionesGanadoras = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] combinacion : combinacionesGanadoras) {
            if (gato[combinacion[0]] == jugador &&
                    gato[combinacion[1]] == jugador &&
                    gato[combinacion[2]] == jugador) {
                return true;
            }
        }

        return false;
    }


    public void borrar(){
        i1.setImageResource(R.drawable.cruz);
        i2.setImageResource(R.drawable.cruz);
        i3.setImageResource(R.drawable.cruz);
        i4.setImageResource(R.drawable.cruz);
        i5.setImageResource(R.drawable.cruz);
        i6.setImageResource(R.drawable.cruz);
        i7.setImageResource(R.drawable.cruz);
        i8.setImageResource(R.drawable.cruz);
        i9.setImageResource(R.drawable.cruz);
        for (int i=0;i<=8;i++){
            gato[i]=0;
            ganar=false;
            ganar2=false;
            tiradas=0;
            aleatorio=(int) (8*Math.random())+1;
        }
    }

    public void actulizarM(){
        p1.setText("");
        p2.setText("");
        String text1=String.valueOf(j1);
        String text2=String.valueOf(j2);
        p1.setText(text1);
        p2.setText(text2);
    }

    public void checa(){
        if (ganar==true){
            Toast toast=Toast.makeText(this,"Gano el jugador 1",Toast.LENGTH_SHORT);
            toast.show();
            j1+=1;
        }
        if (ganar2==true){
            Toast toast=Toast.makeText(this,"Gano el jugador 2",Toast.LENGTH_SHORT);
            toast.show();
            j2+=1;
        }
        if (tiradas==9&&ganar==false&&ganar2==false){
            Toast toast=Toast.makeText(this,"Empate",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /*public void quiengana(){
        if (gato[0]==1 && gato[1]==1 && gato[2]==1){
            ganar=true;
        }
        if (gato[3]==1 && gato[4]==1 && gato[5]==1){
            ganar=true;
        }
        if (gato[6]==1 && gato[7]==1 && gato[8]==1){
            ganar=true;
        }
        if (gato[0]==1 && gato[3]==1 && gato[6]==1){
            ganar=true;
        }
        if (gato[1]==1 && gato[4]==1 && gato[7]==1){
            ganar=true;
        }
        if (gato[2]==1 && gato[5]==1 && gato[8]==1){
            ganar=true;
        }
        if (gato[0]==1 && gato[4]==1 && gato[8]==1){
            ganar=true;
        }
        if (gato[2]==1 && gato[4]==1 && gato[6]==1){
            ganar=true;
        }
        //caso 2
        if (gato[0]==2 && gato[1]==2 && gato[2]==2){
            ganar2=true;
        }
        if (gato[3]==2 && gato[4]==2 && gato[5]==2){
            ganar2=true;
        }
        if (gato[6]==2 && gato[7]==2 && gato[8]==2){
            ganar2=true;
        }
        if (gato[0]==2 && gato[3]==2 && gato[6]==2){
            ganar2=true;
        }
        if (gato[1]==2 && gato[4]==2 && gato[7]==2){
            ganar2=true;
        }
        if (gato[2]==2 && gato[5]==2 && gato[8]==2){
            ganar2=true;
        }
        if (gato[0]==2 && gato[4]==2 && gato[8]==2){
            ganar2=true;
        }
        if (gato[2]==2 && gato[4]==2 && gato[6]==2){
            ganar2=true;
        }
    }*/
public void reiniciar(Activity activity){
    Intent i=new Intent();
    i.setClass(activity,activity.getClass());
    activity.startActivity(i);
    activity.finish();
}
}