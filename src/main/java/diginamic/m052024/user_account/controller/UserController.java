package diginamic.m052024.user_account.controller;

import diginamic.m052024.user_account.model.User;
import diginamic.m052024.user_account.service.SequenceGeneratorService;
import diginamic.m052024.user_account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        return user.orElse(null); // Return null or handle the case where the user is not found
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME).intValue());
            User savedUser = userService.saveUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/email")
    public User getUserByEmail(@RequestParam String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.orElse(null); // Return null or handle the case where the user is not found
    }
}