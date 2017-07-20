package ru.nikartm.carousel_viewpager.adapter;

import android.support.v7.widget.CardView;

/**
 * @author Ivan Vodyasov on 20.07.2017.
 */

public interface CardAdapter {
    int MAX_ELEVATION_FACTOR = 4;

    float getBaseElevation();
    CardView getCardViewAt(int position);
    int getCount();
}
