package Project;

public class Task extends Node{
    private   String name;
    private   long spentTime;
    private  String executor;
    private  Status status;

    public Task(String executor, String name, Id id) {
        super(id);
        this.name = name;
        this.executor = executor;
        spentTime = 0;
        status = Status.NOT_STARTED;
    }

    public String getName() {
        return name;
    }

    public long getSpentTime() {
        return spentTime;
    }

    public String getExecutor() {
        return executor;
    }

    public Status getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpentTime(long spentTime) {
        this.spentTime = spentTime;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}