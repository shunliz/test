package adapter.obj;

import adapter.cls.Source;
import adapter.cls.Targetable;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Source source = new Source();  
        Targetable target = new ObjAdapter(source);  
        target.method1();  
        target.method2();  
	}

}
