package com.example.surjit.toolbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    Menu mMenu;
    Toolbar toolbar;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setTitle("My ToolBar");
        actionBar.setSubtitle("My Sub Title");
        actionBar.setLogo(R.mipmap.ic_launcher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem search = menu.findItem(R.id.search);
        searchView =  (SearchView) search.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(MainActivity.this, s,Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Toast.makeText(MainActivity.this, s,Toast.LENGTH_LONG).show();
                return false;
            }
        });

        mMenu = menu;

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(MainActivity.this, item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(MainActivity.this, item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case R.id.item3:
                Toast.makeText(MainActivity.this, item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case R.id.search:
                Toast.makeText(MainActivity.this, item.getTitle(),Toast.LENGTH_LONG).show();
                mMenu.removeItem(R.id.item1);
                mMenu.removeItem(R.id.item3);
                mMenu.removeItem(R.id.item2);
                break;
            default:
                Toast.makeText(MainActivity.this, "Error",Toast.LENGTH_LONG).show();
        }

        return true;
    }
}
