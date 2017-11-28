package com.indiknowtech.nust.TMA.GridView_Src;

import android.graphics.Bitmap;

/**
 * Created by donovan on 8/2/16.
 */
public class ImageItem {

    private Bitmap image;
    private String title;

    public ImageItem(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
