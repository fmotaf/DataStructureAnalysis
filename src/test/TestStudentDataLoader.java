package test;

import main.StudentData;
import main.StudentDataLoader;
import main.DoubleLinkedList;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestStudentDataLoader {

    private List<StudentData> toList(DoubleLinkedList list) {
        List<StudentData> result = new ArrayList<>();
        for (var link : list) {
            result.add(link.getData());
        }
        return result;
    }

    @Test
    void testLoadIntoDoubleLinkedList() {
        List<String[]> lines = new ArrayList<>();
        lines.add(new String[]{
                "studentId", "age", "gender", "studyHoursPerDay", "socialMediaHours", "netflixHours",
                "partTimeJob", "attendancePercentage", "sleepHours", "dietQuality", "exerciseFrequency",
                "parentalEducationLevel", "internetQuality", "mentalHealthRating", "extracurricularParticipation", "examScore"
        });
        lines.add(new String[]{
                "S1", "20", "M", "2.5", "1.0", "0.5", "true", "95.0", "7.0", "Good", "3",
                "High", "Excellent", "8", "false", "88.5"
        });

        DoubleLinkedList list = new DoubleLinkedList();
        StudentDataLoader.loadIntoDoubleLinkedList(lines, list);

        List<StudentData> students = toList(list);
        assertEquals(1, students.size());
        StudentData s = students.get(0);
        assertEquals("S1", s.getStudentId());
        assertEquals(20, s.getAge());
        assertEquals("M", s.getGender());
        assertEquals(2.5f, s.getStudyHoursPerDay());
        assertEquals(1.0f, s.getSocialMediaHours());
        assertEquals(0.5f, s.getNetflixHours());
        assertTrue(s.isPartTimeJob());
        assertEquals(95.0f, s.getAttendancePercentage());
        assertEquals(7.0f, s.getSleepHours());
        assertEquals("Good", s.getDietQuality());
        assertEquals(3, s.getExerciseFrequency());
        assertEquals("High", s.getParentalEducationLevel());
        assertEquals("Excellent", s.getInternetQuality());
        assertEquals(8, s.getMentalHealthRating());
        assertFalse(s.isExtracurricularParticipation());
        assertEquals(88.5f, s.getExamScore());
    }

    @Test
    void testLoadIntoDoubleLinkedListWithIncompleteLine() {
        List<String[]> lines = new ArrayList<>();
        lines.add(new String[]{
                "studentId", "age", "gender", "studyHoursPerDay", "socialMediaHours", "netflixHours",
                "partTimeJob", "attendancePercentage", "sleepHours", "dietQuality", "exerciseFrequency",
                "parentalEducationLevel", "internetQuality", "mentalHealthRating", "extracurricularParticipation", "examScore"
        });
        lines.add(new String[]{"S2", "21"});

        DoubleLinkedList list = new DoubleLinkedList();
        StudentDataLoader.loadIntoDoubleLinkedList(lines, list);

        List<StudentData> students = toList(list);
        assertEquals(0, students.size());
    }
}