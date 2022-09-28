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
        Job jobEmptyField = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        Assert.assertEquals(jobEmptyField.toString(),String.valueOf(jobEmptyField));
        Assert.assertTrue(jobEmptyField.getEmployer().getValue()=="Data not available");
        Assert.assertTrue(jobEmptyField.getLocation().getValue()=="Data not available");
        Assert.assertTrue(jobEmptyField.getCoreCompetency().getValue()=="Data not available");
        Assert.assertTrue(jobEmptyField.getPositionType().getValue()=="Data not available");
        Assert.assertEquals(String.valueOf(jobEmptyField),jobEmptyField.toString());
    }

}

