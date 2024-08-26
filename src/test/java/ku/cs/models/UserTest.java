package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Username should be valid")
    public void testUsernameIsValid() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.isUsername("user01");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Username should be invalid if it doesn't match")
    public void testUsernameIsInvalid() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.isUsername("wrongUser");
        assertFalse(actual);
    }

    @Test
    @DisplayName("Set a new password and verify it")
    public void testSetPassword() {
        User user = new User("user01", "plain-p@ssw0rd");
        user.setPassword("newpassword");
        boolean actual = user.validatePassword("newpassword");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password verification should fail with incorrect password")
    public void testPasswordVerificationFailsWithIncorrectPassword() {
        User user = new User("user01", "correctPass");
        boolean actual = user.validatePassword("wrongPass");
        assertFalse(actual);
    }

    @Test
    @DisplayName("Username getter should return correct username")
    public void testGetUsername() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getUsername();
        assertEquals("user01", actual);
    }

    @Test
    @DisplayName("Password getter should return hashed password")
    public void testGetPassword() {
        User user = new User("user01", "plain-p@ssw0rd");
        String hashedPassword = user.getPassword();
        assertNotNull(hashedPassword, "Password getter should return the hashed password.");
        assertNotEquals("plain-p@ssw0rd", hashedPassword);
    }
}