package javaWebApplication.Beans;

public class RecordIdAlteration {

	private int id;
	private int novoAtendente;
	private int novoServico;
	private int novoDia;
	private int novoHora;

	public RecordIdAlteration(int id,int novoAtendente, int novoServico, int novoDia, int novoHora) {
		
		this.id = id;
		this.novoAtendente= novoAtendente;
		this.novoDia = novoDia;
		this.novoServico = novoServico;
		this.novoHora = novoHora;
	}
	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}
	public int getNovoAtendente() {

		return novoAtendente;

	}

	public void setNovoAtendente(int novoAtendente) {

		this.novoAtendente = novoAtendente;

	}

	public int getNovoServico() {

		return novoServico;

	}

	public void setNovoServico(int novoServico) {

		this.novoServico = novoServico;

	}

	public int getNovoDia() {

		return novoDia;

	}

	public void setNovoDia(int novoDia) {

		this.novoDia = novoDia;

	}

	public int getNovoHora() {

		return novoHora;

	}

	public void setNovoHora(int novoHora) {

		this.novoHora = novoHora;

	}

}
