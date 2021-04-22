import java.util.Iterator;
import java.util.Vector;

class Student{
    private Vector<Transcript> transcripts;
    private String name;

    public Student(String name){
        this.name=name;
        transcripts=new Vector<Transcript>();
    }
    public void addTranscript(Transcript transcript){
        transcripts.add(transcript);
    }
    public Vector<Course> getCourses() {
        Vector<Course> courses = new Vector<Course>();
        Iterator<Transcript> itor = transcripts.iterator();

        while (itor.hasNext()) {
            Transcript tr = itor.next();
            courses.add(tr.getCourse());
        }
        return courses;
    }
}
class Transcript{
    private Student student;
    private Course course;
    private String date;
    private String grade;

    public Transcript(Student student, Course course){
        this.student=student;
        this.course=course;
        this.student.addTranscript(this);
        this.course.addTranscript(this);

    }
    public Student getStudent(){
        return student;
    }
    public Course getCourse(){
        return course;
    }

    public void setDate(String date){
        this.date=date;
    }
    public String getDate(){
        return date;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
    public String getGrade(){
        return date;
    }

}

class Course{
    private Vector<Transcript> transcripts;
    private String name;

    public Course(String name){
        this.name=name;
        transcripts=new Vector<Transcript>();
    }
    public void addTranscript(Transcript transcript){
        transcripts.add(transcript);
    }
    public String getName(){
        return name;
    }
    public Vector<Student> getStudents() {
        Vector<Student> students = new Vector<Student>();
        Iterator<Transcript> itor = transcripts.iterator();

        while (itor.hasNext()) {
            Transcript tr = itor.next();
            students.add(tr.getStudent());
        }
        return students;
    }
}
public class chap1{
    public static void main(String[] args){
        Student s1 = new Student("manSup");
        Student s2 = new Student("gilDong");
        Course se = new Course("Software Engineering");
        Course designPattern = new Course("Design Pattern");

        Transcript t1 = new Transcript(s1, se);
        Transcript t2 = new Transcript(s1 ,designPattern);
        Transcript t3 = new Transcript(s2, designPattern);

        t1.setDate("2012");
        t1.setGrade("B0");
        t2.setDate("2013");;
        t2.setGrade("D+");

        Vector<Course> courses;
        courses = s1.getCourses();
        for(int i=0;i<courses.size();i++){
            System.out.println(courses.get(i).getName());
        }
    }
}
