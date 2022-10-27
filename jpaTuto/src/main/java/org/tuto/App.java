package org.tuto;

import org.tuto.model.Student;
import org.tuto.model.StudentRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student student=new Student();
        student.setFirstName("hhh");
        student.setLastName("jjjj");

        StudentRepository repository=new StudentRepository();

        repository.add(student);
        System.out.println(student.toString());

        student=repository.find(student.getId());
        System.out.println("found student : "+student.toString());

        repository.update(student);
        System.out.println("updated: "+student.toString());

        repository.delete(student);

        System.out.println("Deleted student: "+ student.toString());
    }
}
