package com.example.test.api;

import com.example.test.domain.AppUser;
import com.example.test.domain.Role;
import com.example.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(iUserService.getUsers());
    }
    @GetMapping("/user")
    public ResponseEntity<AppUser> getUser(String username){
        return ResponseEntity.ok().body(iUserService.getUser(username));

    }
    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser){
        URI uri =  URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(iUserService.saveUser(appUser));

    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri =  URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(iUserService.saveRole(role));
    }
    @PutMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody String username,@RequestBody String roleName){
        iUserService.addRoleToUser(username,roleName);
        return ResponseEntity.ok().build();
    }
}
