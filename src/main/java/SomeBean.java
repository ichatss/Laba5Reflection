
public class SomeBean {

    @AutoInjectable
    private SomeInterface field1 ;
    @AutoInjectable
    private SomeOtherInterface field2;
    

    public void foo() {
        field1.doSomething();
        field2.doSomething(); 
    }

    public String getField1() {
        return field1.doSomething();
    }

    public String getField2() {
        return field2.doSomething();
    }
    
}
