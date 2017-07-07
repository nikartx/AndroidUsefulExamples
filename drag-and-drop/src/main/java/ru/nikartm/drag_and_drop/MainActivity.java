package ru.nikartm.drag_and_drop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ru.nikartm.drag_and_drop.adapter.AdapterClickListener;
import ru.nikartm.drag_and_drop.adapter.ItemListAdapter;
import ru.nikartm.drag_and_drop.adapter.ItemTouchHelperCallback;
import ru.nikartm.drag_and_drop.model.DragItem;

public class MainActivity extends AppCompatActivity implements CallbackItemTouch, AdapterClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView rvItems;
    private ItemListAdapter adapter;
    private List<DragItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
    }

    private void initList() {
        itemList = createItems();
        adapter = new ItemListAdapter(itemList);
        adapter.setClickListener(this);
        rvItems = (RecyclerView) findViewById(R.id.rv_item_list);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setAdapter(adapter);
        ItemTouchHelperCallback callback = new ItemTouchHelperCallback(this);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(rvItems);
    }

    private List<DragItem> createItems() {
        List<DragItem> list = new ArrayList<>();
        String description = "Description about item. Touch item and change position";
        list.add(new DragItem(R.mipmap.ic_airplane, "Airplane", description));
        list.add(new DragItem(R.mipmap.ic_camera, "Camera", description));
        list.add(new DragItem(R.mipmap.ic_cloud, "Cloud", description));
        list.add(new DragItem(R.mipmap.ic_sun, "Sun", description));
        list.add(new DragItem(R.mipmap.ic_man, "Man", description));
        list.add(new DragItem(R.mipmap.ic_phone, "Phone", description));
        list.add(new DragItem(R.mipmap.ic_setting, "Setting", description));
        list.add(new DragItem(R.mipmap.ic_thumb_up, "Thumb Up", description));
        return list;
    }

    @Override
    public void itemTouchOnMove(int oldPosition, int newPosition) {
        itemList.add(newPosition, itemList.remove(oldPosition));
        adapter.notifyItemMoved(oldPosition, newPosition);
    }

    @Override
    public void itemClicked(View view, int position) {
        Log.d(TAG, "Selected position : " + position);
    }
}
