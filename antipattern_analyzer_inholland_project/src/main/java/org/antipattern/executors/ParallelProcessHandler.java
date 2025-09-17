package org.antipattern.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelProcessHandler {
    private ExecutorService executors;
    private List<Runnable> taskLists;

    public ParallelProcessHandler(Integer workerCount, List<Runnable> taskLists) {
        this.executors = Executors.newFixedThreadPool(workerCount);
        this.taskLists = taskLists;
    }

    public void startProcessing() throws InterruptedException, ExecutionException {

        this.executors.shutdown();

        this.executors.awaitTermination(10, TimeUnit.MINUTES);
    }
}
