package example;

import java.io.IOException;

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
        String userName = ""; // TODO specify the username you want to use.
        if (userName.isEmpty()) {
            System.out.println("please choose a non-empty user name!");
            System.exit(0);
        }
        String response = "";
        try {
            response = example.run(gradeAPISignUpURL, "talhaefeustun", userName);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(response);
    }
}
