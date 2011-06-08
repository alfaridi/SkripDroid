package info.alfaridi.skripdroid;

import greendroid.app.GDActivity;
import android.os.Bundle;

public class InfoTabActivity extends GDActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.twitter);
	}

}
