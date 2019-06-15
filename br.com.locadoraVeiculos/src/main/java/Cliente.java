

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
	
	private String cnh;

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	

}
