package com.back_arthub.back_arthub.Gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/galleries")
public class GalleryController {
    private final GalleryService GalleryService;

    @Autowired
    public GalleryController(GalleryService galleryService) {
        this.GalleryService = galleryService;
    }

    @GetMapping
    public List<Gallery> getGalleries(){
        return GalleryService.getGalleries();
    }
    @PostMapping
    public void registerNewGallery(@RequestBody Gallery gallery){
        GalleryService.addNewGallery(gallery);
    }
    @DeleteMapping(path = "{galleryId}")
    public void deleteGallery(@PathVariable("galleryId") Long galleryId){
        GalleryService.deleteGallery(galleryId);
    }

    @PutMapping("/{galleryid}/article/{articleid}")
    public  Gallery assignedArticleToGallery(
            @PathVariable Long galleryid,
            @PathVariable Long articleid ){
        return  GalleryService.assignedArticleToGallery(galleryid, articleid);
    }
}


