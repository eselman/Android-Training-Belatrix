package bela.training.android.com.androidtrainingbela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText operator1;
    private EditText operator2;
    private Spinner operation;
    private String operationSymbol;
    private Button equalBtn;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        operator1 = (EditText)findViewById(R.id.operator1);
        operator2 = (EditText)findViewById(R.id.operator2);
        resultText = (TextView)findViewById(R.id.result);

        operation = (Spinner) findViewById(R.id.operation);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operations_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operation.setAdapter(adapter);
        operation.setOnItemSelectedListener(this);


        equalBtn = (Button) findViewById(R.id.equalBtn);
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Number result = 0;
                switch (operationSymbol) {
                    case "+":
                        result = Double.valueOf(operator1.getText().toString()) + Double.valueOf(operator2.getText().toString());
                        break;
                    case "-":
                        result = Double.valueOf(operator1.getText().toString()) - Double.valueOf(operator2.getText().toString());
                        break;
                    case "/":
                        result = Double.valueOf(operator1.getText().toString()) / Double.valueOf(operator2.getText().toString());
                        break;
                    case "*":
                        result = Double.valueOf(operator1.getText().toString()) * Double.valueOf(operator2.getText().toString());
                        break;
                }
                resultText.setText(result.toString());
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        operationSymbol = parent.getItemAtPosition(pos).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please select operator", Toast.LENGTH_LONG);
    }
}
