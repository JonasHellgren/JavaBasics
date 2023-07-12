package ps_new_in_java17_junit5.test_suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("ps_new_in_java17_junit5.junit5")
@IncludeTags("math")
public class TestSuiteOnMathTaggedTests {
}
