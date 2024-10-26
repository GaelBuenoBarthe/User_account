package diginamic.m052024.user_account.controller;

import diginamic.m052024.user_account.model.Profile;
import diginamic.m052024.user_account.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @GetMapping
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Profile> getProfileById(@PathVariable String id) {
        return profileRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable String id) {
        profileRepository.deleteById(id);
    }
}