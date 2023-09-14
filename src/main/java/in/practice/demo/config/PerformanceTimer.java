package in.practice.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class PerformanceTimer {

    private static final Logger LOG = LoggerFactory.getLogger(PerformanceTimer.class);

    long start;
    long end;
    final String purpose;
    boolean isRunning = false;

    public PerformanceTimer(final String purpose) {
        this.purpose = purpose;
        start();
    }

    public void display() {
        if (isRunning) stop();
        StringBuilder sb = new StringBuilder(100);
        sb.append(" [PerformanceTimer] ");
        sb.append(purpose);
        sb.append(" : ");
        sb.append((end - start));
        sb.append(" nano secs. ~ ");
        sb.append((end - start) / 1000000);
        sb.append(" ms.");
        sb.append((end - start) / 1000000000);
        sb.append(" sec.");
        LOG.info(sb.toString());
    }

    private void start() {
        start = System.nanoTime();
        end = start;
        isRunning = true;
    }

    private void stop() {
        end = System.nanoTime();
        isRunning = false;
    }
}
