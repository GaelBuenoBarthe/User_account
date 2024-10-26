package diginamic.m052024.user_account.service;

import diginamic.m052024.user_account.model.SellerSKU;
import diginamic.m052024.user_account.repository.SellerSKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerSKUService {

    @Autowired
    private SellerSKURepository sellerSKURepository;

    public List<SellerSKU> getAllSellerSKUs() {
        return sellerSKURepository.findAll();
    }

    public Optional<SellerSKU> getSellerSKUById(String id) {
        return sellerSKURepository.findById(id);
    }

    public SellerSKU saveSellerSKU(SellerSKU sellerSKU) {
        return sellerSKURepository.save(sellerSKU);
    }

    public void deleteSellerSKU(String id) {
        sellerSKURepository.deleteById(id);
    }
}