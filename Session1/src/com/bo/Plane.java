package com.bo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Khuong Duy on 12/2/2016.
 */
public class Plane {
    int x,y;
    int width,height;
    String urlImage;
    Image image;
    public Plane(){

    }
    public Plane(int x, int y, String urlImage){
        this.x=x;
        this.y=y;
        this.urlImage =urlImage;
        try {
            this.image= ImageIO.read(new File(urlImage));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error 1");
        }
    }
    public Plane(int x, int y, String urlImage,int width,int height){
        this.x=x;
        this.y=y;
        this.urlImage =urlImage;
        this.width=width;
        this.height=height;
        try {
            this.image= ImageIO.read(new File(urlImage));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Not found image");
        }
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
