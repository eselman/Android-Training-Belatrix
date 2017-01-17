package bela.training.android.com.imagesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextsActivity extends AppCompatActivity {
    private TextView imageText;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texts);

        imageText = (TextView) findViewById(R.id.imageText);
        imageText.setText(getIntent().getStringExtra("IMAGE_TEXT"));

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstButtonIntent = new Intent(TextsActivity.this, FirstButtonActivity.class);
                startActivity(firstButtonIntent);
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondButtonIntent = new Intent(TextsActivity.this, SecondButtonActivity.class);
                startActivity(secondButtonIntent);
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdButtonIntent = new Intent(TextsActivity.this, ThirdButtonActivity.class);
                startActivity(thirdButtonIntent);
            }
        });

    }
}
