import java.io.Serializable;

public class employeeBean implements Serializable {
    private long empNo;
    private String firstName;
    private String lastName;
    private char gender;

    public employeeBean() {

    }

    public employeeBean(long empNo, String firstName, String lastName, char gender) {
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    // getters and setters

    public long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(long empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "employeeBean{" +
                "empNo=" + empNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }

    public static void main(String[] args) {
        employeeBean employeeBean = new employeeBean(1, "Mykal", "Clinard", 'M');
        System.out.println(employeeBean);

    }
}
