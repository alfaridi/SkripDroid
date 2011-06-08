package info.alfaridi.skripdroid;

import greendroid.app.GDActivity;
import greendroid.graphics.drawable.ActionBarDrawable;
import greendroid.widget.ActionBarItem;
import greendroid.widget.NormalActionBarItem;
import info.alfaridi.skripdroid.facebook.FacebookActivity;
import info.alfaridi.skripdroid.twitter.TwitterActivity;
import info.alfaridi.skripdroid.utils.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SkripDroidActivity extends GDActivity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.main);

		addActionBarItem(
				getActionBar().newActionBarItem(NormalActionBarItem.class)
						.setDrawable(
								new ActionBarDrawable(getResources(),
										R.drawable.ic_action_bar_info)),
				R.id.action_bar_view_info);

		try {
			PackageInfo info = getPackageManager().getPackageInfo(
					"GDSkripsi.apk", PackageManager.GET_SIGNATURES);
			for (Signature signature : info.signatures) {
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());
				Log.i("PXR", Base64.encodeBytes(md.digest()));
			}
		} catch (NameNotFoundException e) {
		} catch (NoSuchAlgorithmException e) {
		}
	}

	@Override
	public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {
		switch (item.getItemId()) {
		case R.id.action_bar_view_info:
			startActivity(new Intent(this, InfoTabActivity.class));
			return true;

		default:
			return super.onHandleActionBarItemClick(item, position);
		}
	}

	public void onFacebookClick(View view) {
		startActivity(new Intent(this, FacebookActivity.class));
	}

	public void onTwitterClick(View view) {
		startActivity(new Intent(this, TwitterActivity.class));
	}

}