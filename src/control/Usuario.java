package control;

public class Usuario {
	
		public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getSituacaoUsuario() {
		return situacaoUsuario;
	}

	public void setSituacaoUsuario(String situacaoUsuario) {
		this.situacaoUsuario = situacaoUsuario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public int getPadrao() {
		return padrao;
	}

	public void setPadrao(int padrao) {
		this.padrao = padrao;
	}

	public int getCadastro() {
		return cadastro;
	}

	public void setCadastro(int cadastro) {
		this.cadastro = cadastro;
	}

	public int getAltera_privi() {
		return altera_privi;
	}

	public void setAltera_privi(int altera_privi) {
		this.altera_privi = altera_privi;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public int getAtivo_site() {
		return ativo_site;
	}

	public void setAtivo_site(int ativo_site) {
		this.ativo_site = ativo_site;
	}

	public int getPrivilegioId() {
		return privilegioId;
	}

	public void setPrivilegioId(int privilegioId) {
		this.privilegioId = privilegioId;
	}

	public int getNivelUsuario() {
		return nivelUsuario;
	}

	public void setNivelUsuario(int nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}

		String loginUsuario,nomeUsuario,senhaUsuario, situacaoUsuario,funcao;
		int usuarioId,nivelUsuario,padrao,cadastro,altera_privi,situacao,ativo_site,privilegioId;
		public int getUsuarioId() {
			return usuarioId;
		}

		public void setUsuarioId(int usuarioId) {
			this.usuarioId = usuarioId;
		}
}
