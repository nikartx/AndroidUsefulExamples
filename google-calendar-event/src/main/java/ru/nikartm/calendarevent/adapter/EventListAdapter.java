package ru.nikartm.calendarevent.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.nikartm.calendarevent.R;
import ru.nikartm.calendarevent.model.EventItem;
import ru.nikartm.calendarevent.util.Utils;

/**
 * @author Ivan Vodyasov on 11.07.2017.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ItemViewHolder> {

    private static AdapterClickListener clickListener = null;
    private List<EventItem> eventList;

    public EventListAdapter() {
        eventList = new ArrayList<>();
    }

    public EventListAdapter(List<EventItem> eventList) {
        this.eventList = eventList;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardItem;
        TextView tvDate;
        TextView tvName;
        TextView tvDescription;

        public ItemViewHolder(final View itemView) {
            super(itemView);
            cardItem = (CardView) itemView.findViewById(R.id.cv_item);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
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
        EventListAdapter.clickListener = clickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (getItemCount() > 0) {
            holder.tvDate.setText(Utils.getDateTimeEvent(eventList.get(position).getDate()));
            holder.tvName.setText(eventList.get(position).getName());
            holder.tvDescription.setText(eventList.get(position).getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return eventList == null ? 0 : eventList.size();
    }

    public void addEventItem(EventItem event) {
        eventList.add(event);
        notifyDataSetChanged();
    }

    public EventItem getEventItem(int position) {
        return eventList.get(position);
    }

    public void clearEventItem() {
        if (eventList != null) {
            eventList.clear();
            notifyDataSetChanged();
        }
    }

}