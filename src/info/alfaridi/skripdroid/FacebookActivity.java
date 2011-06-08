package info.alfaridi.skripdroid;

import greendroid.app.GDActivity;
import android.os.Bundle;

public class FacebookActivity extends GDActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.facebook);
	}
	
}
