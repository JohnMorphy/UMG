import java.util.Objects;

public class Worker {
    private final int workerId;
    private int assignedTaskId;

    public Worker(int workerId, int assignedTaskId) {
        this.workerId = workerId;
        this.assignedTaskId = assignedTaskId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public int getAssignedTaskId() {
        return assignedTaskId;
    }

    public void setAssignedTaskId(int assignedTaskId) {
        this.assignedTaskId = assignedTaskId;
    }

    @Override
    public String toString() {
        return workerId + ": " + assignedTaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return workerId == worker.workerId && assignedTaskId == worker.assignedTaskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, assignedTaskId);
    }
}