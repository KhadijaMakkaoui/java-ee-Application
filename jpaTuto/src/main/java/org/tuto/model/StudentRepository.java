package org.tuto.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentRepository {
    private EntityManager entityManager;
    private EntityManagerFactory emf;
    public StudentRepository(){
        this.emf= Persistence.createEntityManagerFactory("student_pu");
        this.entityManager=this.emf.createEntityManager();
    }

    public Student add(Student student){
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }
    public Student find(Long id){
        return entityManager.find(Student.class,id);
    }
    public Student update(Student student){
        Student studentToUpdate=find(student.getId());
        entityManager.getTransaction().begin();
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        entityManager.getTransaction().commit();
        return studentToUpdate;
    }
    public void delete(Student student){
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }
    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
}
