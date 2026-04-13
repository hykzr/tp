package seedu.interntrack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


public class ApplicationTest {

    @Test
    public void equals_exactMatchCompanyAndRole_isDuplicate() {
        Application app1 = new Application("Google", "Software Engineer", null, null);
        Application app2 = new Application("Google", "Software Engineer", null, null);
        assertTrue(app1.equals(app2));
    }

    @Test
    public void equals_uppercaseCompanyAndRole_isDuplicate() {
        Application app1 = new Application("Google", "Software Engineer", null, null);
        Application app2 = new Application("GOOGLE", "SOFTWARE ENGINEER", null, null);
        assertTrue(app1.equals(app2));
    }

    @Test
    public void equals_extraSpacesInCompanyAndRole_isDuplicate() {
        Application app1 = new Application("Google", "Software Engineer", null, null);
        Application app2 = new Application("  Google  ", "  Software   Engineer  ", null, null);
        assertTrue(app1.equals(app2));
    }

    @Test
    public void equals_differentCompany_notDuplicate() {
        Application app1 = new Application("Google", "Software Engineer", null, null);
        Application app2 = new Application("Microsoft", "Software Engineer", null, null);
        assertFalse(app1.equals(app2));
    }

    @Test
    public void equals_differentRole_notDuplicate() {
        Application app1 = new Application("Google", "Software Engineer", null, null);
        Application app2 = new Application("Google", "Data Analyst", null, null);
        assertFalse(app1.equals(app2));
    }

    @Test
    public void equals_bothDeadlineNull_isDuplicate() {
        Application app1 = new Application("Google", "Software Engineer", null, null);
        Application app2 = new Application("Google", "Software Engineer", null, null);
        assertTrue(app1.equals(app2));
    }

    @Test
    public void equals_oneDeadlineNullOtherNot_notDuplicate() {
        LocalDate deadline = LocalDate.parse("2025-05-01");
        Application app1 = new Application("Google", "Software Engineer", deadline, null);
        Application app2 = new Application("Google", "Software Engineer", null, null);
        assertFalse(app1.equals(app2));
    }

    @Test
    public void equals_sameDeadline_isDuplicate() {
        LocalDate deadline = LocalDate.parse("2025-05-01");
        Application app1 = new Application("Google", "Software Engineer", deadline, null);
        Application app2 = new Application("Google", "Software Engineer", deadline, null);
        assertTrue(app1.equals(app2));
    }

    @Test
    public void equals_differentDeadlines_notDuplicate() {
        LocalDate deadline1 = LocalDate.parse("2025-05-01");
        LocalDate deadline2 = LocalDate.parse("2025-06-01");
        Application app1 = new Application("Google", "Software Engineer", deadline1, null);
        Application app2 = new Application("Google", "Software Engineer", deadline2, null);
        assertFalse(app1.equals(app2));
    }

    @Test
    public void equals_deadlineBoundaryDifferenceByOneDay_notDuplicate() {
        LocalDate deadline1 = LocalDate.parse("2025-01-01");
        LocalDate deadline2 = LocalDate.parse("2025-01-02");
        Application app1 = new Application("Shopee", "Backend Intern", deadline1, null);
        Application app2 = new Application("Shopee", "Backend Intern", deadline2, null);
        assertFalse(app1.equals(app2));
    }

    @Test
    public void equals_differentContact_isDuplicate() {
        Application app1 = new Application("Google", "SWE", null, "John");
        Application app2 = new Application("Google", "SWE", null, "Jane");
        assertTrue(app1.equals(app2));
    }

    @Test

    public void equals_veryLongCompanyName_isDuplicate() {
        String longName = "A".repeat(1000);
        Application app1 = new Application(longName, "Role", null, null);
        Application app2 = new Application(longName, "Role", null, null);
        assertTrue(app1.equals(app2));
    }

    @Test
    public void equals_specialCharactersInCompanyAndRole_isDuplicate() {
        Application app1 = new Application("Google@#$!", "Software-Engineer/Manager", null, null);
        Application app2 = new Application("Google@#$!", "Software-Engineer/Manager", null, null);
        assertTrue(app1.equals(app2));
    }

    @Test
    public void equals_unicodeCharactersInCompanyAndRole_isDuplicate() {
        Application app1 = new Application("Google 日本", "ソフトウェアエンジニア", null, null);
        Application app2 = new Application("Google 日本", "ソフトウェアエンジニア", null, null);
        assertTrue(app1.equals(app2));
    }

    @Test
    public void equals_nullOtherApplication_notDuplicate() {
        Application app1 = new Application("Google", "Software Engineer", null, null);
        assertFalse(app1.equals(null));
    }
    
    @Test
    public void equals_caseInsensitiveWithExtraSpacesAndDifferentContact_isDuplicate() {
        LocalDate deadline = LocalDate.parse("2026-04-15");
        Application app1 = new Application("Google", "Software Engineer", deadline, "Alice");
        Application app2 = new Application("  GOOGLE  ", "  SOFTWARE   ENGINEER  ", deadline, "Bob");
        assertTrue(app1.equals(app2));
    }

    @Test
    public void equals_complexScenarioMultipleDifferences_notDuplicate() {
        LocalDate deadline1 = LocalDate.parse("2026-04-15");
        LocalDate deadline2 = LocalDate.parse("2026-05-15");
        Application app1 = new Application("Google", "Software Engineer", deadline1, "Alice");
        Application app2 = new Application("Google", "Software Engineer", deadline2, "Bob");
        assertFalse(app1.equals(app2));
    }

}
