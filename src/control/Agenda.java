package control;

public class Agenda {
	int idAgenda, idPaciente,vlProcedimento,situacao,registroAgenda;
	public int getRegistroAgenda() {
		return registroAgenda;
	}
	public void setRegistroAgenda(int registroAgenda) {
		this.registroAgenda = registroAgenda;
	}
	public int getVlProcedimento() {
		return vlProcedimento;
	}
	public void setVlProcedimento(int vlProcedimento) {
		this.vlProcedimento = vlProcedimento;
	}
	String procedimento,data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public String getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}
}
