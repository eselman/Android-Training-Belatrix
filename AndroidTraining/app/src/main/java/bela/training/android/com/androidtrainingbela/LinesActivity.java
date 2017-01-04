package bela.training.android.com.androidtrainingbela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class LinesActivity extends AppCompatActivity {

    private EditText numberOfLines;
    private TextView lines;
    private Button linesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines);

        numberOfLines =  (EditText) findViewById(R.id.numberOfLines);
        lines =  (TextView) findViewById(R.id.lines);
        linesButton =  (Button) findViewById(R.id.linesBtn);
        linesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BigDecimal linesNumber = new BigDecimal(numberOfLines.getText().toString());
                if (linesNumber != null && linesNumber != BigDecimal.ZERO) {
                    StringBuilder linesStr = new StringBuilder("");
                    for(int i=0; i < linesNumber.intValue(); i++) {
                        linesStr.append("Line " + (i + 1) + "\n");
                    }
                    lines.setText(linesStr);
                }
            }
        });
    }
}
