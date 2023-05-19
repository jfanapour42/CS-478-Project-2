package com.cs478.jordanfanapour.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    protected static final String EXTRA_RES_ID = "POS";

    protected static final String EXTRA_RES_URL = "URL";

    private ArrayList<String> carNames = new ArrayList<>(
            Arrays.asList("Audi R8", "BMW M3", "BMW Z4", "Mercedes-AMG GT", "Porsche 911",
                          "Rolls-Royce Phantom", "Ferrari 812 GTS", "Lamborghini Urus",
                          "Lamborghini Aventador", "Lamborghini Huracan Sterrato"));

    private ArrayList<Integer> mThumbIdsCars = new ArrayList<>(
            Arrays.asList(R.drawable.audi_r8, R.drawable.bmw_m3, R.drawable.bmw_z4,
                          R.drawable.mercedes_amg_gt, R.drawable.porsche_911,
                          R.drawable.rolls_royce_phantom, R.drawable.ferrari_812_gts,
                          R.drawable.lamborghini_urus, R.drawable.lamborghini_aventador,
                          R.drawable.lamborghini_huracan_sterrato));

    private ArrayList<String> carURLs = new ArrayList<>(
            Arrays.asList("https://www.audiusa.com/us/web/en/models/r8/r8-coupe/2023/overview.html",
                          "https://www.bmwusa.com/vehicles/m-models/m3-sedan/overview.html",
                          "https://www.bmwusa.com/vehicles/z4/roadster/core-models.html",
                          "https://www.mbusa.com/en/vehicles/class/amg-gt/coupe",
                          "https://www.porsche.com/usa/models/911/911-models/carrera/",
                          "https://www.rolls-roycemotorcars.com/en_US/showroom/phantom.html",
                          "https://www.ferrari.com/en-US/auto/812-gts",
                          "https://www.lamborghini.com/en-en/models/urus/urus-s",
                          "https://www.lamborghini.com/en-en/models/aventador/aventador-lp-780-4-ultimae",
                          "https://www.lamborghini.com/en-en/models/huracan/huracan-sterrato"));
    //(R.drawable.audi_r8, R.drawable.bmw_m3,
    // R.drawable.bmw_z4, R.drawable.mercedes_amg_gt, R.drawable.porsche_911,
    // R.drawable.rolls_royce_phantom, R.drawable.ferrari_812_gts, R.drawable.lamborghini_urus,
    // R.drawable.lamborghini_aventador, R.drawable.lamborghini_huracan_sterrato)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve GridView declare in layout file
        GridView gridview = findViewById(R.id.gridview);

        // Long presses on GridView gridview invoke Context Menu
        registerForContextMenu(gridview);

        // Create a new ImageAdapter and set it as the Adapter for this GridView
        gridview.setAdapter(new ImageAdapter(this, mThumbIdsCars, carNames));

        // Set an setOnItemClickListener on the GridView
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Create an Intent to start the ImageViewActivity
                Intent intent = new Intent(MainActivity.this,
                        ImageViewActivity.class);

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, (int) id);

                // Add the URL of the car's manufacturer to display as an Intent Extra
                intent.putExtra(EXTRA_RES_URL, carURLs.get(position));

                // Start the ImageViewActivity
                startActivity(intent);
            }
        });
    }

    // Create Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    // Process clicks on Context Menu Items
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        switch (item.getItemId()) {
            case R.id.addressItem:
                Intent i1 = new Intent(MainActivity.this, AddressListActivity.class);
                i1.putExtra(EXTRA_RES_ID, mThumbIdsCars.get(index));
                startActivity(i1);
                return true;
            case R.id.websiteItem:
                // create intent to go to website
                Intent i2 = new Intent();
                i2.setAction(Intent.ACTION_VIEW);
                i2.addCategory(Intent.CATEGORY_BROWSABLE);
                i2.setData(Uri.parse(carURLs.get(index)));
                startActivity(i2);
                return true;
            case R.id.imageItem:
                //Create an Intent to start the ImageViewActivity
                Intent i3 = new Intent(MainActivity.this, ImageViewActivity.class);
                i3.putExtra(EXTRA_RES_ID, mThumbIdsCars.get(index));
                i3.putExtra(EXTRA_RES_URL, carURLs.get(index));
                startActivity(i3);
                return true;
            default:
                return false;
        }
    }
}