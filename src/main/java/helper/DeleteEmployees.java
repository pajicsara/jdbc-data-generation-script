package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static util.SqlQueries.*;

public class DeleteEmployees {

    public static void deleteEmployeesWithSalaryBelow(double lowSalaryBound) {
        try (Connection connection = DataBaseManager.connectWithDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LOW_SALARY_EMPLOYEES)) {

            preparedStatement.setDouble(1, lowSalaryBound);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Deleted " + rowsAffected + " employees with salary below " + lowSalaryBound);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void deleteAllEmployeesFromDB() {
        try (Connection connection = DataBaseManager.connectWithDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_EMPLOYEES)) {

            preparedStatement.executeUpdate();
            System.out.println("All data deleted from table");

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void deleteAllEmployeesFromDepartment(String department) {
        try (Connection connection = DataBaseManager.connectWithDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEES_FROM_SPECIFIC_DEPARTMENT)) {

            preparedStatement.setString(1, department);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("All employees from " + department + " department are deleted.");

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
