package additional;

public class UserFactory {

    private User user;
    private static int studentCount = 1;
    private static int employeeCount = 1;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User createUser() {
        // Check user type and create the appropriate user
        if (user != null) {
            return user;
        } else {
            return null; // Handle appropriately
        }
    }

    public String generateUserId() {
        String year = ""; // Extract the year based on your logic
        String userId = "";

        // Generate user ID based on the UserType
        switch (user.getUserType()) {
            case STUDENT:
                userId = year + "B" + studentCount;
                studentCount++;
                break;
            case MASTER:
                userId = year.substring(2) + "M" + studentCount;
                studentCount++;
                break;
            case PHD:
                userId = year.substring(2) + "P" + studentCount;
                studentCount++;
                break;
            case EMPLOYEE:
                userId = year + "E" + employeeCount;
                employeeCount++;
                break;
            default:
                // Handle default case or throw an exception
                break;
        }

        return userId;
    }
}