package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobConstructorTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobConstructorTest instanceof Job);
        assertTrue(jobConstructorTest.getEmployer() instanceof Employer);
        assertTrue(jobConstructorTest.getLocation() instanceof Location);
        assertTrue(jobConstructorTest.getPositionType() instanceof PositionType);
        assertTrue(jobConstructorTest.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", jobConstructorTest.getName());
        assertEquals("ACME", jobConstructorTest.getEmployer().getValue());
        assertEquals("Desert", jobConstructorTest.getLocation().getValue());
        assertEquals("Quality control", jobConstructorTest.getPositionType().getValue());
        assertEquals("Persistence", jobConstructorTest.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobEquality1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobEquality2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertFalse(jobEquality2.equals(jobEquality1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobStringTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char line[] = jobStringTest.toString().toCharArray();
        assertEquals('\n', line[line.length-1]);
        assertEquals('\n', line[0]);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobResponseTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String response = "\n" +
                "ID: " + jobResponseTest.getId() + "\n" +
                "Name: " + jobResponseTest.getName() + "\n" +
                "Employer: " + jobResponseTest.getEmployer() + "\n" +
                "Location: " + jobResponseTest.getLocation() + "\n" +
                "Position Type: " + jobResponseTest.getPositionType() + "\n" +
                "Core Competency: " +jobResponseTest.getCoreCompetency() + "\n";
        assertEquals(jobResponseTest.toString(), response);
    }

    //test below not completed, only copy/pasted from above
    @Test
    public void testToStringHandlesEmptyField() {
        Job jobEmptyField = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String response = "\n" +
                "ID: " + jobEmptyField.getId() + "\n" +
                "Name: " + jobEmptyField.getName() + "\n" +
                "Employer: " + jobEmptyField.getEmployer() + "\n" +
                "Location: " + jobEmptyField.getLocation() + "\n" +
                "Position Type: " + jobEmptyField.getPositionType() + "\n" +
                "Core Competency: " +jobEmptyField.getCoreCompetency() + "\n";
        assertEquals(jobEmptyField.toString(), response);
    }

}

