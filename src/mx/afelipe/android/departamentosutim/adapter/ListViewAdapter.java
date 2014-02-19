package mx.afelipe.android.departamentosutim.adapter;

import java.util.List;
import mx.afelipe.android.departamentosutim.R;
import mx.afelipe.android.departamentosutim.activities.DepartamentoEditActivity;
import mx.afelipe.android.departamentosutim.activities.DetailsActivity;
import mx.afelipe.android.departamentosutim.model.Departamento;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Adaptador para cada elemento Departamento en el ListView del MainActivity
 * En este adaptador se controlan los eventos que contiene el cada elemento: Editar, Eliminar, Ver detalles
 * 
 * @author afelipe
 *
 */
public class ListViewAdapter  extends ArrayAdapter<Departamento>{
	Context context;
	List<Departamento> departamentos;
	public ListViewAdapter(Context context, List<Departamento> deptos){
		super(context, R.layout.elemento_lista, deptos);
		this.context = context;
		this.departamentos = deptos;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		 LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 View item = inflater.inflate(R.layout.elemento_lista, null);
		 
		 TextView nombreDeptoText = (TextView) item.findViewById(R.id.nombreDeptoText);
		 TextView responsableText = (TextView) item.findViewById(R.id.responsableText);
		 TextView cargoResponsableText = (TextView) item.findViewById(R.id.cargoResponsableText);
		 TextView telefonoText = (TextView) item.findViewById(R.id.telefonoText);
		 TextView emailText = (TextView) item.findViewById(R.id.emailText);
		 ImageButton eliminarBtn = (ImageButton) item.findViewById(R.id.eliminarBtn);
		 ImageButton editarBtn = (ImageButton) item.findViewById(R.id.editarBtn);
		 ImageView imagenDeptoImg = (ImageView) item.findViewById(R.id.imagenDeptoImg);
		 
		 nombreDeptoText.setText(departamentos.get(position).getNombre());
		 responsableText.setText(departamentos.get(position).getResponsable());
		 cargoResponsableText.setText(departamentos.get(position).getCargoResponsable());
		 telefonoText.setText(departamentos.get(position).getTelefono());
		 emailText.setText(departamentos.get(position).getEmail());
		 
		 //Controlar los eventos de los botones y del elemento seleccionado
		 editarBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent goEdit = new Intent(context,DepartamentoEditActivity.class);
				context.startActivity(goEdit);
				
			}
		});
		 
		 eliminarBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					Toast.makeText(context, "Eliminar item", Toast.LENGTH_SHORT).show();
				}
			});
		 
		 item.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent goDetails = new Intent(context, DetailsActivity.class);
				context.startActivity(goDetails);
			}
		});
		 
		return item;
	}
}
