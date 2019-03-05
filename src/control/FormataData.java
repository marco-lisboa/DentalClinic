package control;

public class FormataData {
//
	String datafinal;
	public String getDatafinal() {
		return datafinal;
	}
	public void setDatafinal(String datafinal) {
		this.datafinal = datafinal;
	}
	public void Formatar(String i,int opera) {
		
		String dia,mes,ano,dt[];
		if(opera==1) {
			
			if(i.equals("  /  /    ")) {
				setDatafinal(null);
			}else {
				dt=i.split("/");
				dia = dt[0];
				mes=dt[1];
				ano=dt[2];
				setDatafinal(ano+"-"+mes+"-"+dia);
				
			}
			
		}else {
			if(i!=null) {
			dt=i.split("-");
			ano=dt[0];
			mes=dt[1];
			dia = dt[2];
			setDatafinal(dia+"/"+mes+"/"+ano);
			}else {
				setDatafinal("");
			}
		}
		
		
	}
}
