package diginamic.m052024.user_account.controller;

import diginamic.m052024.user_account.model.SellerSKU;
import diginamic.m052024.user_account.service.SellerSKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seller-skus")
public class SellerSKUController {

    @Autowired
    private SellerSKUService sellerSKUService;

    @GetMapping
    public List<SellerSKU> getAllSellerSKUs() {
        return sellerSKUService.getAllSellerSKUs();
    }

    @GetMapping("/{id}")
    public Optional<SellerSKU> getSellerSKUById(@PathVariable String id) {
        return sellerSKUService.getSellerSKUById(id);
    }

    @PostMapping
    public SellerSKU createSellerSKU(@RequestBody SellerSKU sellerSKU) {
        return sellerSKUService.saveSellerSKU(sellerSKU);
    }

    @DeleteMapping("/{id}")
    public void deleteSellerSKU(@PathVariable String id) {
        sellerSKUService.deleteSellerSKU(id);
    }
}