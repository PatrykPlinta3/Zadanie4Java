package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {
	private String x;
	private String y;
	private String z;
	
	
	
	public String getZ() {
		return z;
	}





	public void setZ(String z) {
		this.z = z;
	}





	private Double result;
	private Double result2;
	public String getX() {
		return x;
	}





	public void setX(String x) {
		this.x = x;
	}





	public String getY() {
		return y;
	}





	public void setY(String y) {
		this.y = y;
	}


	public boolean doTheMath() {
		try {
			double x = Double.parseDouble(this.x);
			double y = Double.parseDouble(this.y);
			double z = Double.parseDouble(this.z);
			result = x * y ;
			result2 = x * y + (x*y*z*0.01);
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}


	@Inject
	FacesContext ctx;





	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wartość netto: " + result +"zł, Wartość brutto:" + result2+"zł", null));
		}

		return null;
	}


}
