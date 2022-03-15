package shanker.assignment.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String args[]){
        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try{


            Instructor tempInstructor = new Instructor("Vineet","Garikapati","vineet.g@zemosolabs.com");
            InstructorDetail tempDetails = new InstructorDetail("http://youtube.com","eating");

            //associating the objects
            tempInstructor.setInstructorDetail(tempDetails);

            //Start the transaction
            session.beginTransaction();

            //Save the instructor:
            session.save(tempInstructor);

            //commit the transaction:
            session.getTransaction().commit();


        }finally {

            session.close();
            factory.close();
        }


    }
}
