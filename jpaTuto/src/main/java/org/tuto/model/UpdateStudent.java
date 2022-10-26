package org.tuto.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateStudent {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();

        Student student=entityManager.find(Student.class,1L);
        System.out.println("Before :"+student.toString());

        entityTransaction.begin();

        student.setFirstName("hello");
        student.setLastName("World");


        entityTransaction.commit();

        System.out.println("After: "+student.toString());
        entityManager.close();
        entityManagerFactory.close();



    }
}
