/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2_zaira.controllers;

import com.mycompany.practica2_zaira.beans.StudentBean;
import com.mycompany.practica2_zaira.entities.Student;
import java.io.Serializable;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class StudentController implements Serializable{
    @Inject
    private Student student;
    
    @EJB
    private StudentBean studentBean;
    
    private List<Student> studentList;
    
    public List<Student> getStudentList(){
        return this.studentList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    
   
    public String  saveStudent() {
        try {
            studentBean.saveStudent(student);
        } catch (Exception e){
            return "error";
        }
        return getStudents();
    }
    
    public String getStudents(){
        studentList = studentBean.getStudents();       
        return "information";
    }
    
    public String deleteStudent(Long studentId) {
        try {
            studentBean.deleteStudentId(studentId);
        } catch (Exception e) {
            return "error";
        }
        return getStudents();
    }
    
    public String editStudent(Student student) {
        this.student = student;
        return "index"; // Redirige a la página donde puedes editar el estudiante.
    }
    
    
}