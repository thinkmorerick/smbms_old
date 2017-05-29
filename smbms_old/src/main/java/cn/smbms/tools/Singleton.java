package cn.smbms.tools;

public class Singleton {
	/**
	  饿汉模式 的变种
	 */
	/**private static Singleton singleton;
	static {
		singleton = new Singleton();
		System.out.println("static ===== 执行" + singleton.toString());
	}

	private Singleton() {
	}

	public static Singleton getInstance() {
		System.out.println("getInstance======");
		return singleton;
	}

	public static void test() {
		System.out.println("test =========== " + singleton.toString());
	}*/

	// 双重校验锁
	/**private static Singleton singleton;

	private Singleton() {
	}

	public static Singleton getInstance(String threadNo) {
		// T1 T2 T3
		// T4
		if (singleton == null) {
			// T1 T2 T3
			System.out.println("singleton 1 ============== threadNo:"
					+ threadNo);
			synchronized (Singleton.class) {
				// T2 T1 T3
				System.out.println("singleton 2 ============== threadNo:"
						+ threadNo);
				if (singleton == null) {
					// T2
					System.out.println("singleton 3 ============== threadNo:"
							+ threadNo);
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}*/

	// 静态内部类 lazy loading

	private static Singleton singleton;

	private Singleton() {
	}

	private static class SingletonHelper {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonHelper.INSTANCE;

	}

	public static void test() {
		System.out.println("test====" + singleton.toString());
	}

}
