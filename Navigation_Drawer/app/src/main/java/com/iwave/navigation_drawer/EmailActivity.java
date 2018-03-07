package com.iwave.navigation_drawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by user on 3/7/2018.
 */

public class EmailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_activity);

        //gave a sample message in string format
        String Message = "enter email";
        //giving the toast after the user enters into page
        Toast.makeText(getApplicationContext(), Message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {

        //it is used to return to main app
        super.onBackPressed();
        //animating is done for exiting this page
        overridePendingTransition(R.anim.right_to_left, R.anim.left_to_right);

    }
}
