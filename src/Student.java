public class Student extends User{
    public Student(String username,String password){
        super(username, password);
    }

    @Override
    public boolean login(String username, String password) {
        return getUsername().equals(username)&&getPassword().equals(password);
    }

    @Override
    public void menu() {
        System.out.println("student menu");
        System.out.println("1.view information");
        System.out.println("2.write exam");
        System.out.println("3.Write quiz");
        System.out.println("4.get rating");
        System.out.println("3.Logout");

    }
    public void viewInformation(){
        System.out.println("Student"+getUsername()+"see all information view");
    }

    public void writeExam(){
        System.out.println("Student"+getUsername()+"is giving exam");
    }
    public void writeQuiz(){
        System.out.println("Student"+getUsername()+"is write quiz");
    }
    public void getRating()
    {
        System.out.println("Student"+getUsername()+"is get rating");
    }
}
