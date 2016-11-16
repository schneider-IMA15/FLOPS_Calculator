package at.fh.swengb.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayAboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_about);

        Intent intent = getIntent();

        String message = intent.getStringExtra("resultOfCalc");
        TextView textView = (TextView) findViewById(R.id.textView5);

        textView.setText("This App was created as a Homework for SWENGB");
    }
}
