package Project;

/**
 * Created by user on 06.02.2018.
 */
public class TaskTree extends Tree<Task> {
    public TaskTree(Task task) {
        super(task);
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
