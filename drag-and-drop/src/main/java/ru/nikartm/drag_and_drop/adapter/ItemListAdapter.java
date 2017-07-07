package ru.nikartm.drag_and_drop.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.nikartm.drag_and_drop.R;
import ru.nikartm.drag_and_drop.model.DragItem;

/**
 * @author Ivan Vodyasov on 07.07.2017.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    private static AdapterClickListener clickListener = null;
    private List<DragItem> itemList;

    public ItemListAdapter(List<DragItem> itemList) {
        this.itemList = itemList;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardItem;
        ImageView ivItemIcon;
        TextView tvName;
        TextView tvDescription;

        public ItemViewHolder(final View itemView) {
            super(itemView);
            cardItem = (CardView) itemView.findViewById(R.id.cv_item);
            ivItemIcon = (ImageView) itemView.findViewById(R.id.iv_card_icon);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            cardItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null) {
                clickListener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(AdapterClickListener clickListener) {
        ItemListAdapter.clickListener = clickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (getItemCount() > 0) {
            holder.ivItemIcon.setImageResource(itemList.get(position).getImage());
            holder.tvName.setText(itemList.get(position).getName());
            holder.tvDescription.setText(itemList.get(position).getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

}