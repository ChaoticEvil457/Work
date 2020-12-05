public class B extends A{
    @Override
    public A bunny(){
        return new C();
    }
}
