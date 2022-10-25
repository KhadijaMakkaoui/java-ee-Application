package org.tuto.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.tuto.model.Student;

public class CreateStudent {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction= entityManager.getTransaction();

        entityTransaction.begin();

        Student student=new Student();
        student.setFirstName("Khadija");
        student.setLastName("Makkaoui");

        entityManager.persist(student);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

}
