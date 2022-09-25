package com.nk.threads.waitnotify;

/**
 * In the class, Producer and Consumer has Unsynchronized methods. So, the
 * behavior is not consistent
 * 
 * @author phanendra
 *
 */
public class ProducerConsumer {

	private static int[] buffer;
	private static int count;

	static class Producer {
		/**
		 * PROBLEM : not synchronizing the method or block
		 */
		void produce() {
			while (isFull(buffer)) {
			}
			buffer[count++] = 1;
		}
	}

	static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}

	static class Consumer {
		/**
		 * PROBLEM : not synchronizing the method or block
		 */
		void consume() {
			while (isEmpty(buffer)) {
			}
			buffer[--count] = 0;
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
