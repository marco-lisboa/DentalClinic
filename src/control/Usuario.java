package control;

public class Usuario {
	
		public String getLoginUsuario() {
		return loginUsuario;
	}

	public int getpCadAgenda() {
			return pCadAgenda;
		}

		public void setpCadAgenda(int pCadAgenda) {
			this.pCadAgenda = pCadAgenda;
		}

		public int getpAcessReceber() {
			return pAcessReceber;
		}

		public void setpAcessReceber(int pAcessReceber) {
			this.pAcessReceber = pAcessReceber;
		}

		public int getpRealizaOrcamento() {
			return pRealizaOrcamento;
		}

		public void setpRealizaOrcamento(int pRealizaOrcamento) {
			this.pRealizaOrcamento = pRealizaOrcamento;
		}

		public int getpCadServico() {
			return pCadServico;
		}

		public void setpCadServico(int pCadServico) {
			this.pCadServico = pCadServico;
		}

		public int getpLivroCaixa() {
			return pLivroCaixa;
		}

		public void setpLivroCaixa(int pLivroCaixa) {
			this.pLivroCaixa = pLivroCaixa;
		}

		public int getpChamada() {
			return pChamada;
		}

		public void setpChamada(int pChamada) {
			this.pChamada = pChamada;
		}

		public int getpSincroniza() {
			return pSincroniza;
		}

		public void setpSincroniza(int pSincroniza) {
			this.pSincroniza = pSincroniza;
		}

		public int getpAtualizar() {
			return pAtualizar;
		}

		public void setpAtualizar(int pAtualizar) {
			this.pAtualizar = pAtualizar;
		}

		public int getpAcessConfig() {
			return pAcessConfig;
		}

		public void setpAcessConfig(int pAcessConfig) {
			this.pAcessConfig = pAcessConfig;
		}

		public int getpCadEmpresas() {
			return pCadEmpresas;
		}

		public void setpCadEmpresas(int pCadEmpresas) {
			this.pCadEmpresas = pCadEmpresas;
		}

		public int getpRealizaRecebimento() {
			return pRealizaRecebimento;
		}

		public void setpRealizaRecebimento(int pRealizaRecebimento) {
			this.pRealizaRecebimento = pRealizaRecebimento;
		}

		public int getpRealizaRecebimentoAvulso() {
			return pRealizaRecebimentoAvulso;
		}

		public void setpRealizaRecebimentoAvulso(int pRealizaRecebimentoAvulso) {
			this.pRealizaRecebimentoAvulso = pRealizaRecebimentoAvulso;
		}

		public int getpExcluirFinanceiro() {
			return pExcluirFinanceiro;
		}

		public void setpExcluirFinanceiro(int pExcluirFinanceiro) {
			this.pExcluirFinanceiro = pExcluirFinanceiro;
		}

		public int getpEstorna() {
			return pEstorna;
		}

		public void setpEstorna(int pEstorna) {
			this.pEstorna = pEstorna;
		}

		public int getpAcessGenFin() {
			return pAcessGenFin;
		}

		public void setpAcessGenFin(int pAcessGenFin) {
			this.pAcessGenFin = pAcessGenFin;
		}

		public int getpCadDespesas() {
			return pCadDespesas;
		}

		public void setpCadDespesas(int pCadDespesas) {
			this.pCadDespesas = pCadDespesas;
		}

		public int getpCadFornecedor() {
			return pCadFornecedor;
		}

		public void setpCadFornecedor(int pCadFornecedor) {
			this.pCadFornecedor = pCadFornecedor;
		}

		public int getpAcessRelatorios() {
			return pAcessRelatorios;
		}

		public void setpAcessRelatorios(int pAcessRelatorios) {
			this.pAcessRelatorios = pAcessRelatorios;
		}

		public int getpCadFuncionarios() {
			return pCadFuncionarios;
		}

		public void setpCadFuncionarios(int pCadFuncionarios) {
			this.pCadFuncionarios = pCadFuncionarios;
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
		return cadastroUsuario;
	}

	public void setCadastro(int cadastro) {
		this.cadastroUsuario = cadastro;
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
		
		int usuarioId,nivelUsuario,padrao,cadastroUsuario,altera_privi,situacao,ativo_site,privilegioId,pCadCliente,
		pCadAgenda,pAcessReceber,pRealizaOrcamento,pCadServico,pLivroCaixa,pChamada,pSincroniza,
		pAtualizar,pAcessConfig,pCadEmpresas,pRealizaRecebimento,pRealizaRecebimentoAvulso,pExcluirFinanceiro,
		pEstorna,pAcessGenFin,pCadDespesas,pCadFornecedor,pAcessRelatorios,pCadFuncionarios,pCadContasBancos,pAcessFolha;
		public int getpAcessFolha() {
			return pAcessFolha;
		}

		public void setpAcessFolha(int pAcessFolha) {
			this.pAcessFolha = pAcessFolha;
		}

		public int getpCadContasBancos() {
			return pCadContasBancos;
		}

		public void setpCadContasBancos(int pCadContasBancos) {
			this.pCadContasBancos = pCadContasBancos;
		}

		public int getpCadCliente() {
			return pCadCliente;
		}

		public void setpCadCliente(int pCadCliente) {
			this.pCadCliente = pCadCliente;
		}

		public int getUsuarioId() {
			return usuarioId;
		}

		public void setUsuarioId(int usuarioId) {
			this.usuarioId = usuarioId;
		}
}
