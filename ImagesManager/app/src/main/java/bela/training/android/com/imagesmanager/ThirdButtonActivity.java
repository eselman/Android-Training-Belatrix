package bela.training.android.com.imagesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdButtonActivity extends AppCompatActivity {

    private TextView thirdButtonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_button);
        thirdButtonText = (TextView) findViewById(R.id.button2Text);
        thirdButtonText.setText("Third Button Click");
    }
}
