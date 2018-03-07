package com.iwave.navigation_drawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by user on 3/7/2018.
 */


public class TextActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_page);

        //gave a sample message in string format
        String Message = "welcome to new page";
        //giving the toast after the user enters into page
        Toast.makeText(getApplicationContext(), Message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {

        //it is used to return to main app
        super.onBackPressed();
        //animating is done for exiting this page
        overridePendingTransition(R.anim.bottom_to_top, R.anim.bottom_to_top);

    }
}
