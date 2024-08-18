package br.edu.FatecZL.atv01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etxSinicial;
    private EditText etxVelocidade;
    private EditText etxTempo;
    private Button btCalc;
    private TextView txViewRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etxSinicial = findViewById(R.id.etxSinicial);
        etxSinicial.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etxVelocidade = findViewById(R.id.etxVelocidade);
        etxVelocidade.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etxTempo = findViewById(R.id.etxTempo);
        etxTempo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txViewRes = findViewById(R.id.txViewRes);
        txViewRes.setText(View.TEXT_ALIGNMENT_CENTER);
        btCalc = findViewById(R.id.btCalc);

        btCalc.setOnClickListener(op -> Calc());
    }

    private void Calc()
    {
        float Sinicial = Float.parseFloat(etxSinicial.getText().toString());
        float veloc = Float.parseFloat(etxVelocidade.getText().toString());
        float temp = Float.parseFloat(etxTempo.getText().toString());
        float Sfinal = Sinicial + veloc * temp;

        String res = getString(R.string.S_final) + Sfinal + " m";
        txViewRes.setText(res);
    }
}