import java.util.ArrayList;
import java.util.Objects;

public class Student extends Person{
    private String school = "XLO Gdynia";
    private String profile = "Mat-fiz";
    private String startDate = "2016-09-01";
    private Double average = 4.0;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    static ArrayList<Student> studentList = new ArrayList<>();

    public Student(String name, String surname, String birthDate, String school, String profile, String startDate, Double average){
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(birthDate);
        this.school = school;
        this.profile = profile;
        this.startDate = startDate;
        this.average = average;
        studentList.add(this);
    }

    double educationLength() {
        String[] ymd = startDate.split("[-,.]",3);
        int years = currentYear - Integer.parseInt(ymd[0]);
        int months = currentMonth - Integer.parseInt(ymd[1]);
        if(months<0) {years--; months+=12;}
        return years+months/12.0;
    }

    public static Student studentWithMaxAverage(){
        if (studentList.size() == 0) return null;
        Student MaxAverage = studentList.get(0);
        for(int i=1; i<studentList.size(); i++)
        {
            if(MaxAverage.average<studentList.get(i).average)
                MaxAverage = studentList.get(i);
        }

        return MaxAverage;
    }

    public static Student oldestStudent(){
        if (studentList.size() == 0) return null;
        Student oldestStudent = studentList.get(0);
        for(int i=1; i<studentList.size(); i++)
        {
            if(oldestStudent.getAge()<studentList.get(i).getAge())
                oldestStudent = studentList.get(i);
        }

        return oldestStudent;
    }

    public static Student youngestStudent(){
        if (studentList.size() == 0) return null;
        Student youngestStudent = studentList.get(0);
        for(int i=1; i<studentList.size(); i++)
        {
            if(youngestStudent.getAge()>studentList.get(i).getAge())
                youngestStudent = studentList.get(i);
        }

        return youngestStudent;
    }


    public static boolean oldestWithYoungest(){

        if(studentList.isEmpty()) return false;

        int youngestID = 0;
        int oldestID = 0;

        for(int i=0; i<studentList.size(); i++){
            if(studentList.get(youngestID).getAge()>studentList.get(i).getAge())
                youngestID = i;

            else if(studentList.get(oldestID).getAge()<studentList.get(i).getAge())
                oldestID = i;
        }

        if(youngestID == oldestID) return false;

        Student buffer = studentList.get(youngestID);

        studentList.set(youngestID, studentList.get(oldestID));
        studentList.set(oldestID, buffer);

        return true;
    }

    public Student() {
        studentList.add(this);
    }

    @Override
    public String toString() {
        return super.toString() + "School: " + this.school + "\nProfile: " + " " + this.profile + "\nStart date: " + this.startDate
                + "\nHas been learning for: " + String.format("\n%5.2f",educationLength()) + " years"
                + String.format("\nAverage:   %5.2f",average);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getSurname(), student.getSurname()) && Objects.equals(getName(), student.getName()) &&
                Objects.equals(getBirthDate(), student.getBirthDate());
    }

}
