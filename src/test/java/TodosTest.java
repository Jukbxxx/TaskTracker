import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {
    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    SimpleTask simple = new SimpleTask(28, "корм для кошки");
    Meeting meeting = new Meeting(987, "Разбор задач", "Аналитика соцмедиа", "25.06.2019");
    String[] subtasks = {"Помыть посуду", "Купить билеты", "Направить задание на проверку"};
    Epic epic = new Epic(14, subtasks);

    @BeforeEach
    public void setup() {
        todos.add(simple);
        todos.add(meeting);
        todos.add(epic);
    }

    @Test
    public void shouldSearchForSimpleTask() {
        Task[] expected = {simple};
        Task[] actual = todos.search("корм");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForEpic() {
        Task[] expected = {epic};
        Task[] actual = todos.search("билеты");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForMeetingIfMatchesTopic() {
        Task[] expected = {meeting};
        Task[] actual = todos.search("Разбор задач");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchForMeetingIfMatchesProject() {
        Task[] expected = {meeting};
        Task[] actual = todos.search("соцмедиа");
        Assertions.assertArrayEquals(expected, actual);
    }
}
