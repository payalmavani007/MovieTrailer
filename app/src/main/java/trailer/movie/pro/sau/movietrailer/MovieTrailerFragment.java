package trailer.movie.pro.sau.movietrailer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srx.widget.PullToLoadView;

import trailer.movie.pro.sau.movietrailer.Paginator_Movie.Paginator_Movie;


public class MovieTrailerFragment extends Fragment {
PullToLoadView pullToLoadView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_movie_trailer, container, false);
        pullToLoadView = view.findViewById(R.id.movie_grid);
       // new Paginator_Movie(getContext(),pullToLoadView);
         return view;
    }


}
