package encoders.encode;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RVwithSectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerViewClickListener mListener;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    public static final int TYPE_TWO_HEADER = 2;
    private LayoutInflater inflater;
    List<RVInfo> data =  Collections.emptyList();
    public RVwithSectionAdapter(Context context, List<RVInfo> data,RecyclerViewClickListener listener){
        inflater= LayoutInflater.from(context);
        this.data=data;
        mListener = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==TYPE_ITEM){
            View v = inflater.inflate(R.layout.custom_row, parent, false);
            ItemHolder myViewHolder = new ItemHolder(v, mListener);
            return myViewHolder;
        }
        else if(viewType==TYPE_TWO_HEADER){
            View v = inflater.inflate(R.layout.custom_row_secondaryheader, parent, false);
            SecondaryHeaderHolder myViewHolder = new SecondaryHeaderHolder(v, mListener);
            return myViewHolder;
        }
        else {
            View v = inflater.inflate(R.layout.custom_row_header, parent, false);
            HeaderHolder myViewHolder = new HeaderHolder(v, mListener);
            return myViewHolder;
        }
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemHolder) {
            ItemHolder itemHolder = (ItemHolder)holder;
            RVInfo current = data.get(position);
            itemHolder.title.setText(current.title);
        }
        else if(holder instanceof  SecondaryHeaderHolder){
            SecondaryHeaderHolder itemHolder = (SecondaryHeaderHolder) holder;
            RVInfo current = data.get(position);
            itemHolder.title.setText(current.title);
        }
        else{
            HeaderHolder headerHolder = (HeaderHolder) holder;
            RVInfo current = data.get(position);
            headerHolder.title.setText(current.title);
        }
    }

    @Override
    public int getItemCount() {
        return data.size(); //Plus the size equal to number of headers
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0||position==3)     //set certain positions as headers
            return TYPE_HEADER;
        else if(position==4||position==11||position==8||position==13)   //set certain positions as secondary headers
            return TYPE_TWO_HEADER;
        else
            return TYPE_ITEM;
    }

    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        private RecyclerViewClickListener mListener;
        public ItemHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            title = itemView.findViewById(R.id.listText);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    class HeaderHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        private RecyclerViewClickListener mListener;
        public HeaderHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            title = itemView.findViewById(R.id.listSectionText);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }
    class SecondaryHeaderHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        private RecyclerViewClickListener mListener;
        public SecondaryHeaderHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            title = itemView.findViewById(R.id.listSectionSecText);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }
}
