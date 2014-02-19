package mx.afelipe.android.departamentosutim.activities;

import java.util.ArrayList;
import java.util.List;
import mx.afelipe.android.departamentosutim.R;
import mx.afelipe.android.departamentosutim.adapter.ListViewAdapter;
import mx.afelipe.android.departamentosutim.model.Departamento;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Se ha creado como ListActivity para indicar que es una actividad cuyo comportamiento es el de un ListView
 * ya que en este activity no se consideran otros elementos dentro del layout y el listview es el elemento principal
 * 
 * la forma de acceder al listView se hace de forma directa a traves de getListView(), setListAdapter(obj Adaptador), etc.
 * 
 * Considerar que en el layout de este activity tipo ListActivity, el listview debe tener asignado el ID de la forma
 * android:id="@android:id/list"
 * ver el codigo xml del layout activity_main
 * 
 * @author afelipe
 *
 */
public class MainActivity extends ListActivity {
	//ListView departamentosList;
	ListViewAdapter adaptadorListaDeptos;
	List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for(int i=1; i<=10; i++){
			Departamento item = new Departamento();
			item.setNombre("Departamento " + i);
			item.setResponsable("Resp " + i);
			item.setCargoResponsable("Cargo " + i);
			item.setTelefono("0 00 00");
			item.setEmail("item"+i+"@example.com");
			listaDepartamentos.add(item);
		}
		
		//departamentosList = (ListView) findViewById(R.id.departamentosList);
		//departamentosList.setClickable(true);
		
		adaptadorListaDeptos = new ListViewAdapter(this, this.listaDepartamentos);
		//departamentosList.setAdapter(adaptadorListaDeptos);
		setListAdapter(adaptadorListaDeptos);
		/*//agregar los departamentos despues de ser recuperados desde el WS
		 if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
					// this is for android 4.0+
					adaptadorListaDeptos
							.addAll(this.listaDepartamentos);
				} else {
					for (Suceso item : this.listaDepartamentos) {
						adaptadorListaDeptos.add(item);
					}
		}
		 */
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_add:
			Intent goAdd = new Intent(this,DepartamentoNewActivity.class);
			startActivity(goAdd);
			break;
		case R.id.action_about:
			Intent goAbout = new Intent(this, AboutActivity.class);
			startActivity(goAbout);
			break;
		}
		return true;
	}
}
