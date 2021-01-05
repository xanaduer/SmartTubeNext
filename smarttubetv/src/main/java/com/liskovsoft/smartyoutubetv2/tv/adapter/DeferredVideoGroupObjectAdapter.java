package com.liskovsoft.smartyoutubetv2.tv.adapter;

import com.liskovsoft.smartyoutubetv2.common.app.models.data.VideoGroup;
import com.liskovsoft.smartyoutubetv2.tv.presenter.CardPresenter;

public class DeferredVideoGroupObjectAdapter extends VideoGroupObjectAdapter {
    private long mPrevAppendTimeMs;

    public DeferredVideoGroupObjectAdapter(VideoGroup group, CardPresenter presenter) {
        super(group, presenter);
    }

    @Override
    public void append(VideoGroup group) {
        long currentTimeMillis = System.currentTimeMillis();

        if (currentTimeMillis - mPrevAppendTimeMs < 3_000) {
            return;
        }

        mPrevAppendTimeMs = currentTimeMillis;

        super.append(group);
    }
}
