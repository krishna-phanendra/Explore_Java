package com.nk.threads.waitnotify;

/**
 * In this class, using wait()/notify() to overcome Producer/Consumer problem
 * 
 * @author phanendra
 *
 */
public class ProducerConsumer_waitnotify {

	/**
	 * Lock object
	 */
	private static Object lock = new Object();

	private static int[] buffer;
	private static int count;

	static class Producer {
		
		void produce() {
			synchronized (lock) {
				if (isFull(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[count++] = 1;
				lock.notify();
			}
		}
	}

	static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}

	static class Consumer {
		void consume() {
			synchronized (lock) {
				if (isEmpty(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[--count] = 0;
				lock.notify();
			}
		}
	}

	static boolean isEmpty(int[] buffer) {
		return count == 0;
	}

	public static void main(String[] args) throws InterruptedException {

		buffer = new int[10];
		count = 0;

		Producer p = new Producer();
		Consumer c = new Consumer();

		Runnable pTask = () -> {
			for (int i = 0; i < 50; i++) {
				p.produce();
			}
			System.out.println("Done Producing");
		};

		Runnable cTask = () -> {
			for (int i = 0; i < 50; i++) {
				c.consume();
			}
			System.out.println("Done Producing");
		};

		Thread pt = new Thread(pTask);
		Thread ct = new Thread(cTask);

		pt.start();
		ct.start();

		pt.join();
		ct.join();

		System.out.println("Data in buffer : " + count);

	}

}
