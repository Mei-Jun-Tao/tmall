package com.tmall.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class Image {

    private MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
