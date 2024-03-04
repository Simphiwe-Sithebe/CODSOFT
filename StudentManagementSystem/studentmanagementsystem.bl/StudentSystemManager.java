package studentmanagementsystem.bl;

import studentmanagementsystem.ui.StudentManagementSystemGUI;
import java.sql.*;

/**
 *
 * @author Simphiwe-2021
 */
public class StudentSystemManager extends StudentManagementSystemGUI{
     public void addStudent() {
        String name = nameField.getText();
        String rollNumber = rollNumberField.getText();
        String grade = gradeField.getText();

        if (!name.isEmpty() && !rollNumber.isEmpty() && !grade.isEmpty()) {
            try {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO Students VALUES (?, ?, ?)");
                statement.setString(1, name);
                statement.setString(2, rollNumber);
                statement.setString(3, grade);
                statement.executeUpdate();
                statement.close();
                displayArea.setText("Student added successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            displayArea.setText("Please fill in all fields.");
        }
    }

    public void removeStudent() {
        String rollNumber = rollNumberField.getText();

        if (!rollNumber.isEmpty()) {
            try {
                PreparedStatement statement = connection.prepareStatement("DELETE FROM Students WHERE RollNumber = ?");
                statement.setString(1, rollNumber);
                int rowsAffected = statement.executeUpdate();
                statement.close();
                if (rowsAffected > 0) {
                    displayArea.setText("Student removed successfully!");
                } else {
                    displayArea.setText("Student not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            displayArea.setText("Please enter roll number.");
        }
    }

    public void searchStudent() {
        String rollNumber = rollNumberField.getText();

        if (!rollNumber.isEmpty()) {
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Students WHERE RollNumber = ?");
                statement.setString(1, rollNumber);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    String grade = resultSet.getString("Grade");
                    displayArea.setText("Name: " + name + "\nGrade: " + grade);
                } else {
                    displayArea.setText("Student not found.");
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            displayArea.setText("Please enter roll number.");
        }
    }

    public void displayAllStudents() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");
            StringBuilder stringBuilder = new StringBuilder();
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String rollNumber = resultSet.getString("RollNumber");
                String grade = resultSet.getString("Grade");
                stringBuilder.append("Name: ").append(name).append(", Roll Number: ").append(rollNumber).append(", Grade: ").append(grade).append("\n");
            }
            displayArea.setText(stringBuilder.toString());
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
