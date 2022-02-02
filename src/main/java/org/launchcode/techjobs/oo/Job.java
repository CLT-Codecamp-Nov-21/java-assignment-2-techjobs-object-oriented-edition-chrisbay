package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String name = this.name;
        String employer = this.employer.getValue();
        String location = this.location.getValue();
        String positionType = this.positionType.getValue();
        String coreCompetency = this.coreCompetency.getValue();

        if (name.equals("")) {
            name = "Data not available";
        }

        if (employer.equals("")) {
            employer = "Data not available";
        }

        if (location.equals("")) {
            location = "Data not available";
        }

        if (positionType.equals("")) {
            positionType = "Data not available";
        }

        if (coreCompetency.equals("")) {
            coreCompetency = "Data not available";
        }

        String str = "\n";
        str += "ID: " + this.getId() + "\n";
        str += "Name: " + name + "\n";
        str += "Employer: " + employer + "\n";
        str += "Location: " + location + "\n";
        str += "Position Type: " + positionType + "\n";
        str += "Core Competency: " + coreCompetency + "\n";

        return str;
    }
}
