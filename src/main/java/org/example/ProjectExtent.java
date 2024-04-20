package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProjectExtent {
    private final List<Project> EXTENT = new ArrayList<>();

    public void addProject(Project project) {
        EXTENT.add(project);
    }

    public List<Project> getProjects() {
        return EXTENT;
    }
}
