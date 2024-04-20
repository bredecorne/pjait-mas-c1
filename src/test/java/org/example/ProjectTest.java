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
    void testConstructorWithAllParameters() throws ParseException {
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
    void testConstructorWithBudgetAsNull() throws ParseException{
        String name = "Example";
        String description = "Description";
        Date startDate = createDate("2024-04-20");
        Date endDate = createDate("2024-04-30");
        List<String> technologies = List.of("Java", "Spring");

        assertThrows(NullPointerException.class, () -> new Project(
                name, description, null, startDate, endDate, technologies
        ));
    }
}