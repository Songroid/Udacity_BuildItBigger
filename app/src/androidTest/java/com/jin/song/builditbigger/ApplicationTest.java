package com.jin.song.builditbigger;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;

import com.jin.song.builditbigger.network.EndpointsAsyncTask;
import com.jin.song.builditbigger.ui.MainActivity;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;

    public ApplicationTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
    }

    @UiThreadTest
    public void testVerifyAsyncTask() {
        new EndpointsAsyncTask(mainActivity) {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertNotSame(result, "");
                assertEquals(result, "Hi, this is a Joke!");
            }
        }.execute();
    }
}