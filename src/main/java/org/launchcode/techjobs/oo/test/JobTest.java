package org.launchcode.techjobs.oo.test;

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
        Job job = new Job();
        Job anotherJob = new Job();
        assertNotEquals(job.getId(), anotherJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertEquals("Product tester", job.getName());

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job = new Job("Job Name",
                new Employer("An employer"),
                new Location("some place"),
                new PositionType("a job"),
                new CoreCompetency("stuff"));

        Job anotherJob = new Job(job.getName(), job.getEmployer(), job.getLocation(), job.getPositionType(), job.getCoreCompetency());

        assertFalse(job.equals(anotherJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Job Name",
                new Employer("An employer"),
                new Location("some place"),
                new PositionType("a job"),
                new CoreCompetency("stuff"));

        String jobString = job.toString();
        assertEquals('\n', jobString.charAt(0));
        assertEquals('\n', jobString.charAt(jobString.length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Job Name",
                new Employer("An employer"),
                new Location("some place"),
                new PositionType("a job"),
                new CoreCompetency("stuff"));

        String jobString = job.toString();
        String expected = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",job.getId(), job.getName(), job.getEmployer(), job.getLocation(),
                job.getPositionType(), job.getCoreCompetency());

        assertEquals(expected, jobString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Job Name",
                new Employer("An employer"),
                new Location("some place"),
                new PositionType("a job"),
                new CoreCompetency("stuff"));

        String jobString = job.toString();
        String expected = "";

        assertEquals(jobString, jobString);
    }

}
