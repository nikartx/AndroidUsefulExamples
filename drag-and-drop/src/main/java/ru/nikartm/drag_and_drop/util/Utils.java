package ru.nikartm.drag_and_drop.util;

import java.util.ArrayList;
import java.util.List;

import ru.nikartm.drag_and_drop.R;
import ru.nikartm.drag_and_drop.model.DragItem;

/**
 * @author Ivan Vodyasov on 10.07.2017.
 */

public class Utils {

    public static List<DragItem> createItems() {
        List<DragItem> list = new ArrayList<>();
        String description = "Description about item. Touch item and change position";
        list.add(new DragItem(R.mipmap.ic_airplane, "Airplane", description));
        list.add(new DragItem(R.mipmap.ic_camera, "Camera", description));
        list.add(new DragItem(R.mipmap.ic_cloud, "Cloud", description));
        list.add(new DragItem(R.mipmap.ic_man, "Man", description));
        list.add(new DragItem(R.mipmap.ic_sun, "Sun", description));
        list.add(new DragItem(R.mipmap.ic_phone, "Phone", description));
        list.add(new DragItem(R.mipmap.ic_setting, "Setting", description));
        list.add(new DragItem(R.mipmap.ic_thumb_up, "Thumb Up", description));
        list.add(new DragItem(R.mipmap.ic_wifi, "Wi-Fi", description));
        return list;
    }
}
