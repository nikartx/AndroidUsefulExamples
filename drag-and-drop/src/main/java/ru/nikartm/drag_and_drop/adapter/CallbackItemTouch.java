package ru.nikartm.drag_and_drop.adapter;

import android.view.View;

/**
 * @author Ivan Vodyasov on 07.07.2017.
 */

public interface CallbackItemTouch {
    void itemDrag(int oldPosition, int newPosition);
    void itemSwipe(int swipePosition);
    void itemClicked(View view, int position);
}
