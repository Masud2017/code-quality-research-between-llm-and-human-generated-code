package org.antipattern.executors;

import java.util.List;
import java.util.concurrent.*;

/**
 * <h1>ParallelProcessHandler</h1>
 * Class for handling parallel processing for multiple analyzer task.
 * @author Md Masud karim
 * @version 1.0
 * @email msmasud578@gmail.com
 * */
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
