public record TaskSwapRecord(Worker worker1, Worker worker2) {

    public boolean isBeneficial(int[][] workerTimes) {

        int costWithoutSwap = workerTimes[worker1.getWorkerId()][worker1.getAssignedTaskId()] +
                workerTimes[worker2.getWorkerId()][worker2.getAssignedTaskId()];

        int costWithSwap = workerTimes[worker1.getWorkerId()][worker2.getAssignedTaskId()] +
                workerTimes[worker2.getWorkerId()][worker1.getAssignedTaskId()];

        int gainedOnSwap = costWithSwap - costWithoutSwap;

        return gainedOnSwap < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) return true;
        if (!(o instanceof TaskSwapRecord taskSwapRecord)) return false;
        return worker1.equals(taskSwapRecord.worker1) && worker2.equals(taskSwapRecord.worker2);
    }

}