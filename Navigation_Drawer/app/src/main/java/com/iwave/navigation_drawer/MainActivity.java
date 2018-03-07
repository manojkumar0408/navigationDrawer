package com.iwave.navigation_drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Intent mGotoEmail;
    Intent mTextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mTextView=findViewById(R.id.contentTextView);

        //finding the toolBar using is id
        final Toolbar mToolbar = findViewById(R.id.toolbarMain);
        //finding drawerLayout by its id and giving mdrawer
        DrawerLayout mDrawer = findViewById(R.id.mainActivityDrawerLayout);
        //invoking the emailIcon by its ID
        FloatingActionButton emailIcon = findViewById(R.id.emailIcon);
        //setted a onclick listener for email icon
        emailIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirection to the goOther method in mainActivity
                goOther();
            }

            private void goOther() {
                //getiing context from the java class
                mGotoEmail = new Intent(getApplicationContext(), EmailActivity.class);
                //animating gor animation enter ans animation leave
                overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                //starting the activity and implement this activity in manifest file for accessing
                startActivity(mGotoEmail);
            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirection to the goOther method in mainActivity
                goOtherPage();
            }

            private void goOtherPage() {
                //getiing context from the java class
                mTextPage = new Intent(getApplicationContext(),TextActivity.class);
                //animating gor animation enter ans animation leave
                overridePendingTransition(R.anim.top_to_bottom, R.anim.bottom_to_top);
                //starting the activity and implement this activity in manifest file for accessing
                startActivity(mTextPage);
            }
        });


        /*ActionBarDrawerToggle is used to tie together the drawer
        layout and actionBar to implement the design for
        navigation drawers*/
        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar,
                R.string.navigationDrawerOpen, R.string.navigationDrawerClose);
        //or "navigation_drawer_open",,"navigation_drawer_close"

        //adding the specified listener to list of listeners
        mDrawer.addDrawerListener(mToggle);
        /*It will synchronize the changed icons state
        which depends on drawer layout
        if u remove syncstate in this code you cant find it
        has the navigation drawer or not(the 3lines icon wil vanish)
         */
        mToggle.syncState();
        //Finding NavigationView from its layout by its id
        NavigationView mNavigationView = findViewById(R.id.navigationViewMainLayout);
        //it acts a listener for handling the items in Navigation view
        mNavigationView.setNavigationItemSelectedListener(this);

    }

    /*onBackPressed method is added for user convinience
    if user presses the back button on his mobile this
    method works(Stays in app if drawer is open
    else exits app if drawer is closed
     */
    @Override
    public void onBackPressed() {
        //finding the drawerlayout by its id
        DrawerLayout mDrawer = findViewById(R.id.mainActivityDrawerLayout);
        //if drawer is open
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            //close the drawer and continue with operations in app
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            //exit the app because drawer is closed
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Storing the ids of all items into the variable id
        int id = item.getItemId();

        //ifelse is used to make sure only one items works at one time
        if (id == R.id.navItemCamera) {

            //gives the toast that you clicked on camera
            Toast.makeText(this, "you clicked on camera", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.navItemGallery) {
            //gives the toast that you clicked on gallery
            Toast.makeText(this, "you clicked on Gallery", Toast.LENGTH_SHORT).show();
            //add or remove images in gallery
        } else if (id == R.id.navItemSettings) {
            //gives the toast that you clicked on settings
            Toast.makeText(this, "you clicked on settings", Toast.LENGTH_SHORT).show();
            //do if any settings required
        } else if (id == R.id.navItemPictures) {
            //gives the toast that you clicked on pictures
            Toast.makeText(this, "you clicked on pictures", Toast.LENGTH_SHORT).show();
            //add or remove pictures
        } else if (id == R.id.navItemAdvanced) {
            //gives the toast that you clicked on advnaced
            Toast.makeText(this, "you clicked on advanced", Toast.LENGTH_SHORT).show();
            //advanced settingss
        } else if (id == R.id.navItemSend) {
            //gives the toast that you clicked on send
            Toast.makeText(this, "you clicked on send", Toast.LENGTH_SHORT).show();
            //send req for communication
        } else if (id == R.id.navItemShare) {
            //gives the toast that you clicked on share
            Toast.makeText(this, "you clicked on share", Toast.LENGTH_SHORT).show();
            //share to social websites
        }
        //finding the drawerlayout by its id
        DrawerLayout mDrawer = findViewById(R.id.mainActivityDrawerLayout);
        /* Gravity compat is added at this place because
        if you have clicked on any item drawer will be closed
        and it will redirect to app ...*/
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
