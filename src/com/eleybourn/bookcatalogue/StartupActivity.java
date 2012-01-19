package com.eleybourn.bookcatalogue;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Single Activity to be the 'Main' activity for the app. I does app-startup stuff which is initially
 * to start the 'real' main activity.
 * 
 * Note that calling the desired main activity first resulted in MainMenu's 'singleInstance' property
 * NOT being honoured. So we call MainMenu anyway, but set a flag in the Intent to indicate this is
 * a startup. This approach mostly works, but results in an apparent misordering of the activity 
 * stack, which we can live with for now.
 * 
 * @author Grunthos
 */
public class StartupActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// It's a startup...cleanup old stuff
		Logger.clearLog();

		// TODO: add more startup-specific code, eg. checks for old app logs, crashes, or new Events.
		// perhaps store the max eventId the user has seen in 

		// Just start MainMenu...it will start the users chosen startup page. Bizarre.
		Intent i;
		i = new Intent(this, MainMenu.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.putExtra("startup", true);
		this.startActivity(i);

		// Die
		finish();
	}
}