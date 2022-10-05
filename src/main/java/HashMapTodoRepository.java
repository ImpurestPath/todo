import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTodoRepository implements ITodoRepository{


    public Map<String, TodoItem> todoItemMap = new HashMap();


    @Override
    public List<TodoItem> getAll() {

        List<TodoItem> list = new ArrayList<TodoItem>(todoItemMap.values());
        return list;
    }

    @Override
    public TodoItem get(String nameTodoItem) {
        return todoItemMap.get(nameTodoItem);
    }

    @Override
    public void add(TodoItem todoitem) {
        todoItemMap.put(todoitem.name, todoitem);
    }

    @Override
    public void update(TodoItem todoitem) {
        todoItemMap.put(todoitem.name, todoitem);

    }

    @Override
    public void delete(String nameTodoItem) {
        todoItemMap.remove(nameTodoItem);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, TodoItem> entry : todoItemMap.entrySet()) {
            sb
                    .append(entry.getKey())
                    .append("\n")
                    .append(entry.getValue())
                    .append("\n");
        }


        return sb.toString();
    }
}
