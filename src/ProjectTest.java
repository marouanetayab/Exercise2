import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * B02A02
 *
 * @author Johannes Heimbach
 * 21.10.17.
 */
public class ProjectTest {
    private Project simpleProject, complexProject;

    @Before
    public void setUp() {
        simpleProject = new Project(new String[][]{{"A", "B"}, {"B", "C"}});
        complexProject = new Project(
                new String[][]{
                        {"A", "C"}, {"C", "D"}, {"B", "C"},
                        {"A", "E"}, {"B", "F"}, {"E", "G"},
                        {"D", "G"}, {"F", "G"}, {"C", "E"},
                        {"C", "F"}
                }
        );
    }

    @Test
    public void classHasInterfaceProjectInterfaceImplemented() {
        assertTrue(new Project(new String[][]{}) instanceof ProjectInterface);
    }

    @Test
    public void isWellSorted_withEmptyTasksAndQueue_returnsTrue() {
        Project emptyProject = new Project(new String[][]{});
        assertTrue(emptyProject.isWellSorted(new String[]{}));
    }

    @Test
    public void isWellSorted_withTasksAndEmptyQueue_returnsFalse() {
        assertFalse(simpleProject.isWellSorted(new String[]{}));
    }

    @Test
    public void isWellSorted_simpleProjectWellSortedInput_returnsTrue() {
        assertTrue(simpleProject.isWellSorted(new String[]{"A", "B", "C"}));
    }

    @Test
    public void isWellSorted_simpleProjectNotWellSortedInput_returnsFalse() {
        assertFalse(simpleProject.isWellSorted(new String[]{"B", "A", "C"}));
    }

    @Test
    public void isWellSorted_complexProjectWellSortedInput_returnsTrue() {
        assertTrue(complexProject.isWellSorted(new String[]{"A", "C"}));
        assertTrue(complexProject.isWellSorted(new String[]{"A", "E"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "C"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "F"}));
        assertTrue(complexProject.isWellSorted(new String[]{"A", "C", "D"}));
        assertTrue(complexProject.isWellSorted(new String[]{"A", "C", "E"}));
        assertTrue(complexProject.isWellSorted(new String[]{"A", "C", "F"}));
        assertTrue(complexProject.isWellSorted(new String[]{"A", "E", "G"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "C", "E"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "A", "C"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "C", "D"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "C", "F"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "F", "G"}));
        assertTrue(complexProject.isWellSorted(new String[]{"A", "C", "D", "G"}));
        assertTrue(complexProject.isWellSorted(new String[]{"A", "C", "E", "G"}));
        assertTrue(complexProject.isWellSorted(new String[]{"A", "C", "F", "G"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "C", "E", "G"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "C", "D", "G"}));
        assertTrue(complexProject.isWellSorted(new String[]{"B", "C", "F", "G"}));
    }

    @Test
    public void isWellSorted_complexProjectNotWellSortedInput_returnsFalse() {
        assertFalse(complexProject.isWellSorted(new String[]{"A", "G", "F"}));
        assertFalse(complexProject.isWellSorted(new String[]{"E", "C", "B"}));
    }
}