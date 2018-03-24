package Project;

import java.util.Map;
import java.util.Set;

/**
 * Created by user on 06.02.2018.
 */
public class TaskTree extends Tree<Task> {

    public TaskTree(String executor, String name) {
        super(new Task(executor, name, new Id(1,1)));
    }

    public TaskTree(Tree<Task> otherTree) {
        super(otherTree);
    }

    public Task addTask(String executor, String name, Task parent) {
        Id id = getNewNodeTypeId(parent);
        Task task = new Task(executor, name, id);
        addNodeType(task, getIdOfNodeType(parent));
        return task;
    }
    public Task getTaskOnName(String name){
        Task task = null;
        Set<Map.Entry<Id, Task>> entrySet = getNodeMap().entrySet();
        for (Map.Entry<Id, Task> pair : entrySet){
            if (pair.getValue().getName()==name)
                task=pair.getValue();
        }
        return task;
    }

    public void updateTask(Id id, String newName) {
        Task task = getTask(id);
        task.setName(newName);                                            /////////////////traves
    }

    public void deleteTask(Id id) {
        Task task = getNodeType(id);
        deleteNodeType(task);
    }

    public Task getTask(Id id) {
        Node node = getNodeType(id);
        return (Task) node;
    }


    @Override
    Task createNode(Task oldNode, Id newId) {
        return null;
    }

    @Override
    Tree<Task> createTree(Task head) {
        return null;
    }
}
