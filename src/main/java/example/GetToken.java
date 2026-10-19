package example;

import jdk.dynalink.StandardOperation;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Class for getting your Grade API token.
 */
public class GetToken {

    /**
     * Run to get your token after you complete the code.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        GetExample example = new GetExample();

        String gradeAPISignUpURL = "https://csc207-20269-vm.teach.cs.toronto.edu/signUp";
        // TODO Task 1: use the run method to get your Grade API token (or obtain your token through a web browser).
        String userName = "licath23"; // TODO specify the username you want to use.
        if (userName.isEmpty()) {
            System.out.println("please choose a non-empty user name!");
            System.exit(0);
        }
        String response = "";
        try {
            response = example.run(gradeAPISignUpURL, "username", userName);
            System.out.println(response);
            // Convert response from String to json
            JSONObject json = new JSONObject(response);
            if (json.getInt("status_code") == 200) {
                // Retrieve token
                String token = json.getString("token");
                // Create a content
                String content = "user=" + userName +
                        "\ntoken=" + token + "\n\n";
                // specify my filepath
                Path filePath = Path.of("token.txt");
                // Write my content into the file
                Files.writeString(filePath, content,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
                System.out.print("Token is saved to token.txt");
            } else {
                System.out.println("Signed up failed. Token not saved into token.txt");
            }

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(response);
    }
}
