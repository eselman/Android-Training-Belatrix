package bela.training.android.com.imagesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondButtonActivity extends AppCompatActivity {
    private TextView secondButtonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_button);
        secondButtonText = (TextView) findViewById(R.id.button2Text);
        secondButtonText.setText("Second Button Click");
    }
}
