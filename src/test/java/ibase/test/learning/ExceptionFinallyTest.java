package ibase.test.learning;

import org.junit.Test;

/**
 * Created by myback on 2017/1/14.
 */
public class ExceptionFinallyTest {
	
	@Test
	public void testFinally(){
		System.out.println(finallyString1()); // print "finally"
		System.out.println(finallyString2()); // print "catch"
		System.out.println(finallyString3()); // print "catch"
		System.out.println(finallyString4()); // print "finally"
	}
	
	public static String finallyString1(){
		String ret;
		try {
			ret = "try-1";
			int i = 10 / 0;
			ret = "try-2";
			return ret;
		} catch (Exception e) {
			ret = "catch";
			return ret;
		} finally {
			ret = "finally";
			return ret;
		}
	}
	
	public static String finallyString2(){
		String ret;
		try {
			ret = "try-1";
			int i = 10 / 0;
			ret = "try-2";
			return ret;
		} catch (Exception e) {
			ret = "catch";
			return ret;
		} finally {
			ret = "finally";
			//return ret;
		}
	}
	
	public static String finallyString3(){
		String ret;
		try {
			ret = "try-1";
			int i = 10 / 0;
			ret = "try-2";
			return ret;
		} catch (Exception e) {
			ret = "catch";
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return ret;
		} finally {
			ret = "finally";
			//return ret;
		}
	}
	
	public static String finallyString4(){
		String ret;
		try {
			ret = "try-1";
			int i = 10 / 0;
			ret = "try-2";
			return ret;
		} catch (Exception e) {
			ret = "catch";
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return ret;
		} finally {
			ret = "finally";
			return ret;
		}
	}
}
