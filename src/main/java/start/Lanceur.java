package start;

import Presenter.Presenter;
import model.facade.FacadeMetierFactory;
import view.facade.FacadeVueFactory;

public class Lanceur {
	
private static Presenter presenter = new Presenter(FacadeMetierFactory.fabriquerFacadeMetier(), FacadeVueFactory.fabriquerFacadeVue());
	
	public static void main(String[] args) {
		try {
			presenter.executer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
