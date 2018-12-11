package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.UserApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Address;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressController addressController;

    public User createUser(User user) {
        if(this.findUserByUsername(user.getUsername())==null){
            return userRepository.save(user);
        }
        return null;
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User findUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findUserByName(String name) {
        String[] names = name.split(" ");
        return userRepository.findUserByName(names[0], names[1]);
    }

    public User findUserByCredential(String[] loginInfo) {
        String username = loginInfo[0];
        String password = loginInfo[1];
        User curtUser = userRepository.findUserByUsername(username);
        System.out.println(curtUser);
        if (curtUser != null) {
            if (curtUser.getPassword().equals(password)) {
                return curtUser;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public User updateUserById(int id, User newUser) {
        User user = findUserById(id);
        user.set(newUser);
        return userRepository.save(user);
    }

    public Address findPrimaryAddressForUser(int userId) {
        User user = findUserById(userId);
        Address primaryAdress = null;
        for(Address address: user.getAddresses()) {
            if (address.isPrimaryAdd()==true)
                primaryAdress = address;
        }
        return primaryAdress;
    }

    public User addAddressToUser( int uId, int aId){
        User user = this.findUserById(uId);
        Address address = addressController.findAddressById(aId);
        user.addAddress(address);
        return userRepository.save(user);
    }
}
