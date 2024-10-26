package diginamic.m052024.user_account.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {

    @Test
    public void testProfileGettersAndSetters() {
        Profile profile = new Profile();
        profile.setId("1");
        profile.setCompanyName("Test Company");
        profile.setDescription("Test Description");

        assertEquals("1", profile.getId());
        assertEquals("Test Company", profile.getCompanyName());
        assertEquals("Test Description", profile.getDescription());
    }
}