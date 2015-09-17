package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// Log Tag
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters
	private int mCreate = 0;
	private int mRestart = 0;
	private int mStart = 0;
	private int mResume = 0;

	private TextView mTvCreate = null;
	private TextView mTvRestart = null;
	private TextView mTvStart = null;
	private TextView mTvResume = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// Initialize TextViews

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvStart = (TextView) findViewById(R.id.start);

		Button closeButton = (Button) findViewById(R.id.bClose);
		closeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});


		if (savedInstanceState != null) {

			// Retrieve counts from bundle

			mCreate = savedInstanceState.getInt(CREATE_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);

		}

		Log.i(TAG, "Entered the onCreate() method");

		// Increment and update counts

		mCreate++;
		displayCounts();
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		Log.i(TAG, "Entered the onStart() method");

		mStart++;
		displayCounts();
		
		
	}

	@Override
	public void onResume() {
		super.onResume();

		Log.i(TAG, "Entered the onResume() method");

		mResume++;
		displayCounts();

	
	}

	@Override
	public void onPause() {
		super.onPause();

		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		Log.i(TAG, "Entered the onRestart() method");

		mRestart++;
		displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// Save counts in a bundle

		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(START_KEY, mStart);
	}

	public void displayCounts() {
		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);

	
	}
}
