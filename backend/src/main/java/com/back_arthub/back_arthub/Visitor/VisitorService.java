package com.back_arthub.back_arthub.Visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VisitorService {
    @Autowired
    static VisitorRepository userRepository;

    public VisitorService(VisitorRepository userRepository) {
        VisitorService.userRepository = userRepository;
    }

    public static List<Visitor> getUsers() {return userRepository.findAll();}

    public static void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("No Id exist");
        }
        userRepository.deleteById(userId);
    }

    public void addUser(Visitor user) {
        Optional<Visitor> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("email duplicated");
        }
        userRepository.save(user);
    }
}
