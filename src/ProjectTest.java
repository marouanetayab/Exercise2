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
    Project simpleProject;

    @Before
    public void setUp() {
        simpleProject = new Project(new String[]{"A", "B", "C"});
    }

    @Test
    public void isWellSorted_withEmptyTasksAndQueue_returnsTrue() {
        Project emptyProject = new Project();
        assertTrue(emptyProject.isWellSorted(new String[]{}));
    }

    @Test
    public void isWellSorted_withTasksAndEmptyQueue_returnsFalse() {
        assertFalse(simpleProject.isWellSorted(new String[]{}));
    }
}