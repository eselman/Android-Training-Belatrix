package bela.training.android.com.imagesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FirstButtonActivity extends AppCompatActivity {
    private TextView firstButtonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_button);
        firstButtonText = (TextView) findViewById(R.id.button1Text);
        firstButtonText.setText("First Button Click");
    }
}
