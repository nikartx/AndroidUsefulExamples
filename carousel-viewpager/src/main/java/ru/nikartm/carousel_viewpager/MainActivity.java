package ru.nikartm.carousel_viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ru.nikartm.carousel_viewpager.adapter.CarouselAdapter;
import ru.nikartm.carousel_viewpager.adapter.ShadowTransformer;
import ru.nikartm.carousel_viewpager.model.CarouselItem;

public class MainActivity extends AppCompatActivity {

    private ShadowTransformer cardShadowTransformer;
    private List<CarouselItem> cslItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cslItem = createItems();
        initCarousel();
    }

    /**
     * @return demo data for carousel
     */
    private static List<CarouselItem> createItems() {
        List<CarouselItem> list = new ArrayList<>();
        list.add(new CarouselItem(R.drawable.img_1, "Bello Yellow Good"));
        list.add(new CarouselItem(R.drawable.img_2, "Mission Impossible"));
        list.add(new CarouselItem(R.drawable.img_3, "Mamba Dance"));
        list.add(new CarouselItem(R.drawable.img_4, "Are You Ready?"));
        list.add(new CarouselItem(R.drawable.img_5, "Pirate Party"));
        list.add(new CarouselItem(R.drawable.img_6, "Romantic Minions Song"));
        list.add(new CarouselItem(R.drawable.img_7, "Juggle Bananas"));
        return list;
    }

    private void initCarousel(){
        if (cslItem == null || cslItem.size() == 0) {
            return;
        }
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_carousel);
        CarouselAdapter adapter = new CarouselAdapter(getApplicationContext());
        adapter.addCardItem(cslItem);

        cardShadowTransformer = new ShadowTransformer(viewPager, adapter);
        cardShadowTransformer.enableScaling(true);

        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(false, cardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
    }

    /**
     * Method onClick on button transform carousel
     */
    public void onTransformCarousel(View view) {
        if (cardShadowTransformer.isEnabledScaling()) {
            cardShadowTransformer.enableScaling(false);
        } else {
            cardShadowTransformer.enableScaling(true);
        }
    }

}
