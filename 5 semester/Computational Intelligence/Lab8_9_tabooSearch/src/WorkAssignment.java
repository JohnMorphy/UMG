import java.util.ArrayList;
import java.util.Objects;

public class WorkAssignment {
    private final ArrayList<Worker> workList;
    public WorkAssignment() {
        workList = new ArrayList<>();
    }

    public WorkAssignment(WorkAssignment workAssignment) {
        this.workList = new ArrayList<>(workAssignment.workList);
    }

    public void add(int assignedTaskId) {
        workList.add(new Worker(workList.size(), assignedTaskId));
    }

    public Worker get(int id) {
        return workList.get(id);
    }

    public Worker getWorstPerformer(int[][] workerTimes) {
        Worker worstWorker = this.get(0);
        for (Worker worker:workList) {
            if(workerTimes[worker.getWorkerId()][worker.getAssignedTaskId()] <
            workerTimes[worstWorker.getWorkerId()][worstWorker.getAssignedTaskId()]) {
                worstWorker = worker;
            }
        }

        return worstWorker;
    }

    public void swap(TaskSwapRecord taskSwapRecord) {
        swap(taskSwapRecord.worker1().getWorkerId(), taskSwapRecord.worker2().getWorkerId());
    }
    public void swap(int id1, int id2) {
        if (id1 >= workList.size() || id2 >= workList.size() || id1 < 0 || id2 < 0) {
            return;
        }

        Worker worker1 = workList.get(id1);
        Worker worker2 = workList.get(id2);

        int buffer = worker1.getAssignedTaskId();
        worker1.setAssignedTaskId(worker2.getAssignedTaskId());
        worker2.setAssignedTaskId(buffer);

    }

    public Worker findByTaskId(int taskId) {
        for (Worker worker : workList) {
            if (worker.getAssignedTaskId() == taskId) {
                return worker;
            }
        }

        return null;
    }

    public ArrayList<Worker> getWorkList() {
        return workList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkAssignment)) return false;
        WorkAssignment that = (WorkAssignment) o;
        return workList.size() == that.workList.size() && workList.equals(that.workList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workList);
    }

    @Override
    public String toString() {
        return workList.toString();
    }
}