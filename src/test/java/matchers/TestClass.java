package matchers;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestClass {

    @Test
    public void testMatcher() {
        String someStr = "Java is a general-purpose programming language that is class-based, object-oriented.";
        String substr = "pRograMming langUage";

        assertThat(someStr, ContainsStringIgnoringCase.containsStringIgnoringCase(substr));
    }
}