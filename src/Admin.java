import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private static  List<User> usersList = new ArrayList<>();

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login(String username, String password) {
        return getUsername().equals(username) && getPassword().equals(password);
    }

    @Override
    public void menu() {
        System.out.println("admin menu");
        System.out.println("1. add user");
        System.out.println("2.change password user");
        System.out.println("3.remove user");
        System.out.println("4.view all user");
        System.out.println("logout");
    }


    public void addUser(String username, String password, String role) {
        User user = null;

        if (role.equalsIgnoreCase("Student")) {
            user = new Student(username, password);
        } else if (role.equalsIgnoreCase("Teacher")) {
            user = new Teacher(username, password);
        }
        if (user != null) {
            usersList.add(user);

            System.out.println(" user add succesfull add in list");
        } else {
            System.out.println("invalid user");
        }

    }


    public void removeUser(String username){
        usersList.removeIf(user->user.getUsername().equals(username));

        System.out.println("Remove user from list"+username);

    }

    public void changePassword(String username,String newPassword){
        for(User user : usersList)
            if(user.getUsername().equals(username)){
                user.changePassword(newPassword);
                System.out.println(" password change sucessfully"+ username);
                return;

            }

    }

    public void viewAll(){
        System.out.println("print all view for user");
        for(User user : usersList){
            System.out.println(user.getUsername()+user.getClass().getSimpleName());
        }

    }
    public void logout(){
        System.out.println("logout user");

        }
            public static List<User>getUsersList(){
        return usersList;
    }

}