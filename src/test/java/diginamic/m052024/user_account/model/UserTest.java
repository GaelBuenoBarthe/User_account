package diginamic.m052024.user_account.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserGettersAndSetters() {
        User user = new User();
        user.setId(123); // Use int directly
        user.setName("testuser");
        user.setEmail("testuser@example.com");

        assertEquals(123, user.getId());
        assertEquals("testuser", user.getName());
        assertEquals("testuser@example.com", user.getEmail());
    }
}