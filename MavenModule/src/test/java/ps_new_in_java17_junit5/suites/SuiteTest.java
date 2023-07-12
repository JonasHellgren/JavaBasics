package ps_new_in_java17_junit5.suites;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)
@Suite
//@SelectPackages("src.test.java.ps_new_in_java17_junit5.junit5")
@SelectPackages("ps_new_in_java17_junit5.junit5")
//@ExcludeTags({"math"})
//@IncludeTags("math")

public class SuiteTest {
}
