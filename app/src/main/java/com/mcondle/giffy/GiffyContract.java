package com.mcondle.giffy;

/**
 * Created by mandeep.condle on 5/16/17.
 */

public interface GiffyContract {

    interface View {
        void showLoading(boolean show);
        void showErrorDialog();
    }

    interface Presenter {
        void refresh(int items);
    }

    interface Navigator {
        void launchDetailView(String url);
    }

}
