import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        Admin initialAdmin = new Admin("admin", "admin123");
        Student intialStudent = new Student("Ayumi","Ayumi123");
        Teacher intialTeacher =new Teacher("nils","nils123");
        Admin.getUsersList().add(initialAdmin);


        // Add some initial users (Students and Teachers)
        //initialAdmin.addUser(new Student("student1", "pass1"));
        //initialAdmin.addUser(new Teacher("teacher1", "pass2"));

        System.out.println("Welcome to the Student System!");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            // Find the user by username
            User loggedInUser = null;
            for (User user : Admin.getUsersList()) {
                if (user.getUsername().equals(username)) {
                   loggedInUser = user;
                    break;
                }
            }

            if (loggedInUser != null && loggedInUser.login(username, password)) {
                // Successfully logged in
                boolean loggedIn = true;
                while (loggedIn) {
                    loggedInUser.menu();
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            if (loggedInUser instanceof Admin) {
                                System.out.print("Enter new user's username: ");
                                String newUsername = scanner.next();
                                System.out.print("Enter new user's password: ");
                                String newPassword = scanner.next();
                                System.out.print("Enter new user's role (admin/teacher/student): ");
                                String role = scanner.next();
                                ((Admin) loggedInUser).addUser(newUsername, newPassword, role);
                            } else if (loggedInUser instanceof Teacher) {
                                ((Teacher) loggedInUser).viewInformation();
                            } else if (loggedInUser instanceof Student) {
                                ((Student) loggedInUser).viewInformation();
                            }
                            break;
                        case 2:
                            if (loggedInUser instanceof Admin) {
                                System.out.print("Enter username to change password: ");
                                String userToChange = scanner.next();
                                System.out.print("Enter new password: ");
                                String newPass = scanner.next();
                                ((Admin) loggedInUser).changePassword(userToChange, newPass);
                            } else if (loggedInUser instanceof Teacher) {
                                ((Teacher) loggedInUser).giveRating();
                            } else if (loggedInUser instanceof Student) {
                                ((Student) loggedInUser).writeExam();
                            }
                            break;
                        case 3:
                            if (loggedInUser instanceof Admin) {
                                System.out.print("Enter username to remove: ");
                                String userToRemove = scanner.next();
                                ((Admin) loggedInUser).removeUser(userToRemove);
                            } else if (loggedInUser instanceof Student) {
                                ((Student) loggedInUser).writeQuiz();
                            }
                            break;
                        case 4:
                            if (loggedInUser instanceof Admin) {
                                ((Admin) loggedInUser).viewAll();
                            } else if (loggedInUser instanceof Student) {
                                ((Student) loggedInUser).getRating();
                            }
                            break;
                        case 5:
                            if (loggedInUser instanceof Admin) {
                                System.out.print("Enter group name to create: ");
                                String groupName = scanner.next();
                            } else {
                                loggedIn = false; // Log out for Students and Teachers
                            }
                            break;
                        case 6:
                            if (loggedInUser instanceof Admin) {
                                loggedIn = false; // Log out
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            } else {
                System.out.println("Invalid username or password.");
            }
        }
        scanner.close();
    }
}


