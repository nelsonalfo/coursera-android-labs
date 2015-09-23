package course.labs.permissionslab.tests;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import course.labs.permissionslab.ActivityLoaderActivity;

public class PermissionEnforcementTest extends
        ActivityInstrumentationTestCase2<ActivityLoaderActivity> {
    private Solo solo;

    public PermissionEnforcementTest() {
        super(ActivityLoaderActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation());
        getActivity();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    // Executes PermissionEnforcementTest
    public void testRun() {

        // =============== Section One ==================
        solo.waitForActivity(
                course.labs.permissionslab.ActivityLoaderActivity.class, 2000);

        PackageManager pm = getActivity().getPackageManager();
        try {
            ComponentName componentName = new ComponentName("course.labs.dangerousapp", "course.labs.dangerousapp.DangerousActivity");

            ActivityInfo activityInfo = pm.getActivityInfo(componentName, 0);

            boolean condition = (null != activityInfo) && (null != activityInfo.permission) &&
                    activityInfo.permission.equals("course.labs.permissions.DANGEROUS_ACTIVITY_PERM");

            assertTrue("PermissionEnforcementTest: Section One: course.labs.permissions.DANGEROUS_ACTIVITY_PERM not enforced by DangerousActivity",
                    condition);

        } catch (NameNotFoundException e) {
            fail("PermissionEnforcementTest:" +
                    "Section One:" +
                    "DangerousActivity not found");
        }
    }
}
