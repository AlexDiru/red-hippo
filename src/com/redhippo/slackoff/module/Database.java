package com.redhippo.slackoff.module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 25/11/13
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
public class Database {

    private static List<AcademicYear> years;

    public static void load() {
        years = new ArrayList<AcademicYear>();

        //Setup with test data
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

        AcademicYear academicYear = new AcademicYear();
        academicYear.setYear(3);
        academicYear.addModule(vr);

        AcademicYear academicYear2 = new AcademicYear();
        academicYear2.setYear(2);

        years.add(academicYear);
        years.add(academicYear2);
    }

    public static List<AcademicYear> getYears() {
        return years;
    }
}
