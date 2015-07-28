package com.android.shikha.picassoexample;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class MainActivity extends ActionBarActivity {
    private Context mContext;

    private final static String  URL="http://maps.gstatic.com/mapfiles/place_api/icons/fitness-71.png";
    //Wrong url
    private final static String  ERROT_URL="http://maps.gstatic/mapfiles/place_api/icons/fitness-71.png";

    private final static String  CIRCULAR_URL="https://graph.facebook.com/1409227626002113/picture";


    private ImageView simpleView;
    private ImageView viewWithPlaceholder;
    private ImageView viewWithResize;
    private ImageView circularView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponent();
        setImageToBasicView();
        setImageWithPlaceholder();
        setImageWithResize();
        setCircularImage();
    }

    private void setCircularImage() {
        Picasso.with(mContext).load(CIRCULAR_URL)
                .placeholder(R.drawable.placeholder_user)
                .transform(new CircularView()) //optional for converting image in circular image
                .into(circularView);

    }

    private void setImageWithResize() {
        Picasso.with(this)
                .load(URL)
                .resize(500, 400)                        // optional for resizing image
                .rotate(90)                             // optional for rotating image
                .into(viewWithResize);

    }

    private void setImageWithPlaceholder() {
        Picasso.with(mContext)
                .load(ERROT_URL)
                .placeholder(R.drawable.placeholder_user) // optional for adding placeholder
                .error(R.drawable.error)         // optional for adding error fallback
                .into(viewWithPlaceholder);

    }

    private void setImageToBasicView() {

        Picasso.with(mContext)
                .load(URL)
                .into(simpleView);
        
    }

    private void initializeComponent() {
        mContext=this;
        simpleView= (ImageView) findViewById(R.id.simpleImage);
        viewWithPlaceholder =(ImageView) findViewById(R.id.imageWithPlaceholder);
        viewWithResize= (ImageView) findViewById(R.id.imageWithResize);
        circularView= (ImageView) findViewById(R.id.circularImage);
        
    }


}
