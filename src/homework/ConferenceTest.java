package homework;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ConferenceTest {

    // TODO: Add tests here!
    private final int capacity=100;
    private List<Student> attendees;
    private final Conference conferenceTesting=new Conference(capacity);
    private final Conference bigConferenceTesting=new Conference(10000);

    @Test
    public void testCalculateEmtTicketPriceWithDiscount(){

        Student student1=new Student("A","M",Course.EMT,24);
        Student student2=new Student("J","C",Course.EMT,23);
        conferenceTesting.getAttendees().add(student1);
        conferenceTesting.getAttendees().add(student2);
        double totalPricePaid=conferenceTesting.calculateTotalPricePaid();
        Assertions.assertEquals(2 * Conference.TICKET_PRICE * (1 - Conference.EMT_DISCOUNT),totalPricePaid,0);

    }
    @Test
    public void testCalculateWpTicketPriceWithDiscount(){

        Student student3=new Student("R","S",Course.WEB,24);
        Student student4=new Student("T","K",Course.WEB,23);
        conferenceTesting.getAttendees().add(student3);
        conferenceTesting.getAttendees().add(student4);
        double totalPricePaid=conferenceTesting.calculateTotalPricePaid();
        Assertions.assertEquals(2 * Conference.TICKET_PRICE * (1 - Conference.WEB_DISCOUNT),totalPricePaid,0);
    }
    @Test
    public void testCalculateOSTicketPriceNoDiscount(){

        Student student111=new Student("A","M",Course.OS,24);
        student111.setName("A");
        student111.setSurname("M");
        student111.setCourse(Course.OS);
        student111.setAge(24);
        conferenceTesting.getAttendees().add(student111);
        double totalPricePaid=conferenceTesting.calculateTotalPricePaid();
        Assertions.assertEquals( Conference.TICKET_PRICE,totalPricePaid,0);
    }

    @Test
    public void testGetAttendees(){
        Student student1=new Student("A","M",Course.OS,24);
        conferenceTesting.getAttendees().add(student1);
        List<Student>attendees=conferenceTesting.getAttendees();
        Assertions.assertEquals(attendees.size(),conferenceTesting.getAttendees().size(),0);
    }
    @Test
    public void testGetStudentSurname(){
        Student student25=new Student("A","M",Course.OS,24);
        student25.getSurname();
        conferenceTesting.getAttendees().add(student25);
        Assertions.assertTrue(student25.getSurname().equals("M"));
    }
    @Test
    public void testGetStudentName(){
        Student student26=new Student("A","M",Course.OS,24);
        student26.getName();
        conferenceTesting.getAttendees().add(student26);
        Assertions.assertTrue(student26.getName().equals("A"));
    }
    @Test
    public void testGetStudentAge(){
        Student student27=new Student("A","M",Course.OS,24);
        student27.getName();
        conferenceTesting.getAttendees().add(student27);
        Assertions.assertTrue(student27.getAge()==24);
    }
    @Test
    public void testToString(){
        Student s=new Student("A","A",Course.WEB,23);
        String studentString=s.toString();
        String expectedString="Student{name='A', surname='A', course=WEB, age=23}";
        Assertions.assertEquals(expectedString,studentString);
    }
    @Test
    public void testTripleCapacity(){
        int initialCapacity = 100;
        Conference conference = new Conference(initialCapacity);
        boolean capacityTripled = conference.tripleCapacity();
        Assertions.assertTrue(capacityTripled);
        int updatedCapacity = conference.getCapacity();
        int expectedCapacity = initialCapacity * 3;
        Assertions.assertEquals(expectedCapacity, updatedCapacity);
    }
    @Test
    public void exceededCapacity(){
        int c=3333;
        Conference conference=new Conference(c);
        boolean tripleCapacity=conference.tripleCapacity();
        Assertions.assertTrue(tripleCapacity);
    }
    @Test
    public void testSuccessfulAddAttendee(){
        Student student12=new Student("A","M",Course.WEB,24);
        boolean added=conferenceTesting.addAttendeeToConference(student12);
        Assertions.assertTrue(added);
    }
    @Test
    public void testUnsuccessfulAddAttendee(){
        for(int i=0;i<10000;i++) {
            Student student120 = new Student("A", "M", Course.WEB, 24);
            bigConferenceTesting.getAttendees().add(student120);
        }
        Student student121=new Student("M","A",Course.SKIT,22);
        boolean added=bigConferenceTesting.addAttendeeToConference(student121);
        Assertions.assertFalse(added);
    }
    @Test
    public void testGetCapacity(){
        int capacity=100;
        Conference conference=new Conference(capacity);
        int actualCapacity=conference.getCapacity();
        Assertions.assertEquals(capacity,actualCapacity,0);
    }

}

