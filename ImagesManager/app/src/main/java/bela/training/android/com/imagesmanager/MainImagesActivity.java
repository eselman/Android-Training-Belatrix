package bela.training.android.com.imagesmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import bela.training.android.com.imagesmanager.adapters.AnimalsListAdapter;
import bela.training.android.com.imagesmanager.services.ImageDownloaderService;

public class MainImagesActivity extends AppCompatActivity {

    private ListView animalsList;
    private EditText downloadUrl;
    private Button downloadButton;

    // Create the image receiver.
    private BroadcastReceiver imageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String imagePath = intent.getStringExtra("IMAGE_PATH");
            ImageView image = (ImageView) findViewById(R.id.downloadImage);

            if (imagePath != null && !imagePath.isEmpty()) {
                Bitmap imageBitmap = BitmapFactory.decodeFile(imagePath);
                if (imageBitmap != null) {
                    image.setImageBitmap(imageBitmap);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_images);

        List<String> images = new ArrayList<>();

        for (int i=1; i<= 10; i++) {
            images.add("image"+i);
        }

        ListAdapter adapter = new AnimalsListAdapter(this,
                R.layout.image_layout,images);
        animalsList = (ListView) findViewById(R.id.animalsList);
        animalsList.setAdapter(adapter);
        animalsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainImagesActivity.this, TextsActivity.class);
                String imageText = "Selected Image at position: " + (position + 1);
                intent.putExtra("IMAGE_TEXT", imageText);
                startActivity(intent);
            }
        });

        LocalBroadcastManager.getInstance(this).registerReceiver(imageReceiver, new IntentFilter("download-image"));

        downloadUrl = (EditText)findViewById(R.id.editText);
        downloadButton = (Button)findViewById(R.id.downloadButton);

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = downloadUrl.getText().toString();
                if (url != null && !url.isEmpty()) {
                    Intent imageDownloaderIntent = new Intent(MainImagesActivity.this, ImageDownloaderService.class);
                    imageDownloaderIntent.putExtra("IMAGE_URL", url);
                    MainImagesActivity.this.startService(imageDownloaderIntent);
                }
            }
        });

    }
}




