package com.pythagorithm.mathsmartv2.AppLogic;

import java.util.ArrayList;
import java.util.HashMap;

import com.pythagorithm.mathsmartv2.DatabaseConnector.DatabaseConnector;

/**
 * Created by H_Abb on 11/4/2017.
 */

public class Teacher extends User{
    private String teacherID;
    private String[] sectionList;
    private DatabaseConnector dc;
    private ArrayList<Assignment> availableAssignments;
    private String sectionID;
    private Question question;

    //Constructor
    public Teacher(String username){
        super(username);
        teacherID=super.userID;
        this.dc=new DatabaseConnector(teacherID);
    }

    //Getters and setters
    public String getTeacherID() {return teacherID;}
    public void setTeacherID(String teacherID) {this.teacherID = teacherID;}
    public String[] getSectionList() {return sectionList;}
    public void setSectionList(String[] sectionList) {this.sectionList = sectionList;}
    public String getSectionID() {return sectionID;}
    public void setSectionID(String sectionID) {this.sectionID = sectionID;}
    public Question getQuestion() {return question;}
    public void setQuestion(Question question) {this.question = question;}


    //=========================================================================================================================
    //QUESTIONS
    //=========================================================================================================================
    public ArrayList<Question> getAvailableQuestions(String topic, String sectionID){
        return dc.getAvailableQuestions(topic,sectionID);
    }
    public void createQuestion(String qStatement, String correctAnswer,String wrongAnswer, String topic, int weight){
        Question q=new Question(topic,qStatement,correctAnswer, wrongAnswer, weight);
        dc.addQuestion(q);
    }
//    public Question editQuestion(String questionID){
//        return getQuestion(questionID);
//    }
    public void updateQuestion(Question question){
        dc.updateQuestion(question);
    }
//    private String addQuestion(Question q){
//        return dc.addQuestion(q);
//    }
//    private Question getQuestion(String questionID) {
//        return dc.getQuestion(questionID);
//    }
    //=========================================================================================================================
    //ASSIGNMENTS
    //=========================================================================================================================
//    public ArrayList<Assignment> getAssignments(String sectionID){
//        //return dc.getAvailableAssignments(sectionID);
//    }
    public void createAssignment(String name, String topic, int numQuestions, String dueDate, String submissionPeriod, HashMap<String, Boolean> sectionList){
        Assignment a= new Assignment(name, topic, numQuestions, dueDate,submissionPeriod, sectionList);
        dc.addAssignment(a);
    }
//    public Assignment editAssignment(String sectionID){
//        for(Assignment a:availableAssignments)
//            for(String secID:a.getSectionList())
//                if(secID==sectionID)
//                    return a;
//        return null;
//    }
    public void updateAssignment(Assignment assignment){
        for(Assignment a:availableAssignments) {
            if(a.getAssignmentID()==assignment.getAssignmentID()){
                a=assignment;
            }
        }
    }
//    public String addAssignment(Assignment assignment){
//        return dc.addAssignment(assignment.getSectionList(),availableAssignments);
//    }
}
