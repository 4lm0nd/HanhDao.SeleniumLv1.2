package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseDraft extends BaseTest {

    @Test
    void firstTest() {
        String a = "abc";
        String b = "cba";
        System.out.println("this is the first test");
        Assert.assertEquals(a, b, "Text không khớp!");
    }
}
