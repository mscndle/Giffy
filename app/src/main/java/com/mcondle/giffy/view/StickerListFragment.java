package com.mcondle.giffy.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.mcondle.giffy.R;
import com.mcondle.giffy.api.StickerAdapter;
import com.mcondle.giffy.presenter.StickerPresenter;

/**
 * Created by mandeep.condle on 5/20/17.
 */

public class StickerListFragment extends BaseFragment {

    private RecyclerView stickerRecyclerView;

    private StickerPresenter presenter;
    private StickerAdapter stickerAdapter;

    private FloatingActionMenu fabMenu;
    private FloatingActionButton fab20;
    private FloatingActionButton fabRandom;

    public static StickerListFragment newInstance() {
        return new StickerListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stickerAdapter = new StickerAdapter(getActivity(), this);
        presenter = new StickerPresenter(stickerAdapter, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_sticker_list, container, false);
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
        stickerRecyclerView = (RecyclerView) rootView.findViewById(R.id.sticker_list_view);
        stickerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        stickerRecyclerView.setAdapter(stickerAdapter);
        stickerRecyclerView.setHasFixedSize(true);
        stickerRecyclerView.setItemViewCacheSize(MAX_RANDOM_ITEMS);
        stickerRecyclerView.setDrawingCacheEnabled(true);
    }

    @Override
    public void setupFab(View rootView) {
        fabMenu = (FloatingActionMenu) rootView.findViewById(R.id.floating_action_menu);
        fab20 = (FloatingActionButton) rootView.findViewById(R.id.fab_20);
        fabRandom = (FloatingActionButton) rootView.findViewById(R.id.fab_random);

        fab20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabMenu.close(true);
                presenter.refresh(20);
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
