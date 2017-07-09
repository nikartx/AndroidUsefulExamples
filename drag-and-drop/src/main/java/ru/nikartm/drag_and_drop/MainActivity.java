package ru.nikartm.drag_and_drop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.nikartm.drag_and_drop.adapter.CallbackItemTouch;
import ru.nikartm.drag_and_drop.adapter.ItemListAdapter;
import ru.nikartm.drag_and_drop.adapter.ItemTouchHelperCallback;
import ru.nikartm.drag_and_drop.model.DragItem;

public class MainActivity extends AppCompatActivity implements CallbackItemTouch {

    public static final String TAG = MainActivity.class.getSimpleName();

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
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        ItemTouchHelperCallback callback = new ItemTouchHelperCallback(this);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
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
    public void itemDrag(int oldPosition, int newPosition) {
        itemList.add(newPosition, itemList.remove(oldPosition));
        adapter.notifyItemMoved(oldPosition, newPosition);
    }

    @Override
    public void itemSwipe(int swipePosition) {
        itemList.remove(swipePosition);
        adapter.notifyItemRemoved(swipePosition);
    }

    @Override
    public void itemClicked(View view, int position) {
        Toast.makeText(this, "Selected position : " + itemList.get(position).getName(),
                Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Selected position : " + position);
    }
}
