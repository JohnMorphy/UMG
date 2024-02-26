import java.util.LinkedList;

public class TaskQueue<T> {
    private final LinkedList<T> taskQueue;

    public TaskQueue() {
        this.taskQueue = new LinkedList<>();
    }

    public int length() {
        return taskQueue.size();
    }

    public boolean contains(T newTask) {
        for (T task : taskQueue) {
            if (task.equals(newTask)) {
                return true;
            }
        }

        return false;
    }

    public void offer(T task) {
        this.taskQueue.offer(task);
    }

    public void poll() {
        this.taskQueue.poll();
    }

    public void clear() {
        this.taskQueue.clear();
    }
}
