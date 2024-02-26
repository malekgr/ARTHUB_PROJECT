package com.back_arthub.back_arthub.Artiste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Artiste")
public class ArtisteController {
    private final ArtisteService ArtisteService;

    @Autowired
    public ArtisteController(ArtisteService artisteService) {
        this.ArtisteService = artisteService;
    }

    @GetMapping
    public List<Artiste> getArtistes(){
        return ArtisteService.getArtistes();
    }
    @PostMapping
    public void registerNewArtiste(@RequestBody Artiste artiste){
        ArtisteService.addNewArtiste(artiste);
    }
    @DeleteMapping(path = "{artisteid}")
    public void deleteArtiste(@PathVariable("artisteid") Long artisteid){
        ArtisteService.deleteArtiste(artisteid);
    }
    @PutMapping("/{artisteid}/article/{articleid}")
    public Artiste assignedArticleToArtiste(
            @PathVariable Long artisteid,
            @PathVariable Long articleid ){
        return  ArtisteService.assignedArticleToArtiste(artisteid, articleid);
    }
}
