package com.mcondle.giffy.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.mcondle.giffy.R;

public class GifActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private BottomNavigationView navMenu;
    private RelativeLayout contentView;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initUi();
        setupNavMenu();
        setupAdapters();
    }

    private void initUi() {
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        contentView = (RelativeLayout) findViewById(R.id.content_main);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    private void setupNavMenu() {
        navMenu = (BottomNavigationView) findViewById(R.id.nav_view);
        navMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.gif_grid_menu:
                        viewPager.setCurrentItem(0, true);
                        return true;
                    case R.id.sticker_list_menu:
                        viewPager.setCurrentItem(1, true);
                        return true;
                    case R.id.random_gif_menu:
                        viewPager.setCurrentItem(2, true);
                        return true;
                }
                return false;
            }
        });
    }

    private void setupAdapters() {
        viewPager.setAdapter(new GifFragmentPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //no-op
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navMenu.setSelectedItemId(R.id.gif_grid_menu);
                        break;
                    case 1:
                        navMenu.setSelectedItemId(R.id.sticker_list_menu);
                        break;
                    case 2:
                        navMenu.setSelectedItemId(R.id.random_gif_menu);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //no-op
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Snackbar.make(contentView, "Settings not yet supported", Snackbar.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchDetailView(String url) {
        Intent intent = new Intent(this, GifWebViewActivity.class);
        intent.putExtra(GifWebViewActivity.KEY_GIF_URL, url);
        startActivity(intent);
    }

    public void showLoading(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    public void showErrorDialog() {
        Snackbar.make(contentView, "Error fetching Gifs", Snackbar.LENGTH_SHORT).show();
    }
}
