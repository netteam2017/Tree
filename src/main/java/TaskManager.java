public class TaskManager extends Tree {

    public TaskManager(Node head) {
        super(head);
    }

    public Task addTask(String executor, String name, Node parent) {
        Id id = getNewNodeTypeId(parent);
        Task task = new Task(executor, name, id);
        addNodeType(task, getIdOfNodeType(parent));
        return task;
    }

    public void updateTask(Id id, String newName) {
        Task task = getTask(id);
        task.name = newName;
    }

    public void deleteTask(Id id) {
        Node node = getNodeType(id);
        deleteNodeType(node);
    }

    public Task getTask(Id id) {
        Node node = getNodeType(id);
        return (Task) node;
    }

    @Override
    Node createNode(Node oldNode, Id newId) {
        return null;
    }

    @Override
    Tree createTree(Node head) {
        return null;
    }
}
