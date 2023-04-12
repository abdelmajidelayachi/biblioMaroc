package com.elayachiabdelmajid.libMaroc.globals.services;

import com.elayachiabdelmajid.libMaroc.provider.CloudinaryProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadService {

    private final CloudinaryProvider cloudinaryProvider;

    public ImageUploadService(CloudinaryProvider cloudinaryProvider) {
        this.cloudinaryProvider = cloudinaryProvider;
    }

    public String[] storeImageInCloud(MultipartFile[] images) {
        String[] urls = new String[images.length];
        for (int i = 0; i < images.length; i++) {
            System.out.println(images[i].getOriginalFilename());
            urls[i] = cloudinaryProvider.uploadImage(images[i]);
        }
        return urls;
    }
}
