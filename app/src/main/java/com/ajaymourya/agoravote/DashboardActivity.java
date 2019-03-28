package com.ajaymourya.agoravote;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class DashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

        drawerLayout = findViewById(R.id.drawer_layout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_logout:
                intent();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void intent() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void Total(View view) {

        Intent intent = new Intent(this, ElectionsActivity.class);
        intent.putExtra("TARGET_FRAGMENT", 0);
        startActivity(intent);
    }

    public void Pending(View view) {
        Intent intent = new Intent(this, ElectionsActivity.class);
        intent.putExtra("TARGET_FRAGMENT", 1);
        startActivity(intent);
    }

    public void Active(View view) {
        Intent intent = new Intent(this, ElectionsActivity.class);
        intent.putExtra("TARGET_FRAGMENT", 2);
        startActivity(intent);
    }

    public void Finished(View view) {
        Intent intent = new Intent(this, ElectionsActivity.class);
        intent.putExtra("TARGET_FRAGMENT", 3);
        startActivity(intent);
    }
}
