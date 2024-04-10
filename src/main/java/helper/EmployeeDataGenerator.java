package helper;

import com.github.javafaker.Faker;

import java.util.Random;

import static util.TestUtil.MAXIMUM_SALARY;
import static util.TestUtil.MINIMUM_SALARY;

public class EmployeeDataGenerator {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();
    public static String generateFirstName() {
        return faker.name().firstName();
    }
    public static String generateLastName() {
        return faker.name().lastName();
    }
    public static String generateEmail() {
        return faker.internet().emailAddress();
    }
    public static String generateDepartment() {
        return faker.company().industry();
    }
    public static double generateRandomSalary() {
        return MINIMUM_SALARY + (random.nextDouble() * (MAXIMUM_SALARY - MINIMUM_SALARY));
    }

    public static void printEmployees(String firstName, String lastName, String email, String department, double salary) {
        System.out.println("New employee added:");
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + String.format("%.2f", salary));
        System.out.println("--------------------");
    }

}
