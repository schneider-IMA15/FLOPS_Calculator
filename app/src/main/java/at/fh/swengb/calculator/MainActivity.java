package at.fh.swengb.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextClock;
    private EditText editTextTUs;
    private EditText editTextROPs;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //R = Ressources Class, "Allwissende Müllhalde", generated by compiler

        editTextClock = (EditText)findViewById(R.id.editTextClock);
        editTextTUs = (EditText)findViewById(R.id.editTextTUs);
        editTextROPs = (EditText)findViewById(R.id.editTextROPs);
        resultView = (TextView)findViewById(R.id.textViewResult);
    }

    public void calc (View view){

        String clockString = editTextClock.getText().toString();
        String TUsString = editTextTUs.getText().toString();
        String ROPsString = editTextROPs.getText().toString();

        double clock = 0;
        double TUs = 0;
        double ROPs = 0;

        double result = 0;

        try {
            clock = Double.parseDouble(clockString);
            TUs = Double.parseDouble(TUsString);
            ROPs = Double.parseDouble(ROPsString);

            if (clock != 0 && TUs != 0 && ROPs != 0) {
                result = clock * TUs * ROPs / 1000;
                resultView.setText("Your GPU is performing " + result + " GFLOPS");
            }
            else {
                resultView.setText("All 3 values must not be 0");
            }
        } catch (NumberFormatException e) {
            resultView.setText("Oh oh... (you have to provide all 3 values)");
            e.printStackTrace();
        }
    }

    public void showAbout(View view){
        Intent intent = new Intent(this, DisplayAboutActivity.class);
        String message = resultView.getText().toString();
        intent.putExtra("resultOfCalc", message);
        startActivity(intent);
    }
}