package com.back_arthub.back_arthub.SpaceOwner;

import com.back_arthub.back_arthub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/spaceOwners")
public class SpaceOwnerController {
    @Autowired
    private final SpaceOwnerService spaceOwnerService;

    public SpaceOwnerController(SpaceOwnerService spaceOwnerService) {
        this.spaceOwnerService = spaceOwnerService;
    }

    @GetMapping("/getOwner" )
    public List<SpaceOwner> getSpaceOwners(){return spaceOwnerService.getSpaceOwners();}
    @PostMapping(path = "/save")
    public void registerSpaceOwner(@RequestBody SpaceOwner spaceOwner){
        com.back_arthub.back_arthub.SpaceOwner.SpaceOwnerService.addNewSpaceOwner(spaceOwner);}
    @DeleteMapping(path = "/{spaceOwnerId}")
    public void deleteSpaceOwner(@PathVariable("spaceOwnerId") Long spaceOwnerId){
        com.back_arthub.back_arthub.SpaceOwner.SpaceOwnerService.deleteSpaceOwner(spaceOwnerId);}
//    @PutMapping("/{id}")
//    public ResponseEntity<SpaceOwner> updateSpaceOwner(@PathVariable long id, @RequestBody SpaceOwner spaceOwnerDetails) {
//        SpaceOwner updateSpaceOwner = spaceOwnerRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
//
//        updateSpaceOwner.setName(spaceOwnerDetails.getName());
//        spaceOwnerRepository.save(updateSpaceOwner);
//
//        return ResponseEntity.ok(updateSpaceOwner);
//    }
    @PutMapping("/{ownerId}/gallery/{galleryId}")
    public SpaceOwner assignGalleryToSpaceOwner(
            @PathVariable Long ownerId,
            @PathVariable Long galleryId
    ){
        return spaceOwnerService.assignGalleryToSpaceOwner(ownerId, galleryId);
    }

}
