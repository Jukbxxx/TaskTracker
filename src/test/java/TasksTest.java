import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchEpicIfTrue() {
        String[] subtasks = {"Постирать белье", "Покормить кота", "Сходить в магазин"};
        Epic epic = new Epic(65, subtasks);
        boolean actual = epic.matches("магазин");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotMatchEpicIfFalse() {
        String[] subtasks = {"Постирать белье", "Покормить кота", "Сходить в магазин"};
        Epic epic = new Epic(65, subtasks);
        boolean actual = epic.matches("кошка");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldMatchSimpleTaskIfTrue() {
        SimpleTask simple = new SimpleTask(8, "Домашнее задание");
        boolean actual = simple.matches("задание");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotMatchSimpleTaskIfFalse() {
        SimpleTask simple = new SimpleTask(8, "Домашнее задание");
        boolean actual = simple.matches("суп");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldMatchMeetingTopicIfTrue() {
        Meeting meet = new Meeting(8, "Обсуждаем ТЗ на мониторинг", "SCAN", "24.04");
        boolean actual = meet.matches("ТЗ");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotMatchMeetingTopicIfFalse() {
        Meeting meet = new Meeting(8, "Обсуждаем ТЗ на мониторинг", "SCAN", "24.04");
        boolean actual = meet.matches("Презентация");
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldMatchMeetingProjectIfTrue() {
        Meeting meet = new Meeting(8, "Обсуждаем ТЗ на мониторинг", "SCAN", "24.04");
        boolean actual = meet.matches("SCAN");
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNoTMatchMeetingProjectIfFalse() {
        Meeting meet = new Meeting(8, "Обсуждаем ТЗ на мониторинг", "SCAN", "24.04");
        boolean actual = meet.matches("Brand Analytics");
        Assertions.assertFalse(actual);
    }
}





