import java.util.Objects;

public class Student {
    private String fname;
    private String lname;

    public Student(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(fname, student.fname) && Objects.equals(lname, student.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname);
    }

    @Override
    public String toString() {
        return String.format("%s %s",fname, lname);
    }
}
