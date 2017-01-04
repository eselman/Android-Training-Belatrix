package bela.training.android.com.androidtrainingbela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonMonths;
    private Button buttonCalculator;
    private Button buttonLines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button Months.
        buttonMonths = (Button) findViewById(R.id.buttonMonths);
        buttonMonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monthsIntent = new Intent(MainActivity.this, MonthsActivity.class);
                startActivity(monthsIntent);
            }
        });

        // Button Calculator.
        buttonCalculator = (Button) findViewById(R.id.buttonCalculator);
        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calculatorIntent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(calculatorIntent);
            }
        });

        //Button Lines.
        buttonLines = (Button) findViewById(R.id.buttonLines);
        buttonLines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linesIntent = new Intent(MainActivity.this, LinesActivity.class);
                startActivity(linesIntent);
            }
        });
    }
}
