package sent.movil.carecircle;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import sent.movil.carecircle.adapters.PublicationAdapter;
import sent.movil.carecircle.models.PublicationItem;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, View.OnClickListener {

    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    FloatingActionButton fab;

    ListView list;
    List<PublicationItem> data;
    PublicationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = (ListView) findViewById(R.id.list);
        data = new ArrayList<>();
        adapter = new PublicationAdapter(this,data);

        list.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.setDrawerListener(this);

        toggle =  new ActionBarDrawerToggle(this, drawer, R.string.open_nav, R.string.close_nav);

        loadItems();
    }

    private void loadItems() {

        PublicationItem item = new PublicationItem();
        item.setImg(R.drawable.pub4);
        item.setTitle("Protesis mas precisas");
        item.setContent("Texto de prueba");
        item.setCategoryColor(R.color.categoryNews);
        item.setCategoryName(R.string.category_news);
        data.add(item);

        item = new PublicationItem();
        item.setImg(R.drawable.pub6);
        item.setTitle("Un Gran Equipo");
        item.setContent("Texto de prueba");
        item.setCategoryColor(R.color.categoryExperience);
        item.setCategoryName(R.string.category_experience);
        data.add(item);

        item = new PublicationItem();
        item.setImg(R.drawable.pub2);
        item.setTitle("Cuidadar con Cariño");
        item.setContent("Texto de prueba");
        item.setCategoryColor(R.color.categoryPathology);
        item.setCategoryName(R.string.category_pathology);
        data.add(item);

        item = new PublicationItem();
        item.setImg(R.drawable.pub1);
        item.setTitle("Evita el encierro");
        item.setContent("Texto de prueba");
        item.setCategoryColor(R.color.categoryTips);
        item.setCategoryName(R.string.category_tips);
        data.add(item);

        item = new PublicationItem();
        item.setImg(R.drawable.pub5);
        item.setTitle("Desarrollo de sentidos");
        item.setContent("Texto de prueba");
        item.setCategoryColor(R.color.categoryNews);
        item.setCategoryName(R.string.category_news);
        data.add(item);

        item = new PublicationItem();
        item.setImg(R.drawable.pub3);
        item.setTitle("Mi Abuelo");
        item.setContent("Texto de prueba");
        item.setCategoryColor(R.color.categoryExperience);
        item.setCategoryName(R.string.category_experience);
        data.add(item);

        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    //region Drawer & Toggle
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }

    //endregion

    @Override
    public void onClick(View v) {
        Intent intent =  new Intent(this, HelperMapActivity.class);
        startActivity(intent);
    }
}
