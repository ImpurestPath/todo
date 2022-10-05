import java.util.Objects;

public class TodoItem {


    String name;
    String description;
    Boolean done;


    public TodoItem(String name, String description, Boolean done) {
        this.name = name;
        this.description = description;
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return Objects.equals(name, todoItem.name) && Objects.equals(description, todoItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}