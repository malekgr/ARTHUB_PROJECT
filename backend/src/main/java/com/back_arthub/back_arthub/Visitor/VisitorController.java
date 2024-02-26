package com.back_arthub.back_arthub.Visitor;

import com.back_arthub.back_arthub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class VisitorController {
    @Autowired
    private VisitorService userService;
    @Autowired
    private VisitorRepository userRepository;

    public VisitorController(VisitorService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/getUser")
    public List<Visitor> getUsers(){return VisitorService.getUsers();}
    @PostMapping(path = "/save")
    public void registerUser(@RequestBody Visitor user){
        userService.addUser(user);
    }
    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        VisitorService.deleteUser(userId);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<Visitor> updateSpaceOwner(@PathVariable long userId, @RequestBody Visitor userDetails) {
        Visitor updateUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + userId));

        updateUser.setName(userDetails.getName());
        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }
}
