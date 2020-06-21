package topic.util;

public interface StopWatch {
	long duration();
	void start();
	void stop();
	void reset();
	long durationInMillis();
	long durationInSeconds();
}
