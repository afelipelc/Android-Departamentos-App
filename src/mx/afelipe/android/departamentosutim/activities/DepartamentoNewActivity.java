package mx.afelipe.android.departamentosutim.activities;

import mx.afelipe.android.departamentosutim.R;
import mx.afelipe.android.departamentosutim.R.layout;
import mx.afelipe.android.departamentosutim.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * DepartamentoEditActivity y DepartamentoNewActivity comparten el mismo layout departamento_form
 * pero el comportamiento está definido de forma distinta en los activities
 * 
 * @author afelipe
 *
 */
public class DepartamentoNewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_departamento_form);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.departamento_form, menu);
		return true;
	}
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_cancel:
			finish();
			break;
		case R.id.action_save:
			Toast.makeText(getApplicationContext(), "Se registra...", Toast.LENGTH_SHORT).show();
			break;
		}
		return true;
	}
}
