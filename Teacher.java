public class Teacher extends User{
    public Teacher(String username, String password){
        super (username, password);
    }
    @Override
    public boolean login(String username, String password) {
        return getUsername().equals(username)&&getPassword().equals(password);
    }

    @Override
    public void menu() {
        System.out.println("Teacher menu");
        System.out.println("1.view information");
        System.out.println("2.give rating");
        System.out.println("logout");

    }

    public void viewInformation(){
        System.out.println(" Teacher"+getUsername()+"is view all information");
    }

    public void giveRating(){
        System.out.println("Teacher"+getUsername()+"is giving a rating");
    }

}

