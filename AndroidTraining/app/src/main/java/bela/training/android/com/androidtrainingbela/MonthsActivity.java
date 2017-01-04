package bela.training.android.com.androidtrainingbela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MonthsActivity extends AppCompatActivity {
    private TextView monthName;
    private EditText month;
    private Button monthButton;
    private static HashMap<Integer, String> monthsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
        populateMonthsMap();

        monthName = (TextView) findViewById(R.id.monthName);
        month = (EditText) findViewById(R.id.month);
        monthButton = (Button) findViewById(R.id.monthsButton);

        monthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer selectedMonth = Integer.valueOf(month.getText().toString());
                String monthLabel = monthsMap.get(selectedMonth) != null ? monthsMap.get(selectedMonth): "INVALID MONTH";
                monthName.setText(monthLabel);
            }
        });

    }

    private void populateMonthsMap(){
        monthsMap = new HashMap<>();
        monthsMap.put(1,"ENERO");
        monthsMap.put(2,"FEBRERO");
        monthsMap.put(3,"MARZO");
        monthsMap.put(4,"ABRIL");
        monthsMap.put(5,"MAYO");
        monthsMap.put(6,"JUNIO");
        monthsMap.put(7,"JULIO");
        monthsMap.put(8,"AGOSTO");
        monthsMap.put(9,"SEPTIEMBRE");
        monthsMap.put(10,"OCTUBRE");
        monthsMap.put(11,"NOVIEMBRE");
        monthsMap.put(12,"DICIEMBRE");
    }
}
