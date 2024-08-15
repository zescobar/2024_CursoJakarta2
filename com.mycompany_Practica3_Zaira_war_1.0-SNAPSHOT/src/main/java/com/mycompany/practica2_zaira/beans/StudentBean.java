
package com.mycompany.practica2_zaira.beans;

import com.mycompany.practica2_zaira.entities.Student;
import java.io.Serializable;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class StudentBean implements Serializable{
    
    @PersistenceContext
    private EntityManager entityManager;
              
    public void saveStudent(Student student) {        
        if (student.getStudentId() == null) {
            saveNewStudent(student);
        } else {
            updateStudent(student);
        }      
    }

    private void saveNewStudent(Student student) {
        entityManager.persist(student);
    }

    private void updateStudent(Student student) {
        entityManager.merge(student);
    }
    
    public Student getStudent(Long studentId) {
        Student student;

        student = entityManager.find(Student.class, studentId);

        return student;
    }
            
    public void deleteStudentObject(Student student) {
        entityManager.remove(student);
    }
    
    public void deleteStudentId(Long studentId) {
        try {
        Student student = entityManager.find(Student.class, studentId);
        if (student != null) {
            entityManager.remove(student);
        }
    } catch (Exception e) {
        
    }
    }
 
    public List<Student> getStudents() {
        List<Student> studentList=null;
        try {
            Query query = entityManager.createQuery("SELECT s FROM Students s", Student.class);
            studentList = query.getResultList();            
        } catch (Exception e) {         
        }
        
        return studentList;
    }
}