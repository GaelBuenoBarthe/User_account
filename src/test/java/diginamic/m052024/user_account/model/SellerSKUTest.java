package diginamic.m052024.user_account.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellerSKUTest {

    @Test
    public void testSellerSKUGettersAndSetters() {
        SellerSKU sellerSKU = new SellerSKU();
        sellerSKU.setId("SKU123");
        sellerSKU.setName("Test SKU");
        sellerSKU.setDescription("Test Description");
        sellerSKU.setImageUrls(Arrays.asList("http://example.com/image1.jpg", "http://example.com/image2.jpg")
                .stream().collect(Collectors.toSet()));

        EmbeddedBean embeddedBean = new EmbeddedBean();
        embeddedBean.setId("prod123");
        embeddedBean.setName("Test Product");
        embeddedBean.setRepositoryName("profileRepository");

        Set<EmbeddedBean> fallIntoProfiles = new HashSet<>();
        fallIntoProfiles.add(embeddedBean);
        sellerSKU.setFallIntoProfiles(fallIntoProfiles);

        assertEquals("SKU123", sellerSKU.getId());
        assertEquals("Test SKU", sellerSKU.getName());
        assertEquals("Test Description", sellerSKU.getDescription());
        assertEquals(new HashSet<>(Arrays.asList("http://example.com/image1.jpg", "http://example.com/image2.jpg")), sellerSKU.getImageUrls());
        assertEquals(fallIntoProfiles, sellerSKU.getFallIntoProfiles());
    }
}