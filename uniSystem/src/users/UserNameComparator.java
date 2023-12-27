package users;
import java.util.Comparator;
import users.User;

/**
 * The `UserNameComparator` class implements the Comparator interface to provide a custom comparison
 * for sorting User objects based on their first names in ascending order.
 */
public class UserNameComparator implements Comparator<User> {

    /**
     * Compares two User objects based on their first names.
     *
     * @param u1 The first User object.
     * @param u2 The second User object.
     * @return An integer representing the result of the comparison:
     *         - a negative value if u1's first name comes before u2's first name.
     *         - zero if u1's first name is equal to u2's first name.
     *         - a positive value if u1's first name comes after u2's first name.
     */
    @Override
    public int compare(User u1, User u2) {
        return u1.getFirstName().compareTo(u2.getFirstName());
    }
}
