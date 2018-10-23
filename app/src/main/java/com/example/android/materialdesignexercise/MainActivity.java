package com.example.android.materialdesignexercise;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    android.support.v7.widget.Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    AppCompatEditText usernameEdit;
    AppCompatEditText passEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);



        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,mToolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(this);


        ImageView imageHolder = findViewById(R.id.image_holder);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image_decoration);
        RoundedBitmapDrawable roundDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundDrawable.setCircular(true);
        imageHolder.setImageDrawable(roundDrawable);


        ///////////////////////////AppCompatEditText//////////////////////

        usernameEdit = findViewById(R.id.username_text_feild);
        passEdit = findViewById(R.id.password_text_feild);



        usernameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            // npr belezi slovo @charSequence, ali tek nakon kucanja narednog slova (poslednje slovo ne izbacuje)
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                System.out.println(charSequence);

            }
            // npr belezi slovo @charSequence, cim se otkuca
            //!!! razilka izmedju @onTextChanged i @afterTextChanged , koriscenjem prvog, moze da se izdvoji
            //vrednost otkucanog karaktera (@charSequence) i iskoristi u kodu. u drugom metodu to ne moze;
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            // izvrsava zadatak posto se tekst promeni
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // osluskuje da li je fokus na view-u
        passEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {

                System.out.println(hasFocus);
                }
        });
    }





    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.item1_id){
            Toast.makeText(this, "item one", Toast.LENGTH_SHORT).show();

        }
        else if (id== R.id.item2_id){
            Toast.makeText(this, "item two", Toast.LENGTH_SHORT).show();

        }
        else if (id== R.id.action_like){
            Toast.makeText(this, "like", Toast.LENGTH_SHORT).show();

        }
        else if (id== R.id.action_star){
            Toast.makeText(this, "star", Toast.LENGTH_SHORT).show();

        }
        else if (id==android.R.id.home){
        Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();

    }
        else {
            Toast.makeText(this, "item boli me grlo", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }


    // difference between group and an item:
    //when item is defined in navigation bar, it acts like a button (last 3 items),
    //whe item is deffined in a group, that item will have a hold characteristics (first 4 items)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.inbox_id:
                break;
            case R.id.starred_id:
                break;
            case R.id.sent_id:
                break;
            case R.id.drafts_id:
                break;
            case R.id.all_mail_id:
                break;
            case R.id.trash_id:
                break;
            case R.id.spam_id:
                break;

        }

        return true;
    }
}
