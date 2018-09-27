package com.assign.assignment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.assign.assignment.R;
import com.assign.assignment.model.Row;
import com.assign.assignment.utils.PicassoTrustAll;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DataLodingAdapter extends RecyclerView.Adapter<DataLodingAdapter.MyViewHolder> {

    private Context mContext;
    private List<Row> rowListData;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.description)
        TextView description;

        @BindView(R.id.thumbnail)
        ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public DataLodingAdapter(Context mContext, List<Row> albumList) {
        this.mContext = mContext;
        this.rowListData = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Row data = rowListData.get(position);
        holder.title.setText(data.getTitle());
        holder.description.setText(data.getDescription());

        //loading image thumbnail using picasso
        //Glide.with(mContext).load(data.getImageHref());
        if (data.getImageHref() != null) {
            PicassoTrustAll.getInstance(mContext)
                    .load(data.getImageHref().toString())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.thumbnail);
        } else {
            PicassoTrustAll.getInstance(mContext)
                    .load("http://images.findicons.com/files/icons/662/world_flag/128/flag_of_canada.png")
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.thumbnail);
        }

    }

    @Override
    public int getItemCount() {
        return rowListData.size();
    }
}

