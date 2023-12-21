package nl.r1a;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.r1a.task1.Student;
import nl.r1a.task1.User;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    public void testUser() {
        User user = User.builder()
                .name("Name")
                .age(42)
                .weight(80.0)
                .height(1.80)
                .build();
        assertEquals(
                user.toString(),
                "User(name=Name, age=42, gender=null, weight=80.0, height=1.8)");
    }

    @Test
    public void testStudent() {
        Student student = Student.builder().grade(8).grade(7).grade(9).build();
        assertEquals(student.toString(), "Student(grades=[8, 7, 9])");
    }
}
