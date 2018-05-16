package com.trennble.invoice.repo;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Before;
import org.junit.Test;

public class ConcurrentTest {

	private static final long MAX = 200_000_000;
//	private static final long MAX = 500_000_000;

	 long loop = 0;

	@Before
	public void before() {
		loop = 0;
	}

	@Test
	public void noLock() {
		// 200  左右
		long s = System.currentTimeMillis();
		while (++loop < MAX);
		long e = System.currentTimeMillis();
		System.out.println("无锁 " + loop + " -> " + (e - s));
	}
	
	@Test
	public void ddd() throws Exception {
		twoThreadSYNC();
		loop = 0;
		oneThreadSYNC();
	}
	
	@Test
	public void twoThreadSYNC() throws Exception {
		// 18, 000 +
		final Object lock = new Object();
		
		Callable<Long> r = () -> {
			long s = System.currentTimeMillis();
			while (loop < MAX)  {
				synchronized (lock) {
					loop++;
				}
			}
			long e = System.currentTimeMillis();
			return e - s;
		};

		long count = Executors.newFixedThreadPool(2).invokeAll(Arrays.asList(r, r)).stream().mapToLong(f -> {
			try {
				return f.get();
			} catch (Throwable e) {
				return 0;
			}
		}).reduce(Long::max).getAsLong();
		
		System.out.println("SYNC 双线程" + loop + " -> " + count);
		
	}
	

	@Test
	public void oneThreadSYNC() throws Exception {
		// 12288 +
		final Object lock = new Object();
		final long _MAX = MAX;
		System.out.println("SYNC 单线程" + loop + " -> " + loop);
		
		/*Callable<Long> r = () -> {
			long s = System.currentTimeMillis();
			while (loop < _MAX)  {
				synchronized (lock) {
					loop++;
				}
			}
			long e = System.currentTimeMillis();
			return e - s;
		};*/
		
		/*long count = Executors.newFixedThreadPool(1).invokeAll(Arrays.asList(r)).stream().mapToLong(f -> {
			try {
				return f.get();
			} catch (Throwable e) {
				return 0;
			}
		}).reduce(Long::max).getAsLong();*/
		
		// long count = r.call();
		
		long s = System.currentTimeMillis();
		while (loop < _MAX)  {
			synchronized (lock) {
				loop++;
			}
		}
		long e = System.currentTimeMillis();
		long count = e - s;
		
		System.out.println("SYNC 单线程" + loop + " -> " + count);
	}
	
	@Test
	public void oneThreadCAS() throws Exception {
		// 3000 +
		AtomicLong al = new AtomicLong(0);
		
		Callable<Long> r = () -> {
			long s = System.currentTimeMillis();
			while (al.incrementAndGet() < MAX);
			long e = System.currentTimeMillis();
			return e - s;
		};
		
		long count = Executors.newFixedThreadPool(2).invokeAll(Arrays.asList(r)).stream().mapToLong(f -> {
			try {
				return f.get();
			} catch (Throwable e) {
				return 0;
			}
		}).reduce(Long::max).getAsLong();
		loop = al.get();
		System.out.println("CAS 单线程" + loop + " -> " + count);
	}
	@Test
	public void twoThreadCAS() throws Exception {
		// 8000 +
		AtomicLong al = new AtomicLong(0);
		
		Callable<Long> r = () -> {
			long s = System.currentTimeMillis();
			while (al.incrementAndGet() < MAX);
			long e = System.currentTimeMillis();
			return e - s;
		};
		
		long count = Executors.newFixedThreadPool(2).invokeAll(Arrays.asList(r, r)).stream().mapToLong(f -> {
			try {
				return f.get();
			} catch (Throwable e) {
				return 0;
			}
		}).reduce(Long::max).getAsLong();
		loop = al.get();
		System.out.println("CAS 双线程" + loop + " -> " + count);
	}
	
	
	public static void main(String[] args) throws Exception {
		ConcurrentTest ct = new ConcurrentTest();
		
		ct.ddd();
		//
		// ct.oneThreadSYNC();
//		ct.loop = 0;
//		ct.oneThreadSYNC();
	}
}
