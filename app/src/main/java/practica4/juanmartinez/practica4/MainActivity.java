package practica4.juanmartinez.practica4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static String STATE_LISTA_ELEMENTOS = "net.iessochoa.joseantoniolopez.ejemplospractica4.ListaConReconstruccionActivity.lista_elementos";

    ListView lvLista;
    //datos para la  lista
    ArrayList<Elemento> al_datos;
    ElementosAdapter adaptadorLista;
    int n=1;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

                getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // SKDAJSDÑFKAJSDFÑLKASDJFÑALSKDJFAÑS LDKFJASDÑFLKJ ASDÑLF

        lvLista= findViewById(R.id.lvListaPoblaciones);
        //si es la primera vez que se crea la activity
        if(savedInstanceState == null) {//creamos unos datos a mostrar
            //añadimos unos cuantos datos de prueba
            crearDatos();
        }else {//Venimos de una recreación ya que tenemos datos en el bundle y recuperamos los datos
            al_datos=savedInstanceState.getParcelableArrayList(STATE_LISTA_ELEMENTOS);
        }
        adaptadorLista=new ElementosAdapter(this,R.layout.item_poblacion,al_datos);
        lvLista.setAdapter(adaptadorLista);
        //Evento de click sobre un elemento de la lista
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Creamos un cuadro de dialogo para que veais como se implementa
                Elemento elemento=(Elemento)adapterView.getItemAtPosition(i);
                androidx.appcompat.app.AlertDialog.Builder dialogo = new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Hola");// titulo y mensaje

                dialogo.setMessage(getString(R.string.msg_selection)+elemento.getV1()+"-"+elemento.getV2());
                // agregamos botón Ok y su evento
                dialogo.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Qué hacemos en caso ok

                    }
                });
                //Si queremos incluir la opción de cancelar
                /*dialogo.setNegativeButton(android.R.string.no
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Qué hacemos en caso cancel
                            }
                        });*/
                dialogo.show();
            }
        });
        //Evento para un long click
        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,( "Hola"+ i),Toast.LENGTH_SHORT).show();

                //Importante, para que no ejecute después el evento click,  tiene que devolver true
                return true;
            }
        });



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.mnAcercade:
               showDialogMenu();
               break;

               default: break;

        }
        return true;
    }

    public void showDialogMenu(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dlogAcercaTitle);
        builder.setMessage(R.string.dlogAcercaMessage);
        builder.setPositiveButton(R.string.dlogOK, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int item) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }



    /**
     * Ejecutamos este método para comprobar que ocurre cuando no se controla
     * la recreación de la  Activity
     */
    private void crearDatos() {
        al_datos=new ArrayList<Elemento>();
        String v1 = "titulo";
        String v2 = "dato";
        String v3 = "Donec ut lorem est. Suspendisse vel porttitor turpis. Aenean gravida elit nec sodales hendrerit. Vivamus non tellus eu sapien malesuada imperdiet. Sed eget diam vitae sem mattis scelerisque. Morbi sed elementum urna. Praesent egestas, nulla sit amet porttitor eleifend";
        for (int i = 0; i <= 10; i++) {
            al_datos.add(new Elemento(v1 + i, v2 + i, v3 + i));
        }
    }


    }

