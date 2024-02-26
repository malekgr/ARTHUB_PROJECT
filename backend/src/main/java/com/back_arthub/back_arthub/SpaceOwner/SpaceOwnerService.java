package com.back_arthub.back_arthub.SpaceOwner;

import com.back_arthub.back_arthub.Gallery.Gallery;
import com.back_arthub.back_arthub.Gallery.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SpaceOwnerService {
    @Autowired
    private static SpaceOwnerRepository spaceOwnerRepository;
    @Autowired
    private final GalleryRepository galleryRepository;


    public SpaceOwnerService(SpaceOwnerRepository spaceOwnerRepository, GalleryRepository galleryRepository) {
        SpaceOwnerService.spaceOwnerRepository = spaceOwnerRepository;
        /*this.galleryRepository = galleryRepository;*/
        this.galleryRepository = galleryRepository;
    }
    public List<SpaceOwner> getSpaceOwners() {
        return spaceOwnerRepository.findAll();
    }
    public List<SpaceOwner> getSpaceOwnersById(List<Long> ownersId){
        return spaceOwnerRepository.findAllById(ownersId);
    }
    public static void addNewSpaceOwner(SpaceOwner spaceOwner) {
        Optional<SpaceOwner> spaceOwnerByName = spaceOwnerRepository.findSpaceOwnerByName(spaceOwner.getName());
        if(spaceOwnerByName.isPresent()){
            throw new IllegalStateException("location taken");
        }
        spaceOwnerRepository.save(spaceOwner);
    }

    public static void deleteSpaceOwner(Long spaceOwnerId) {
        boolean exists = spaceOwnerRepository.existsById(spaceOwnerId);
        if (!exists){
            throw new IllegalStateException("No Id exist");
        }
        spaceOwnerRepository.deleteById(spaceOwnerId);
    }


    public SpaceOwner assignGalleryToSpaceOwner(Long ownerId, Long galleryId) {
        Set<Gallery> galleries;
        SpaceOwner spaceOwner = spaceOwnerRepository.findById(ownerId).get();
        Gallery gallery = galleryRepository.findById(galleryId).get();
        galleries =  spaceOwner.getGalleries();
        galleries.add(gallery);
        spaceOwner.setGalleries(galleries);
        return spaceOwnerRepository.save(spaceOwner);
    }
}
