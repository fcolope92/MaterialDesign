package com.example.android.materialdesign.Activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.materialdesign.Adapter.AdapterCategories;
import com.example.android.materialdesign.Class.Category;
import com.example.android.materialdesign.Class.ImageConverter;
import com.example.android.materialdesign.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private RecyclerView recyclerView;
    private LinearLayoutManager llm;
    private boolean changeView;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeView = false;

        /************** ACTION BAR **************/
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        insertUserIcon();

        setupNavigationDrawerContent(navigationView);

        /*************** RECYCLER VIEW ****************/
        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        AdapterCategories adapter = new AdapterCategories(initializeCategories());
        recyclerView.setAdapter(adapter);

    }


    private void insertUserIcon() {
        View header = LayoutInflater.from(this).inflate(R.layout.navigation_drawer_header, null);
        navigationView.addHeaderView(header);
        ImageView ivUserPhoto = (ImageView) header.findViewById(R.id.ivUserPhoto);

        Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.perfil);
        icon = Bitmap.createScaledBitmap(icon, 128, 128, true);
        Bitmap bm = ImageConverter.getRoundedCornerBitmap(icon, 1000);
        ivUserPhoto.setImageBitmap(bm);
    }



    private ArrayList<Category> initializeCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Floating Action Button", "Floating Action Button Floating Action Button Floating Action Button Floating Action Button"));
        categories.add(new Category("Floating Action Button", "Floating Action Button"));
        categories.add(new Category("Floating Action Button", "Floating Action Button Floating Action Button Floating Action Button Floating Action Button"));
        categories.add(new Category("Floating Action Button", "Floating Action Button Floating Action Button Floating Action Button Floating Action Button"));
        categories.add(new Category("Floating Action Button", "Floating Action Button"));
        categories.add(new Category("Floating Action Button", "Floating Action Button Floating Action Button Floating Action Button Floating Action Button"));
        categories.add(new Category("Floating Action Button", "Floating Action Button Floating Action Button Floating Action Button Floating Action Button"));
        categories.add(new Category("Floating Action Button", "Floating Action Button"));
        categories.add(new Category("Floating Action Button", "Floating Action Button"));

        return categories;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.changeView:
                if (!changeView) {
                    item.setIcon(R.drawable.ic_view_agenda_white_24dp);
                    StaggeredGridLayoutManager gridLayoutManager =
                            new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    changeView = true;
                } else {
                    item.setIcon(R.drawable.ic_dashboard_white_24dp);
                    llm = new LinearLayoutManager(this);
                    recyclerView.setLayoutManager(llm);
                    changeView = false;
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_inbox:
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item_navigation_drawer_starred:
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item_navigation_drawer_sent_mail:
                                menuItem.setChecked(true);
                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_drafts:
                                menuItem.setChecked(true);
                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_settings:
                                menuItem.setChecked(true);
                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_help_and_feedback:
                                menuItem.setChecked(true);
                                Toast.makeText(MainActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                        }
                        return true;
                    }
                });
    }
}
