package diginamic.m052024.user_account.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "seller_skus")
public class SellerSKU {

    @Id
    private String id;

    private String name;

    private double price;

    private String description;

    private Set<String> imageUrls;

    @DBRef
    private Set<EmbeddedBean> fallIntoProfiles;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(Set<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Set<EmbeddedBean> getFallIntoProfiles() {
        return fallIntoProfiles;
    }

    public void setFallIntoProfiles(Set<EmbeddedBean> fallIntoProfiles) {
        this.fallIntoProfiles = fallIntoProfiles;
    }
}