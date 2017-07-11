package ru.nikartm.calendarevent.adapter;

import android.view.View;

/**
 * Get callback for clicked item
 * @author Ivan Vodyasov on 11.07.2017.
 */

public interface AdapterClickListener {
    void itemClicked(View view, int position);
}
