package diginamic.m052024.user_account.repository;

import diginamic.m052024.user_account.model.SellerSKU;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerSKURepository extends MongoRepository<SellerSKU, String> {
}