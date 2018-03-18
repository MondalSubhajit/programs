import java.util.*;

public class TestSingleton implements Runnable
{
	public void run(){
		System.out.println("called thread");
		//use any 1 of the below two at a time
		//case SyncSingleton 
		SyncSingleton ss1 = SyncSingleton.getTest();
		//case SyncSingletonWithDoubleChecking 
		SyncSingletonWithDoubleChecking ssdc1 = SyncSingletonWithDoubleChecking.getTest();
	}

	public static void main(String[] args) 
	{
		// approach 1
		Test t1 = Test.getTest();
		Test t2 = Test.getTest();
		System.out.println("Check if t1 == t2:"+(t1==t2));
	
		//aproach 2
		LazySingleton ls1 = LazySingleton.getTest();
		LazySingleton ls2 = LazySingleton.getTest();
		System.out.println("Check if ls1 == ls2:"+(ls1==ls2));
	
		// case SyncSingleton
		Thread th1 = new Thread(new TestSingleton());
		Thread th2 = new Thread(new TestSingleton());	
		th1.start();  th2.start();

		//case SyncSingletonWithDoubleChecking 
		Thread ssdc1 = new Thread(new TestSingleton());
		Thread ssdc2 = new Thread(new TestSingleton());	
		ssdc1.start();  ssdc2.start();
		
	}
}

class SyncSingletonWithDoubleChecking
{
	private static SyncSingletonWithDoubleChecking ssdc = null;
	private SyncSingletonWithDoubleChecking(){
		System.out.println("SyncSingletonWithDoubleChecking object created");
	}

	public static SyncSingletonWithDoubleChecking getTest(){
		if(ssdc == null){
			synchronized(SyncSingletonWithDoubleChecking.class){
				if(ssdc == null){
					ssdc = new SyncSingletonWithDoubleChecking();
				}
			}
		}
		return ssdc;
	}

}

class SyncSingleton
{
	private static SyncSingleton obj = null;
	private SyncSingleton(){
		System.out.println("Sync Singleton object created");
	}

	public static synchronized SyncSingleton getTest(){
		if(obj == null){
			obj = new SyncSingleton();
		}
		return obj;
	}
}

class Test
{
	public static Test t = new Test();

	private Test(){
		System.out.println("Test Object Created");
	}

	public static Test getTest(){
		return t;
	}
}

class LazySingleton
{
	public static LazySingleton ls = null;

	private LazySingleton(){
		System.out.println("Sington object Created lazily");
	}

	public static LazySingleton getTest(){
		if(ls == null){
			ls = new LazySingleton();
		}
		return ls;
	}
}