package trailer.movie.pro.sau.movietrailer.Paginator_Movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import trailer.movie.pro.sau.movietrailer.R;

public class MovieTrailerAdapter extends RecyclerView.Adapter<MovieTrailerAdapter.ViewHolder>{
    private Context context;
    JSONArray array;

    public MovieTrailerAdapter(Context context, JSONArray array) {
        this.context = context;
        this.array = array;
    }
    @NonNull
    @Override
    public MovieTrailerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movielist, parent, false);
        return new MovieTrailerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieTrailerAdapter.ViewHolder holder, int position) {
        final JSONObject jsonObjec;
        try {
            jsonObjec = array.getJSONObject(position);
            Picasso.get().load(jsonObjec.getString(""))
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.imageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return array.length();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        private ViewHolder(View v){

            super(v);
            imageView = v.findViewById(R.id.movie_image);

        }

    }
}
