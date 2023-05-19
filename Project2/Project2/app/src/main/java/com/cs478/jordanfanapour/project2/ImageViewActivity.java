package com.cs478.jordanfanapour.project2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Make a new Button
        ImageButton imageBtn = new ImageButton(getApplicationContext());

        imageBtn.setImageResource(intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0));

        imageBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse(intent.getStringExtra(MainActivity.EXTRA_RES_URL)));
                startActivity(i);
            }
        });

        setContentView(imageBtn);
    }
}