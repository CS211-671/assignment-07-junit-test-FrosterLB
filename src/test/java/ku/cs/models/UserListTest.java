package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList

        UserList userList = new UserList();
        userList.addUser("user01", "password1");
        userList.addUser("user02", "password2");
        userList.addUser("user03", "password3");

        // TODO: find one of them

        User user = userList.findUserByUsername("user02");
        // TODO: assert that UserList found User
        String expected = "user02";
        String actual = user.getUsername();
        assertEquals("user02", user.getUsername());
        // String expected = "<one of username>";
        // String actual = user.getUsername();
        // assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList

        UserList userList = new UserList();
        userList.addUser("user01", "password1");
        userList.addUser("user02", "password2");
        userList.addUser("user03", "password3");

        // TODO: change password of one user

        boolean actual = userList.changePassword("user02", "password2", "newPassword2");
        assertTrue(actual);

        // TODO: assert that user can change password

        User user = userList.findUserByUsername("user02");
        assertTrue(user.validatePassword("newPassword2"));
        // assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user01", "password1");
        userList.addUser("user02", "password2");
        userList.addUser("user03", "password3");

        // TODO: call login() with correct username and password
        User user = userList.login("user02", "wrongPassword");

        // TODO: assert that User object is found
        assertNull(user, "Null should be returned if username or password is incorrect.");

        // assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userList = new UserList();
        userList.addUser("user01", "password1");
        userList.addUser("user02", "password2");
        userList.addUser("user03", "password3");

        // TODO: call login() with incorrect username or incorrect password
        User user = userList.login("user02", "wrongPassword");

        // TODO: assert that the method return null
        assertNull(user);
    }

}