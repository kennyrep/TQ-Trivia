package com.example.tqtrivia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class RecyclerviewAdapter extends FirestoreRecyclerAdapter<Notify, RecyclerviewAdapter.NotetifyHolder> {

    //Time stamp declaration
    private static final int SECONDS_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECONDS_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;


    public RecyclerviewAdapter(@NonNull FirestoreRecyclerOptions<Notify> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NotetifyHolder holder, int position, @NonNull Notify model) {

        holder.title.setText(model.getTitle());
        holder.hashtag.setText(model.getHashtag());
        holder.description.setText(model.getDescription());
        String ago = getTimeAgo(Long.parseLong(model.getTime()));
        holder.time.setText(ago);
        holder.location.setText(model.getLocation());

    }

    //Timestamp
    public static String getTimeAgo(long time) {
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000;
        }

        long now = System.currentTimeMillis();
        if (time > now || time <= 0) {
            return null;
        }

        // TODO: localize
        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "just now";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "a minute ago";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " minutes ago";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "an hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " hours ago";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "yesterday";
        } else {
            return diff / DAY_MILLIS + " days ago";
        }
    }

    @NonNull
    @Override
    public NotetifyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item, viewGroup, false);
        return new NotetifyHolder(view );
    }

    public class NotetifyHolder extends RecyclerView.ViewHolder{

        TextView title, description, hashtag, time, location;

        public NotetifyHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.text_topic);
            hashtag = itemView.findViewById(R.id.text_hashtag);
            description = itemView.findViewById(R.id.text_description);
            time = itemView.findViewById(R.id.text_time);
            location = itemView.findViewById(R.id.text_location);

        }
    }

   }
