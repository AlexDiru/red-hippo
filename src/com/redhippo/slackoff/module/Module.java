package com.redhippo.slackoff.module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 25/11/13
 * Time: 10:53
 * To change this template use File | Settings | File Templates.
 */
public class Module extends MultiAlias {

    private String code;

    private int credits;
    private int assessedCourseworkPercent;
    private int assessedExamPercent;
    private List<Assignment> assignments;

    public Module() {
        super();
        assignments = new ArrayList<Assignment>();
    }

    /**
     * The user searches via a parameter, this checks whether this module matches the parameter
     * @param searchQuery The data the user searched for MUST BE LOWERCASE
     * @return
     */
    public boolean matchesQuery(String searchQuery) {
        for (int i = 0; i < names.size(); i++)
            if (names.get(i).toLowerCase().contains(searchQuery))
                return true;
        return false;
    }

    public void setCourseworkExamWeighting(int assessedCourseworkPercent, int assessedExamPercent) {
        this.assessedCourseworkPercent = assessedCourseworkPercent;
        this.assessedExamPercent = assessedExamPercent;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    private float calculateAverageGrade(List<Assignment> assignments) {
        float totalGrade = 0;
        for (int i = 0; i < assignments.size(); i++)
            try {
                totalGrade += (float)assignments.get(i).getPercentageGradeAchieved();
            } catch (Exception ex) {
                //Catch and ignore
            }
        return totalGrade/assignments.size();
    }

    public void predictFor(float target) {
        System.out.println("To achieve a " + target + " in " + names.get(0));

        List<Assignment> completedAssignments = new ArrayList<Assignment>();
        List<Assignment> incompleteAssignments = new ArrayList<Assignment>();

        for (int i = 0; i < assignments.size(); i++)
            if (assignments.get(i).hasRecievedGrade())
                completedAssignments.add(assignments.get(i));
            else
                incompleteAssignments.add(assignments.get(i));

        if (completedAssignments.size() == 0) {
            System.out.println("No grades have been recieved so you will need to attain " + target + " in everything");
            return;
        }

        float averageGrade = calculateAverageGrade(completedAssignments);

        float courseWorkPercent = 0;

        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).hasRecievedGrade()) {
                System.out.println("Received " + assignments.get(i).getPercentageGradeAchieved() + " in " + assignments.get(i).getName(0));
                courseWorkPercent += (assignments.get(i).getPercentageGradeAchieved() * assignments.get(i).getPercentageOfCoursework())/100;
            } else {
                System.out.println("Predicting " + averageGrade + " in " + assignments.get(i).getName(0));
                courseWorkPercent += (averageGrade * assignments.get(i).getPercentageOfCoursework())/100;
            }
        }

        System.out.println("coursework % is " + courseWorkPercent);

        float totalMarkOfModuleSoFar = (courseWorkPercent/100)*assessedCourseworkPercent;

        System.out.println("total mark of module so mark = " + totalMarkOfModuleSoFar);
        int examResultNeeded = (int) Math.ceil(((target - totalMarkOfModuleSoFar) / assessedExamPercent) * 100);

        if (examResultNeeded < 0)
            System.out.println("You don't need to sit the exam!! (But we would advise you to...)");
        else
            System.out.println("grade to get in exam to achieve " + target + " = " + examResultNeeded);

    }
}
