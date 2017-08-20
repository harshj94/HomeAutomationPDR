package jain.autorotatetesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.mikepenz.crossfader.Crossfader;
import com.mikepenz.crossfader.util.UIUtils;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import jain.autorotatetesting.Fragments.Balcony;
import jain.autorotatetesting.Fragments.ChangePassword;
import jain.autorotatetesting.Fragments.DrawingRoom;
import jain.autorotatetesting.Fragments.Kitchen;
import jain.autorotatetesting.Fragments.LivingRoom;
import jain.autorotatetesting.Fragments.Password;

public class NavigationDrawer extends AppCompatActivity {

    MiniDrawer miniResult;
    int firstWidth, secondWidth;
    Fragment fr;
    private Drawer result = null;
    private Crossfader crossFader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_navigation_drawer);

        result = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(false)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Drawing Room").withIcon(FontAwesome.Icon.faw_home).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Kitchen").withIcon(FontAwesome.Icon.faw_cutlery).withIdentifier(2),
                        new PrimaryDrawerItem().withName("Living Room").withIcon(FontAwesome.Icon.faw_television).withIdentifier(3),
                        new PrimaryDrawerItem().withName("Bed Room").withIcon(FontAwesome.Icon.faw_bed).withIdentifier(4),
                        new PrimaryDrawerItem().withName("Balcony").withIcon(FontAwesome.Icon.faw_bars).withIdentifier(5),
                        new SectionDrawerItem().withName("Settings"),
                        new SecondaryDrawerItem().withName("Admin").withIcon(FontAwesome.Icon.faw_user_secret).withIdentifier(6),
                        new SecondaryDrawerItem().withName("User").withIcon(FontAwesome.Icon.faw_user).withIdentifier(7)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position) {
                            case 0:
                                fr = new DrawingRoom();
                                break;
                            case 1:
                                fr = new Kitchen();
                                break;
                            case 2:
                                fr = new LivingRoom();
                                break;
                            case 3:
                                fr = new Password();
                                break;
                            case 4:
                                fr = new Balcony();
                                break;
                            case 7:
                                fr = new ChangePassword();
                                break;
                            default:
                                fr = new DrawingRoom();
                        }
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_place, fr);
                        fragmentTransaction.commit();
                        return false;
                    }
                })
                .withGenerateMiniDrawer(true)
                .withSavedInstance(savedInstanceState)
                .buildView();

        miniResult = result.getMiniDrawer();

        firstWidth = (int) UIUtils.convertDpToPixel(300, this);
        secondWidth = (int) UIUtils.convertDpToPixel(72, this);

        crossFader = new Crossfader()
                .withContent(findViewById(R.id.layout))
                .withFirst(result.getSlider(), firstWidth)
                .withSecond(miniResult.build(this), secondWidth)
                .withSavedInstance(savedInstanceState);
        crossFader.build();

        miniResult.withCrossFader(new CrossfadeWrapper(crossFader));

        crossFader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState = result.saveInstanceState(outState);
        outState = crossFader.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (crossFader != null && crossFader.isCrossFaded()) {
            crossFader.crossFade();
        } else {
            super.onBackPressed();
        }
    }
}
