public class TestF {
    @AutoInjectable
    private SomeInterfaceTest field1 ;
    @AutoInjectable
    private SomeOtherInterfaceTest field2;


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
