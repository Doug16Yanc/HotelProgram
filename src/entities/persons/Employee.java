package entities.persons;


public class Employee {
    private String nameEmployee;
    private String username;
    private String password;

    public Employee(String nameEmployee, String username, String password){
        this.nameEmployee = nameEmployee;
        this.username = username;
        this.password = password;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
