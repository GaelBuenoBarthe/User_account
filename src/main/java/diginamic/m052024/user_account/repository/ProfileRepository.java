package diginamic.m052024.user_account.repository;

import diginamic.m052024.user_account.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {
}