package trailer.movie.pro.sau.movietrailer.Paginator_Movie;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.srx.widget.PullCallback;
import com.srx.widget.PullToLoadView;


public class Paginator_Movie {
    Context context;
    PullToLoadView pullToLoadView;
    RecyclerView recyclerView;
    MovieTrailerAdapter adapter;
    boolean isLoading = false;
    boolean hasLoadAll = false;
    int nextPage;

    public Paginator_Movie(Context context, PullToLoadView pullToLoadView) {
        this.context = context;
        this.pullToLoadView = pullToLoadView;

        recyclerView = pullToLoadView.getRecyclerView();
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        recyclerView.setAdapter(adapter);
        initializePagination();
    }
    public void initializePagination() {

        pullToLoadView.isLoadMoreEnabled(true);
        pullToLoadView.setPullCallback(new PullCallback() {
            @Override
            public void onLoadMore() {
                LoadData(nextPage);
            }

            @Override
            public void onRefresh() {
                adapter.clear();
                hasLoadAll=false;
                LoadData(1);
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return hasLoadAll;
            }
        });

        pullToLoadView.initLoad();
    }
}
