package me.ghui.gradledemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable;
import com.jpardogo.android.googleprogressbar.library.GoogleMusicDicesDrawable;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;
import com.jpardogo.android.googleprogressbar.library.NexusRotationCrossDrawable;


/**
 * Created by vann on 12/20/14.
 */
public class ImgViewer extends Activity {
    String[] urls = { ImgUrlContants.img1, ImgUrlContants.img2,
            ImgUrlContants.img3, ImgUrlContants.img4
            , ImgUrlContants.img5, ImgUrlContants.img6, ImgUrlContants.img7,
            ImgUrlContants.img8, ImgUrlContants.img9, ImgUrlContants.img10 };

    GoogleProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_viewer);
        mProgressBar = (GoogleProgressBar) findViewById(R.id.google_progress);
        mProgressBar.setIndeterminateDrawable(getRandomProgressDrawable());
        onLoadImg();
    }

    private Drawable getRandomProgressDrawable(){
        Drawable[] mDrawable = { new FoldingCirclesDrawable.Builder(this).build(),
                new GoogleMusicDicesDrawable.Builder().build(), new NexusRotationCrossDrawable.Builder(this).build()};
        return mDrawable[NumUtils.getRandomNum(2)];
    }

    private String getRandomImgUrl() {
        return urls[NumUtils.getRandomNum(9)];
    }

    private void onLoadImg() {
        final ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.networkImageView);

        ImageRequest request = new ImageRequest(getRandomImgUrl(),new Response.Listener<Bitmap>() {
            @Override public void onResponse(Bitmap response) {
                mImageView.setImageBitmap(response);
                mProgressBar.setVisibility(View.GONE);
            }
        },0,0,null,new Response.ErrorListener() {
            @Override public void onErrorResponse(VolleyError error) {
                mImageView.setImageResource(R.drawable.img_error);
                mProgressBar.setVisibility(View.GONE);
            }
        });
        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(request);
    }
}
