package com.mcondle.giffy.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.mcondle.giffy.R;
import com.mcondle.giffy.api.GifAdapter;
import com.mcondle.giffy.presenter.GifPresenter;

public class GifGridFragment extends BaseFragment {

    private static final int GRID_COLUMNS = 2;

    private RecyclerView gifRecyclerView;

    private GifPresenter presenter;
    private GifAdapter gifAdapter;

    private FloatingActionMenu fabMenu;
    private FloatingActionButton fab15;
    private FloatingActionButton fab30;
    private FloatingActionButton fabRandom;

    public static GifGridFragment newInstance() {
        return new GifGridFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gifAdapter = new GifAdapter(getActivity(), this);
        presenter = new GifPresenter(gifAdapter, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_gif_grid, container, false);
        initUi(view);
        setupFab(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.refresh(randomItems());
    }

    private void initUi(View rootView) {
        gifRecyclerView = (RecyclerView) rootView.findViewById(R.id.gif_grid_view);
        gifRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), GRID_COLUMNS));
        gifRecyclerView.setAdapter(gifAdapter);
        gifRecyclerView.setHasFixedSize(true);
        gifRecyclerView.setItemViewCacheSize(MAX_RANDOM_ITEMS);
        gifRecyclerView.setDrawingCacheEnabled(true);
    }

    @Override
    public void setupFab(View rootView) {
        fabMenu = (FloatingActionMenu) rootView.findViewById(R.id.floating_action_menu);
        fab15 = (FloatingActionButton) rootView.findViewById(R.id.fab_15);
        fab30 = (FloatingActionButton) rootView.findViewById(R.id.fab_30);
        fabRandom = (FloatingActionButton) rootView.findViewById(R.id.fab_random);

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

        fabRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabMenu.close(true);
                presenter.refresh(randomItems());
            }
        });
    }
}
