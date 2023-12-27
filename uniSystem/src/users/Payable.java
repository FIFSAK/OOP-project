package users;

/**
 * The Payable interface represents entities that can receive and manage salary.
 */
public interface Payable {

    /**
     * Gets the current salary of the entity.
     *
     * @return The current salary.
     */
    int getSalary();

    /**
     * Sets the salary for the entity.
     *
     * @param salary The new salary to set.
     */
    void setSalary(int salary);
}
