import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.eci.arsw.cinema.filter.GenderFilter;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;

public class GenderFilterTest {
	 @Test
	 public void SiEstaElGenero(){
	        GenderFilter filtro = new GenderFilter();
	        List<CinemaFunction> Listfunctions= new ArrayList<>();
	        CinemaFunction function1 = new CinemaFunction(new Movie("fast and furious","Action"),"2020-12-81 15:30");
	        CinemaFunction function2 = new CinemaFunction(new Movie("Son Como niños","Comedy"),"2020-12-18 15:30");
	        CinemaFunction function3 = new CinemaFunction(new Movie("Cars","Animated"),"2020-12-18 15:30");
	        Listfunctions.add(function1);
	        Listfunctions.add(function2);
	        Listfunctions.add(function3);

	        try{
	            filtro.filtro(Listfunctions, "Comedy");
	        }catch (CinemaException e){
	                assertEquals("No hay funciones con el genero que desea", e.getMessage() );
	        }  
	    }

	 
	 @Test
	    public void NoEstaElGenero(){
	        GenderFilter filtro = new GenderFilter();
	        List<CinemaFunction> Listfunctions= new ArrayList<>();
	        CinemaFunction function1 = new CinemaFunction(new Movie("Black Panter","Action"),"2020-12-81 15:30");
	        CinemaFunction function2 = new CinemaFunction(new Movie("El Chanfle","Comedy"),"2020-12-18 15:30");
	        CinemaFunction function3 = new CinemaFunction(new Movie("Annabelle","Horror"),"2020-12-18 15:30");
	        Listfunctions.add(function1);
	        Listfunctions.add(function2);
	        Listfunctions.add(function3);

	        try{
	            filtro.filtro(Listfunctions, "Drama");
	        }catch (CinemaException e){
	                assertEquals("No hay funciones con el genero que desea", e.getMessage() );
	        }  
	    }
}