package com.cs478.jordanfanapour.project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AddressListActivity extends Activity {
    private HashMap<Integer, ArrayList<DealershipTuple>> dealershipMap = new HashMap<>();

    /* ***List of dealersips***
    Lamborghini Gold Coast:
    834 N Rush St, Chicago, IL 60611

    Lamborghini Downers Grove:
    330 Ogden Ave, Downers Grove, IL 60515

    Ferrari Lake Forest:
    990 N Shore Dr, Lake Bluff, IL 60044

    Continental AutoSports Ferrari:
    420 E Ogden Ave, Hinsdale, IL 60521

    Mercedes-Benz of Naperville:
    1569 W Ogden Ave, Naperville, IL 60540

    Mercedes-Benz of Westmont:
    200 E Ogden Ave, Westmont, IL 60559

    Rolls-Royce Motor Cars Gold Coast:
    834 N Rush St, Chicago, IL 60611

    Rolls-Royce Motor Cars Northbrook:
    100 Skokie Blvd, Northbrook, IL 60062

    Audi Hoffman Estates:
    1200 W Golf Rd, Hoffman Estates, IL 60169

    Fletcher Jones Audi:
    1523 W North Ave, Chicago, IL 60642

    Elmhurst BMW:
    500 W Lake St, Elmhurst, IL 60126

    BMW of Barrington:
    1475 Barrington Rd, Barrington, IL 60010
     */

    private void createDealershipMap() {
        DealershipTuple t1 = new DealershipTuple();
        DealershipTuple t2 = new DealershipTuple();
        DealershipTuple t3 = new DealershipTuple();
        DealershipTuple t4 = new DealershipTuple();
        DealershipTuple t5 = new DealershipTuple();
        DealershipTuple t6 = new DealershipTuple();
        DealershipTuple t7 = new DealershipTuple();
        DealershipTuple t8 = new DealershipTuple();
        DealershipTuple t9 = new DealershipTuple();
        DealershipTuple t10 = new DealershipTuple();
        DealershipTuple t11 = new DealershipTuple();
        DealershipTuple t12 = new DealershipTuple();
        DealershipTuple t13 = new DealershipTuple();
        DealershipTuple t14 = new DealershipTuple();
        t1.name = "Lamborghini Gold Coast:";
        t1.address = "834 N Rush St, Chicago, IL 60611";

        t2.name = "Lamborghini Downers Grove:";
        t2.address = "330 Ogden Ave, Downers Grove, IL 60515";

        t3.name = "Ferrari Lake Forest:";
        t3.address = "990 N Shore Dr, Lake Bluff, IL 60044";

        t4.name = "Continental AutoSports Ferrari:";
        t4.address = "420 E Ogden Ave, Hinsdale, IL 60521";

        t5.name = "Mercedes-Benz of Naperville:";
        t5.address = "1569 W Ogden Ave, Naperville, IL 60540";

        t6.name = "Mercedes-Benz of Westmont:";
        t6.address = "200 E Ogden Ave, Westmont, IL 60559";

        t7.name = "Rolls-Royce Motor Cars Gold Coast:";
        t7.address = "834 N Rush St, Chicago, IL 60611";

        t8.name = "Rolls-Royce Motor Cars Northbrook:";
        t8.address = "100 Skokie Blvd, Northbrook, IL 60062";

        t9.name = "Audi Hoffman Estates:";
        t9.address = "1200 W Golf Rd, Hoffman Estates, IL 60169";

        t10.name = "Fletcher Jones Audi:";
        t10.address = "1523 W North Ave, Chicago, IL 60642";

        t11.name = "Elmhurst BMW:";
        t11.address = "500 W Lake St, Elmhurst, IL 60126";

        t12.name = "BMW of Barrington:";
        t12.address = "1475 Barrington Rd, Barrington, IL 60010";

        t13.name = "Porsche Downtown Chicago:";
        t13.address = "570 W Monroe St, Chicago, IL 60661";

        t14.name = "Porsche Lincolnwood:";
        t14.address = "7101 Lincoln Ave, Lincolnwood, IL 60712";

        dealershipMap.put(R.drawable.audi_r8, new ArrayList<DealershipTuple>(Arrays.asList(t9, t10)));
        dealershipMap.put(R.drawable.bmw_m3, new ArrayList<DealershipTuple>(Arrays.asList(t11, t12)));
        dealershipMap.put(R.drawable.bmw_z4, new ArrayList<DealershipTuple>(Arrays.asList(t11, t12)));
        dealershipMap.put(R.drawable.mercedes_amg_gt, new ArrayList<DealershipTuple>(Arrays.asList(t5, t6)));
        dealershipMap.put(R.drawable.porsche_911, new ArrayList<DealershipTuple>(Arrays.asList(t13, t14)));
        dealershipMap.put(R.drawable.rolls_royce_phantom, new ArrayList<DealershipTuple>(Arrays.asList(t7, t8)));
        dealershipMap.put(R.drawable.ferrari_812_gts, new ArrayList<DealershipTuple>(Arrays.asList(t3, t4)));
        dealershipMap.put(R.drawable.lamborghini_urus, new ArrayList<DealershipTuple>(Arrays.asList(t1, t2)));
        dealershipMap.put(R.drawable.lamborghini_aventador, new ArrayList<DealershipTuple>(Arrays.asList(t1, t2)));
        dealershipMap.put(R.drawable.lamborghini_huracan_sterrato, new ArrayList<DealershipTuple>(Arrays.asList(t1, t2)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_list);
        // create dealership map
        createDealershipMap();
        // get address list
        ListView addressView = (ListView) findViewById(R.id.addressList);
        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        int carId = intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0);
        ArrayList<DealershipTuple> dealershipList = dealershipMap.get(carId);

        ArrayList<String> dealerShip = new ArrayList<>();
        for (DealershipTuple d : dealershipList) {
            dealerShip.add(d.name + "\n" + d.address);
        }
        // on the below line we are initializing the adapter for our list view.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dealerShip);

        // on below line we are setting adapter for our list view.
        addressView.setAdapter(adapter);
    }

    private class DealershipTuple{
        public String name;
        public String address;
    }
}