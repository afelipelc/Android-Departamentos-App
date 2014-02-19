package mx.afelipe.android.departamentosutim.activities;

import mx.afelipe.android.departamentosutim.R;
import mx.afelipe.android.departamentosutim.R.layout;
import mx.afelipe.android.departamentosutim.R.menu;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.action_edit:
			Intent goEdit = new Intent(getApplicationContext(),DepartamentoEditActivity.class);
			startActivity(goEdit);
			return true;
		case R.id.action_delete:
			Toast.makeText(getApplicationContext(), "Eliminar item", Toast.LENGTH_SHORT).show();
		return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
