package view.facade;

public final class FacadeVueFactory {

	private FacadeVueFactory() {}
	
	
public static FacadeVue fabriquerFacadeVue() {	
	return new FacadeVueimpl();
}

}
