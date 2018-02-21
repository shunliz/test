package adapter.obj;

import adapter.cls.Source;
import adapter.cls.Targetable;

public class ObjAdapter implements Targetable {
	
	private Source source;
	
	public ObjAdapter(Source source){
		super();
		this.source = source;
	}

	public void method1() {
		// TODO Auto-generated method stub
		source.method1();  
	}

	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is the targetable method!");  
	}

}
