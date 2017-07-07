package ru.nikartm.drag_and_drop.adapter;

import android.view.View;

/**
 * @author Ivan Vodyasov on 07.07.2017.
 */

public interface CallbackItemTouch {
    void itemTouchOnMove(int oldPosition,int newPosition);
    void itemClicked(View view, int position);
}
