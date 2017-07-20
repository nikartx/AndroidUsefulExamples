package ru.nikartm.carousel_viewpager.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.nikartm.carousel_viewpager.R;
import ru.nikartm.carousel_viewpager.model.CarouselItem;

/**
 * @author Ivan Vodyasov on 20.07.2017.
 */

public class CarouselAdapter extends PagerAdapter implements CardAdapter {

    private Context context;
    private List<CardView> cardViews;
    private List<CarouselItem> cslItems;
    private float mBaseElevation;

    public CarouselAdapter(Context ctx) {
        this.context = ctx;
        cslItems = new ArrayList<>();
        cardViews = new ArrayList<>();
    }

    public void addCardItem(List<CarouselItem> items) {
        cslItems.addAll(items);
        for (int i = 0; i < cslItems.size(); i++) {
            cardViews.add(null);
        }
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return cardViews.get(position);
    }

    @Override
    public int getCount() {
        return cslItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.viewpager_item, container, false);

        container.addView(view);
        bindView(cslItems.get(position), view);

        CardView cardView = (CardView) view.findViewById(R.id.carousel_cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Selected: " + cslItems.get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView ivFavorite = (ImageView) view.findViewById(R.id.iv_favorite);
        if (position % 2 == 1) {
            ivFavorite.setVisibility(View.VISIBLE);
        } else {
            ivFavorite.setVisibility(View.GONE);
        }

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }
        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        cardViews.set(position, cardView);
        return view;
    }

    private void bindView(CarouselItem item, View view) {
        ImageView ivItemImage = (ImageView) view.findViewById(R.id.iv_card_view);
        ivItemImage.setImageResource(item.getImage());
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_item_name);
        tvTitle.setText(item.getName());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        cardViews.set(position, null);
    }

}