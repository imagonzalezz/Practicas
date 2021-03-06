package ud.prog3.pr01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;




/** Clase para crear instancias como listas de reproducci�n,
 * que permite almacenar listas de ficheros con posici�n de �ndice
 * (al estilo de un array / arraylist)
 * con marcas de error en los ficheros y con m�todos para cambiar la posici�n
 * de los elementos en la lista, borrar elementos y a�adir nuevos.
 */
public class ListaDeReproduccion implements ListModel<String> {
	ArrayList<File> ficherosLista;     // ficheros de la lista de reproducci�n
	int ficheroEnCurso = -1;           // Fichero seleccionado (-1 si no hay ninguno seleccionado)
	private static Logger logger = Logger.getLogger( ListaDeReproduccion.class.getName() ); //la creo ya que no estaba creada

	private static final boolean ANYADIR_A_FIC_LOG = false; // poner true para no sobreescribir
	static {
		try {
			logger.addHandler( new FileHandler(ListaDeReproduccion.class.getName()+".log.xml", ANYADIR_A_FIC_LOG ));
		} catch (SecurityException | IOException e) {
			logger.log( Level.SEVERE, "Error en creación fichero log" );
		}
	} 

	/** Devuelve uno de los ficheros de la lista
	 * @param posi	Posici�n del fichero en la lista (de 0 a size()-1)
	 * @return	Devuelve el fichero en esa posici�n
	 * @throws IndexOutOfBoundsException	Si el �ndice no es v�lido
	 */

	public ListaDeReproduccion() {
		misEscuchadores = new ArrayList<>();
		ficherosLista = new ArrayList<>();
	}


	public void intercambia(int posi1, int posi2) {
		ficherosLista.set(posi1, this.ficherosLista.get(posi2));
		File res= ficherosLista.get(posi1);
		ficherosLista.set(posi2, res);

	}

	public int size() {
		return ficherosLista.size();
	}

	public void add(File f) {
		ficherosLista.add(f);

	}

	public void removeFic(int posi) {
		ficherosLista.remove(posi);
	}

	public void clear() {
		ficherosLista.clear();

	}

	public boolean irARandom() {
	    if (ficherosLista.size() == 0) {
	      ficheroEnCurso = -1;
	    }
		return false;
	    
	}


	public File getFic( int posi ) throws IndexOutOfBoundsException {
		return ficherosLista.get( posi );
	}	

	/** A�ade a la lista de reproducci�n todos los ficheros que haya en la 
	 * carpeta indicada, que cumplan el filtro indicado.
	 * Si hay cualquier error, la lista de reproducci�n queda solo con los ficheros
	 * que hayan podido ser cargados de forma correcta.
	 * @param carpetaFicheros	Path de la carpeta donde buscar los ficheros
	 * 							String con cualquier letra o d�gito. Si tiene un asterisco
	 * 							hace referencia a cualquier conjunto de letras o d�gitos.
	 * 							Por ejemplo p*.* hace referencia a cualquier fichero de nombre
	 * 							que empiece por p y tenga cualquier extensi�n.
	 * @return	N�mero de ficheros que han sido a�adidos a la lista
	 */

	public int add(String carpetaFicheros, String filtroFicheros) {
		// TODO: Codificar este m�todo de acuerdo a la pr�ctica (pasos 3 y sucesivos)
		logger.log( Level.INFO, "Añadiendo ficheros con filtro " + filtroFicheros ); 

		filtroFicheros = filtroFicheros.replaceAll( "\\.", "\\\\." );  // Pone el s�mbolo de la expresi�n regular \. donde figure un .
		filtroFicheros = filtroFicheros.replaceAll("\\*", ".*");

		logger.log( Level.INFO, "Consulta ficheros con filtro " + filtroFicheros ); 

		File fInic = new File(carpetaFicheros);
		Pattern ficsPattern = Pattern.compile(filtroFicheros, 2);

		if (fInic.isDirectory()) {
			for( File f : fInic.listFiles() ) {
				logger.log( Level.FINE, "Procesando fichero " + f.getName() );

				if (ficsPattern.matcher(f.getName()).matches()) {
					logger.log(Level.INFO, "Añadido" + f.getName());
					add(f);
				}
			}

		}
		return 0;
	}




	//
	// M�todos de selecci�n
	//

	/** Seleciona el primer fichero de la lista de reproducci�n
	 * @return	true si la selecci�n es correcta, false si hay error y no se puede seleccionar
	 */
	public boolean irAPrimero() {
		ficheroEnCurso = 0;  // Inicia
		if (ficheroEnCurso>=ficherosLista.size()) {
			ficheroEnCurso = -1;  // Si no se encuentra, no hay selecci�n
			return false;  // Y devuelve error
		}
		return true;
	}

	/** Seleciona el �ltimo fichero de la lista de reproducci�n
	 * @return	true si la selecci�n es correcta, false si hay error y no se puede seleccionar
	 */
	public boolean irAUltimo() {
		ficheroEnCurso = ficherosLista.size()-1;  // Inicia al final
		if (ficheroEnCurso==-1) {  // Si no se encuentra, no hay selecci�n
			return false;  // Y devuelve error
		}
		return true;
	}

	/** Seleciona el anterior fichero de la lista de reproducci�n
	 * @return	true si la selecci�n es correcta, false si hay error y no se puede seleccionar
	 */
	public boolean irAAnterior() {
		if (ficheroEnCurso>=0) ficheroEnCurso--;
		if (ficheroEnCurso==-1) {  // Si no se encuentra, no hay selecci�n
			return false;  // Y devuelve error
		}
		return true;
	}

	/** Seleciona el siguiente fichero de la lista de reproducci�n
	 * @return	true si la selecci�n es correcta, false si hay error y no se puede seleccionar
	 */
	public boolean irASiguiente() {
		ficheroEnCurso++;
		if (ficheroEnCurso>=ficherosLista.size()) {
			ficheroEnCurso = -1;  // Si no se encuentra, no hay selecci�n
			return false;  // Y devuelve error
		}
		return true;
	}

	/** Devuelve el fichero seleccionado de la lista
	 * @return	Posici�n del fichero seleccionado en la lista de reproducci�n (0 a n-1), -1 si no lo hay
	 */
	public int getFicSeleccionado() {
		return ficheroEnCurso;
	}

	//
	// M�todos de DefaultListModel
	//

	@Override
	public int getSize() {
		return ficherosLista.size();
	}

	@Override
	public String getElementAt(int index) {
		return ficherosLista.get(index).getName();
	}

	// Escuchadores de datos de la lista
	ArrayList<ListDataListener> misEscuchadores = new ArrayList<>();
	@Override
	public void addListDataListener(ListDataListener l) {
		misEscuchadores.add( l );
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		misEscuchadores.remove( l );
	}

	// Llamar a este m�todo cuando se a�ada un elemento a la lista
	// (Utilizado para avisar a los escuchadores de cambio de datos de la lista)
	private void avisarAnyadido( int posi ) {
		for (ListDataListener ldl : misEscuchadores) {
			ldl.intervalAdded( new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, posi, posi ));
		}
	}
}
