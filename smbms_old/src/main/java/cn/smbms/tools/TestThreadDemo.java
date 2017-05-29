package cn.smbms.tools;

public class TestThreadDemo {
	public static void main(String[] args) {
		// for: 主线程 （获取cpu资源之后，瞬间生成n个子线程，n个并发）
		for (int i = 0; i < 4; i++) {
			// new 开辟子线程 start：调用run，运行子线程
			new ThreadDemo("thread" + i).start();
			if (i == 1) {
				try {
					Thread.sleep(1000);
					System.out.println("sleep ===================");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
