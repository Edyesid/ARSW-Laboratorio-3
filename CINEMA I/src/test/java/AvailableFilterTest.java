import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.eci.arsw.cinema.filter.AvailableFilter;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;

public class AvailableFilterTest {
	 @Test
	 	public void BuenIngresoFiltro(){
	        AvailableFilter filtro = new AvailableFilter();
	        List<CinemaFunction> Listfunctions= new ArrayList<>();
	        CinemaFunction function1 = new CinemaFunction(new Movie("fast and furious","Action"),"2020-12-81 15:30");
	        CinemaFunction function2 = new CinemaFunction(new Movie("Son Como niños","Comedy"),"2020-12-18 15:30");
	        CinemaFunction function3 = new CinemaFunction(new Movie("Cars","Animated"),"2020-12-18 15:30");
	        Listfunctions.add(function1);
	        Listfunctions.add(function2);
	        Listfunctions.add(function3);

	        try{
	            filtro.filtro(Listfunctions, "3");
	        }catch (CinemaException e){
	                assertEquals("No hay funciones con la cantidad de sillas disponibles que desea", e.getMessage() );
	        }  
	    }
	 
	 @Test
	 	public void MalIngresoFiltro(){
		 	AvailableFilter filtro = new AvailableFilter();
	        List<CinemaFunction> Listfunctions= new ArrayList<>();
	        CinemaFunction function1 = new CinemaFunction(new Movie("fast and furious","Action"),"2020-12-81 15:30");
	        CinemaFunction function2 = new CinemaFunction(new Movie("Son Como niños","Comedy"),"2020-12-18 15:30");
	        CinemaFunction function3 = new CinemaFunction(new Movie("Cars","Animated"),"2020-12-18 15:30");
	        Listfunctions.add(function1);
	        Listfunctions.add(function2);
	        Listfunctions.add(function3);

	        try{
	            filtro.filtro(Listfunctions, "-5");
	        }catch (CinemaException e){
	                assertEquals("Filtro invalido, ingrese un numero entero mayor a 0", e.getMessage() );
	        }  
	    }
	 
	 @Test
	    public void filtrarCondicionesCorrectas() throws CinemaException{
	        List<CinemaFunction> Listfunctions= new ArrayList<>();
	        AvailableFilter filtro = new AvailableFilter();
	        CinemaFunction function1 = new CinemaFunction(new Movie("Obsesion secreta","Drama"),"2020-12-18 15:30");
	        Listfunctions.add(function1);
	        function1.buyTicket(0, 0);
	        function1.buyTicket(1, 1);
	        function1.buyTicket(2, 2);
	        function1.buyTicket(3, 3);
	        
	        try{
	            filtro.filtro(Listfunctions, "81");
	        }
	        catch (CinemaException e){
	                assertEquals("No hay funciones con la cantidad de sillas disponibles que desea", e.getMessage() );
	        } 
	        
	    }


}
