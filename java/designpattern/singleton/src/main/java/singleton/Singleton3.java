package singleton;

public class Singleton3{
    private Singleton3(){}
    public static Singleton3 getInstance(){ return Holder.SINGLETON;}
    private static class Holder{//�ڲ���
        private static final Singleton3 SINGLETON= new Singleton3();
    }
}