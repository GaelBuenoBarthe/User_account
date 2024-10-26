package diginamic.m052024.user_account.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmbeddedBeanTest {

    @Test
    public void testEmbeddedBeanGettersAndSetters() {
        EmbeddedBean embeddedBean = new EmbeddedBean();
        embeddedBean.setId("prod123");
        embeddedBean.setName("Test Product");
        embeddedBean.setRepositoryName("profileRepository");

        assertEquals("prod123", embeddedBean.getId());
        assertEquals("Test Product", embeddedBean.getName());
        assertEquals("profileRepository", embeddedBean.getRepositoryName());
    }
}