public abstract class User {

    private String username;
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract boolean login(String username, String password);

    public abstract void menu();

    protected String getUsername() {
        return username;
    }


    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected void changePassword(String newPassword) {
        this.password = newPassword;
    }

}

