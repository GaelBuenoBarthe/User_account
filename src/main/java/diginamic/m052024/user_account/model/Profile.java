package diginamic.m052024.user_account.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Set;

public class Profile {
    @Id
    private String id;
    private String companyName;
    private String description;

    @DBRef
    private Set<SellerSKU> skus;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<SellerSKU> getSkus() {
        return skus;
    }

    public void setSkus(Set<SellerSKU> skus) {
        this.skus = skus;
    }
}