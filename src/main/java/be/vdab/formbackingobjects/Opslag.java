package be.vdab.formbackingobjects;

import java.math.BigDecimal;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

public class Opslag {
	
	@NotNull @Min(1)
	private BigDecimal bedrag;
	
	public BigDecimal getBedrag() {
		return bedrag;
	}
	public void setBedrag(BigDecimal bedrag) {
		this.bedrag = bedrag;
	}

}
