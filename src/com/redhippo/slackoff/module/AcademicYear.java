package com.redhippo.slackoff.module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 25/11/13
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
public class AcademicYear {

    private List<Module> modules;
    private int year;


    public AcademicYear() {
        modules = new ArrayList<Module>();
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public static void main(String args[]) {
        /*Module slease = new Module();
        slease.addName("SLEASE");
        slease.addName("Social Legal Ethical Aspects Of Software Engineering");
        slease.setCourseworkExamWeighting(100,0);
        slease.setCredits(10);

        Assignment assignment = new Assignment();
        assignment.addName("Group Project");
        assignment.setPercentageOfCoursework(40);       */

        Module vr = new Module();
        vr.addName("Virtual Reality");
        vr.addName("VR");
        vr.setCourseworkExamWeighting(30,70);
        vr.setCredits(10);

        Assignment d1 = new Assignment();
        d1.addName("D1");
        d1.setPercentageOfCoursework(10); //10% of 30%
        d1.setPercentageGradeAchieved(100);

        Assignment d2 = new Assignment();
        d2.addName("D2");
        d2.setPercentageOfCoursework(10);
        d2.setPercentageGradeAchieved(100);

        Assignment d3 = new Assignment();
        d3.addName("D3");
        d3.setPercentageOfCoursework(20);
        d3.setPercentageGradeAchieved(75);

        Assignment d4 = new Assignment();
        d4.addName("D4");
        d4.setPercentageOfCoursework(20);

        Assignment d5 = new Assignment();
        d5.addName("D5");
        d5.setPercentageOfCoursework(40);

        vr.addAssignment(d1);
        vr.addAssignment(d2);
        vr.addAssignment(d3);
        vr.addAssignment(d4);
        vr.addAssignment(d5);

        vr.predictFor(20);

        //AcademicYear academicYear = new AcademicYear();
        //academicYear.addModule();
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
