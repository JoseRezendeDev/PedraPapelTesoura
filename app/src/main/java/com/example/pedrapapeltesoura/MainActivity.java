package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView pedra;
    private ImageView papel;
    private ImageView tesoura;
    private ImageView imgVoce;
    private ImageView imgApp;
    private TextView voce;
    private TextView app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pedra = findViewById(R.id.pedra);
        papel = findViewById(R.id.papel);
        tesoura = findViewById(R.id.tesoura);
        imgVoce = findViewById(R.id.imgVoce);
        imgApp = findViewById(R.id.imgApp);
        voce = findViewById(R.id.voce);
        app = findViewById(R.id.app);

        PPTListener pptListener = new PPTListener();

        pedra.setOnClickListener(pptListener);
        papel.setOnClickListener(pptListener);
        tesoura.setOnClickListener(pptListener);

    }

    private class PPTListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ImageView imagem = (ImageView) v;

            switch (imagem.getId()){
                case R.id.pedra:
                    voce.setText("Pedra");
                    imgVoce.setImageResource(R.drawable.pedra);
                    break;
                case R.id.papel:
                    voce.setText("Papel");
                    imgVoce.setImageResource(R.drawable.papel);
                    break;
                case R.id.tesoura:
                    voce.setText("Tesoura");
                    imgVoce.setImageResource(R.drawable.tesoura);
                    break;
            }

            Random r = new Random();
            int n = r.nextInt((2 - 0) + 1) + 0;

            switch (n) {
                case 0:
                    app.setText("Pedra");
                    imgApp.setImageResource(R.drawable.pedra);
                    break;
                case 1:
                    app.setText("Papel");
                    imgApp.setImageResource(R.drawable.papel);
                    break;
                case 2:
                    app.setText("Tesoura");
                    imgApp.setImageResource(R.drawable.tesoura);
                    break;
            }

            String result = "";
            if (voce.getText().equals("Pedra")){
                if (app.getText().equals("Pedra"))
                    result = "Empate";
                else if (app.getText().equals("Papel"))
                    result = "Você perdeu";
                else
                    result = "Você ganhou";
            }
            else if (voce.getText().equals("Papel")){
                if (app.getText().equals("Pedra"))
                    result = "Você ganhou";
                else if (app.getText().equals("Papel"))
                    result = "Empatou";
                else
                    result = "Você perdeu";
            }
            else if (voce.getText().equals("Tesoura")){
                if (app.getText().equals("Pedra"))
                    result = "Você perdeu";
                else if (app.getText().equals("Papel"))
                    result = "Você ganhou";
                else
                    result = "Empate";
            }

            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }
}
