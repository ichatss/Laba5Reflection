import static org.junit.Assert.assertEquals;

public class InTest {
    @org.junit.Test
    public void inject() {
        TestF test = (new Injector<TestF>()).inject(new TestF());
        assertEquals("TestOne", test.getField1());
        assertEquals("TestTwo", test.getField2());
    }
}