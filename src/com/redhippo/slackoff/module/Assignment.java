package com.redhippo.slackoff.module;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 25/11/13
 * Time: 11:06
 * To change this template use File | Settings | File Templates.
 */
public class Assignment extends MultiAlias {

    /**
     * The module the assignment belongs to
     */
    private Module module;

    private float percentageOfCoursework;

    /**
     * Can be null if haven't received a grade
     */
    private Float percentageGradeAchieved;


    public Assignment() {
         super();
        percentageGradeAchieved = null;
    }

    public void setPercentageOfCoursework(float percentageOfCoursework) {
        this.percentageOfCoursework = percentageOfCoursework;
    }

    public void setPercentageGradeAchieved(float percentageGradeAchieved) {
        this.percentageGradeAchieved = percentageGradeAchieved;
    }

    public Float getPercentageGradeAchieved() {
        return percentageGradeAchieved;
    }

    public boolean hasRecievedGrade() {
        return percentageGradeAchieved != null;
    }

    public Float getPercentageOfCoursework() {
        return percentageOfCoursework;
    }
}
