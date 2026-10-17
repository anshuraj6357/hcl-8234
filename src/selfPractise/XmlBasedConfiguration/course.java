package selfPractise.XmlBasedConfiguration.pom;

public class course {
    private String courseName;
    private String courseID;
    private String courseDescription;
    private String courseType;


    //parameterised constructor
    public  course(String courseName, String courseID, String courseDescription, String courseType) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseDescription = courseDescription;
        this.courseType = courseType;
    }
    //getter
    public String getCourseName() {
        return courseName;
    }
    public String getCourseID() {
        return courseID;
    }
    public String getCourseDescription() {
        return courseDescription;
    }
    public String getCourseType() {
        return courseType;
    }
    //setter
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String toString(){
        return this.courseName+" "+this.courseID+" "+this.courseDescription+" "+this.courseType;
    }

}
