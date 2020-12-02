package com.example.pratica04_t1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText peso = findViewById(R.id.editpeso);
        EditText sexo = findViewById(R.id.editsexo);
        EditText copos = findViewById(R.id.editcopos);
        EditText jejum = findViewById(R.id.editjejum);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent("ACAO_DESEJADA");
                it.putExtra("peso",Double.valueOf(peso.getText().toString()));
                it.putExtra("sexo",sexo.getText().toString());
                it.putExtra("copos",Integer.valueOf(copos.getText().toString()));
                it.putExtra("jejum",jejum.getText().toString());
                startActivityForResult(it,10);
            }
        });
    }
    @Override
    protected void onActivityResult(int codigoRequisicao, int codigoResultado, Intent it) {

        super.onActivityResult(codigoRequisicao, codigoResultado, it);
        Double resultado = it.getDoubleExtra("taxa",0);
        String alcoolizado = it.getStringExtra("alcool");
        String result = resultado.toString();
        Toast.makeText(this,"Taxa de Alcoolemia : " + result +  "\n" + "Classificacao : " + alcoolizado,Toast.LENGTH_LONG ).show();
    }
}