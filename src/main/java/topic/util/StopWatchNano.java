package topic.util;

public class StopWatchNano implements StopWatch{
	private long start;
	private long end;
	private static final int CONVERT_TO_MILLI = 1000000;
	private static final int CONVERT_TO_SECONDS = 1000000000;
	
	public StopWatchNano(){
		reset();
	}
	
	@Override
	public void reset(){
		this.start = 0l;
		this.end = 0l;
	}
	
	@Override
	public long durationInMillis() {
		return duration()/CONVERT_TO_MILLI;
	}
	
	@Override
	public long durationInSeconds() {
		return duration()/CONVERT_TO_SECONDS;
	}
	
	@Override
	public long duration() {
		return this.end - this.start;
	}
	
	@Override
	public void start() {
		if(this.end != 0) reset(); // check
		this.start = System.nanoTime();
	}
	
	@Override
	public void stop() {
		this.end = System.nanoTime();
	}
}
