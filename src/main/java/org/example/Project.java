package org.example;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.Utils.checkIfNull;

public class Project implements Serializable {
    private String name;
    private String description;
    private BigDecimal budget;
    private Date startDate;
    private Date endDate;
    private List<String> technologies;

    private static long maximumDuration;
    private static final ProjectExtent EXTENT = new ProjectExtent();

    public Project(String name, String description, BigDecimal budget, Date startDate, Date endDate,
                   List<String> technologies) {
        checkIfNull(name, description, budget, startDate, endDate, technologies);
        
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
        this.technologies = technologies;
        
        EXTENT.addProject(this);
    }

    public Project(String name, BigDecimal budget, Date startDate, Date endDate,
                   List<String> technologies) {
        checkIfNull(name, budget, startDate, endDate, technologies);
        
        this.name = name;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
        this.technologies = technologies;
        
        EXTENT.addProject(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkIfNull(name);
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        checkIfNull(budget);
        this.budget = budget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        checkIfNull(startDate);
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        checkIfNull(endDate);
        this.endDate = endDate;
    }

    public long getDuration() {
        return (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        checkIfNull(technologies);
        this.technologies = technologies;
    }
    
    public void addTechnology(String technology) {
        checkIfNull(technology);
        technologies.add(technology);
    }
    
    public void removeTechnology(String technology) throws Exception {
        if (technologies.size() == 1) {
            throw new Exception("A project requires at least 1 technology associated with it.");
        }
        technologies.remove(technology);
    }

    public static long getMaximumDuration() {
        return maximumDuration;
    }

    public static void setMaximumDuration(long maximumDuration) {
        checkIfNull(maximumDuration);
        Project.maximumDuration = maximumDuration;
    }
    
    public static List<Project> getExtent() {
        return new ArrayList<>(EXTENT.getProjects());
    }
    
    public static List<Project> findProjectsUsingTechnology(List<Project> projectExtent, String technology) {
        List<Project> matchingProjects = new ArrayList<>();
        for (Project project : projectExtent) {
            if (project.getTechnologies().contains(technology)) {
                matchingProjects.add(project);
            }
        }
        return matchingProjects;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", budget=" + budget +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", technologies=" + technologies +
                '}';
    }
}
