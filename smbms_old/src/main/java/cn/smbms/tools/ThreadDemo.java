package cn.smbms.tools;

public class ThreadDemo extends Thread {

	private String threadNo;

	public ThreadDemo(String threadNo) {
		this.threadNo = threadNo;
	}

	@Override
	public void run() { // 线程开始执行
		super.run();
		System.out.println("run ==================== threadNo:" + threadNo);
		// Singleton.getInstance(threadNo);
	}

	public String getThreadNo() {
		return threadNo;
	}

	public void setThreadNo(String threadNo) {
		this.threadNo = threadNo;
	}

}
