import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class CreateCSV {
    public static void main(String[] args) {
        // create a Map object with the user data
        Map<Integer, User> users = new HashMap<>();
        users.put(1, new User("John", "Doe", "555-555-5555", "johndoe@example.com"));
        users.put(2, new User("Jane", "Smith", "444-444-4444", "janesmith@example.com"));

        try {
            // create a FileWriter object to write to the CSV file
            FileWriter writer = new FileWriter("users.csv");
            writer.append("user_id,first_name,last_name,phone,email\n");
            // iterate through the Map object and add the data to the CSV file
            for (Map.Entry<Integer, User> entry : users.entrySet()) {
                User user = entry.getValue();
                Integer user_id = entry.getKey();
                writer.append(user_id.toString()).append(",")
                        .append(user.getFirstName()).append(",")
                        .append(user.getLastName()).append(",")
                        .append(user.getPhone()).append(",")
                        .append(user.getEmail()).append("\n");
            }
            // close the FileWriter
            writer.flush();
            writer.close();
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    public User(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
}
