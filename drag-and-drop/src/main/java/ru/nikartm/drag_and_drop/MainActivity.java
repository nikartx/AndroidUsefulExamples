package ru.nikartm.drag_and_drop;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import ru.nikartm.drag_and_drop.fragment.GridItemFragment;
import ru.nikartm.drag_and_drop.fragment.ListItemFragment;

public class MainActivity extends AppCompatActivity {

    private Menu menu;
    private FragmentManager frManager;
    private FragmentTransaction frTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frManager = getSupportFragmentManager();
        initListFragment();
    }

    private void initListFragment() {
        frTransaction = frManager.beginTransaction();
        frTransaction.replace(R.id.main_container, new ListItemFragment());
        frTransaction.commit();
    }

    private void initGridFragment() {
        frTransaction = frManager.beginTransaction();
        frTransaction.replace(R.id.main_container, new GridItemFragment());
        frTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuItem iconList = menu.findItem(R.id.action_list);
        MenuItem iconGrid = menu.findItem(R.id.action_grid);
        switch (item.getItemId()) {
            case R.id.action_list:
                iconList.setVisible(false);
                iconGrid.setVisible(true);
                initListFragment();
                break;
            default:
                iconGrid.setVisible(false);
                iconList.setVisible(true);
                initGridFragment();
                break;
        }
        return true;
    }
}
