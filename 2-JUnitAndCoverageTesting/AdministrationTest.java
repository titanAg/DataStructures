import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * The JUnit test class for the administration class. For this one we included two tests
 * for each method to adequately test them for the expected return values and corner cases
 */
public class AdministrationTest {
    Administration admin = new Administration();

    UniClass COSC222;
    UniClass MATH200;

    Teacher Andrew;
    Teacher Jenn;

    Student bill;
    Student ben;
    Student bob;

    @Before
    public void initialize() throws Exception{
        //set up objects so we can test the methods of the Administration Class

        bob = new Student(18, "Bob Maher", new String []{"COSC 222","COSC 311", "MATH 200", "MATH 220"});
        bill = new Student(19, "Billy Jean", new String []{"COSC 222", "COSC 404", "ENGL 112"});
        ben = new Student(24, "Ben Mckenny", new String []{"COSC 222", "COSC 111", "MATH 200", "PHYS 101"});

        Andrew = new Teacher(36,"Andrew Peterson",  new String []{"COSC 222", "COSC 404", "COSC 111"}, "Computer Science");
        Jenn = new Teacher(36,"Jay Low",  new String []{"MATH 200", "MATH 220"}, "Mathematics");

        COSC222 = new UniClass(new Student[]{bob,bill,ben}, Andrew, "COSC 222");
        MATH200 = new UniClass(new Student[]{bob,ben}, Jenn, "MATH 200");
    }

    @Test
    public void testIntersection1() throws Exception{
        ArrayList<Student> list = new ArrayList<>(Arrays.asList(bob, ben));

        ArrayList<Student> results = admin.intersection(COSC222.getStudents(), MATH200.getStudents());
        assertTrue(list.containsAll(results) && results.containsAll(list));
    }


    @Test
    public void testIntersection2(){
        //TODO: alter the intersection method in Administration.java to account for the test failing
        ArrayList<Student> list = new ArrayList<>(Arrays.asList(bob,ben));

        ArrayList<Student> results = admin.intersection(COSC222.getStudents(),new Student[]{});
        assertTrue(results == null);

    }

    @Test
    public void testListStudents1() throws Exception{
    	ArrayList<Student> list = new ArrayList<>(Arrays.asList(bob,ben));
    	ArrayList<Student> results = admin.listStudents(MATH200, 'M');
    	
        assertTrue(list.equals(results));
    }

    @Test
    public void testListStudents2() throws Exception{
    	ArrayList<Student> list = new ArrayList<>(Arrays.asList(bob,ben));
    	ArrayList<Student> results = admin.listStudents(MATH200, 'O');
    	
        assertTrue(!list.equals(results));
    }

}