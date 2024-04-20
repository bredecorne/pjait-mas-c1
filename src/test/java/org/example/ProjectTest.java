package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.example.Utils.createDate;
import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {
    @Test
    void projectCreatesSuccessfullyWhenAllParametersAreProvidedAndValid() throws ParseException {
        String name = "Example";
        String description = "Description"; 
        BigDecimal budget = new BigDecimal("35122.21");
        Date startDate = createDate("2024-04-20");
        Date endDate = createDate("2024-04-30");
        List<String> technologies = List.of("Java", "Spring");
        
        Project project = new Project(
                name, description, budget, startDate, endDate, technologies
        );

        assertAll(
                () -> assertEquals(name, project.getName()),
                () -> assertEquals(description, project.getDescription()),
                () -> assertEquals(budget, project.getBudget()),
                () -> assertEquals(startDate, project.getStartDate()),
                () -> assertEquals(endDate, project.getEndDate()),
                () -> assertEquals(technologies, project.getTechnologies())
        );
    }

    @Test
    void projectThrowsExceptionWhenBudgetIsNull() throws ParseException{
        String name = "Example";
        String description = "Description";
        Date startDate = createDate("2024-04-20");
        Date endDate = createDate("2024-04-30");
        List<String> technologies = List.of("Java", "Spring");

        assertThrows(NullPointerException.class, () -> new Project(
                name, description, null, startDate, endDate, technologies
        ));
    }

    @Test
    void projectReturnsCorrectlyCalculatedDuration() throws ParseException {
        String name = "Example";
        String description = "Description";
        BigDecimal budget = new BigDecimal("35122.21");
        Date startDate = createDate("2024-04-20");
        Date endDate = createDate("2024-04-30");
        List<String> technologies = List.of("Java", "Spring");

        Project project = new Project(
                name, description, budget, startDate, endDate, technologies
        );
        
        assertEquals(10, project.getDuration());
    }

    @Test
    void findProjectsUsingTechnologyReturnsValidListOfProjects() throws ParseException {
        Project p1 = new Project(
                "Example", "Description", new BigDecimal("35122.21"), 
                createDate("2024-04-20"), createDate("2024-04-30"), 
                List.of("Java", "Spring")
        );

        Project p2 = new Project(
                "Example", "Description", new BigDecimal("35122.21"),
                createDate("2024-04-20"), createDate("2024-04-30"),
                List.of("Java", "Spring", "Python", "SQL")
        );

        Project p3 = new Project(
                "Example", "Description", new BigDecimal("35122.21"),
                createDate("2024-04-20"), createDate("2024-04-30"),
                List.of("Python", "SQL")
        );
        
        assertEquals(
                List.of(p1, p2), Project.findProjectsUsingTechnology("Java")
        );
    }

    @Test
    void projectReturnsValidCopyOfItsExtent() throws ParseException {
        Project p1 = new Project(
                "Example", "Description", new BigDecimal("35122.21"),
                createDate("2024-04-20"), createDate("2024-04-30"),
                List.of("Java", "Spring")
        );

        Project p2 = new Project(
                "Example", "Description", new BigDecimal("35122.21"),
                createDate("2024-04-20"), createDate("2024-04-30"),
                List.of("Java", "Spring", "Python", "SQL")
        );

        Project p3 = new Project(
                "Example", "Description", new BigDecimal("35122.21"),
                createDate("2024-04-20"), createDate("2024-04-30"),
                List.of("Python", "SQL")
        );

        assertEquals(
                List.of(p1, p2, p3), Project.getExtent()
        );
    }
}