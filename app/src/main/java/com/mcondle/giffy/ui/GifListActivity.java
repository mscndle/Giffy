package com.mcondle.giffy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.mcondle.giffy.R;
import com.mcondle.giffy.api.GifAdapter;

public class GifListActivity extends AppCompatActivity implements GifListContract.View,
        GifListContract.Navigator {

    private static final int GRID_COLUMNS = 2;
    private static final int MIN_RANDOM_ITEMS = 10;
    private static final int MAX_RANDOM_ITEMS = 50;

    private GifListPresenter presenter;
    private GifAdapter gifAdapter;

    private RecyclerView gifRecyclerView;
    private FloatingActionMenu fabMenu;
    private FloatingActionButton fab15;
    private FloatingActionButton fab30;
    private FloatingActionButton fabRand;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.gifAdapter = new GifAdapter(this, this);
        presenter = new GifListPresenter(gifAdapter, this);
        initUi();
        setupListeners();
    }

    private void initUi() {
        fabMenu = (FloatingActionMenu) findViewById(R.id.floating_action_menu);
        fab15 = (FloatingActionButton) findViewById(R.id.fab_15);
        fab30 = (FloatingActionButton) findViewById(R.id.fab_30);
        fabRand = (FloatingActionButton) findViewById(R.id.fab_random);

        gifRecyclerView = (RecyclerView) findViewById(R.id.gif_list_view);
        gifRecyclerView.setLayoutManager(new GridLayoutManager(this, GRID_COLUMNS));
        gifRecyclerView.setAdapter(gifAdapter);
        gifRecyclerView.setHasFixedSize(true);
        gifRecyclerView.setItemViewCacheSize(MAX_RANDOM_ITEMS);
        gifRecyclerView.setDrawingCacheEnabled(true);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    private void setupListeners() {
        fab15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabMenu.close(true);
                presenter.refresh(15);
            }
        });

        fab30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabMenu.close(true);
                presenter.refresh(30);
            }
        });

        fabRand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabMenu.close(true);
                presenter.refresh(randomItems());
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.refresh(randomItems());
    }

    @Override
    public void launchDetailView(String url) {
        Intent intent = new Intent(this, GifWebViewActivity.class);
        intent.putExtra(GifWebViewActivity.KEY_GIF_URL, url);
        startActivity(intent);
    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showErrorDialog() {
        // ignored
    }

    private int randomItems() {
        return (int) (Math.random() * MAX_RANDOM_ITEMS + MIN_RANDOM_ITEMS);
    }

}
