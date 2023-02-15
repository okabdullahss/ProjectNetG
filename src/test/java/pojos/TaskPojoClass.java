package pojos;


public class TaskPojoClass {

    private String ssn;
    private String firstName;
    private String lastname;
    private String username;
    private String email;
    private String firstPassword;


    public TaskPojoClass(String ssn, String firstName, String lastname, String username, String email, String firstPassword) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.firstPassword = firstPassword;

    }

    public TaskPojoClass() {
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    @Override
    public String toString() {
        return "TaskPojoClass{" +
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstPassword='" + firstPassword + '\'' +
                '}';
    }
}
