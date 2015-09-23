package course.labs.activitylab.tests;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import course.labs.activitylab.ActivityOne;

public class Test1_StartActivityOneTest extends
        ActivityInstrumentationTestCase2<ActivityOne> {

    private Solo solo;
    private int timeout = 20000;
    private int sleep = 1000;

    public Test1_StartActivityOneTest() {
        super(ActivityOne.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    // Execution of StartActivityOneTest
    public void testRun() {

        // ==================== Section One =====================
        // Wait for activity: 'course.labs.activitylab.ActivityOne'
        boolean condition = solo.waitForActivity(ActivityOne.class, timeout);
        assertTrue("StartActivityOneTest failed: Section One: ActivityOne did not correctly load", condition);


        // ==================== Section Two =====================
        // Check for proper counts
        boolean condition1 = solo.waitForText("onCreate\\(\\) calls: 1");
        assertTrue("StartActivityOneTest failed: Section Two: onCreate() count was off for ActivityOne", condition1);

        boolean condition2 = solo.waitForText("onStart\\(\\) calls: 1");
        assertTrue("StartActivityOneTest failed: Section Two: onStart() count was off for ActivityOne", condition2);

        boolean condition3 = solo.waitForText("onResume\\(\\) calls: 1");
        assertTrue("StartActivityOneTest failed: Section Two: onResume() count was off for ActivityOne", condition3);

        boolean condition4 = solo.waitForText("onRestart\\(\\) calls: 0");
        assertTrue("StartActivityOneTest failed: Section Two: onRestart() count was off for ActivityOne", condition4);

    }

}
