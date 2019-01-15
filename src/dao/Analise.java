package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class Analise {
	/*
	DialagoUsuario menssagem = new DialagoUsuario();
	DialagoErro erro = new DialagoErro();
	Aluno aluno = new Aluno();
	*/
	//Conexão com banco de dados - MAYNORECOMENTS
	
	private Connection con;
	private PreparedStatement stmt;
	
	private final String USER = "root";
	private final String PASS = "maynore";
	private String URL = null;
	private ResultSet bd = null;
	
	
	public void conectar(String ip){
		 URL = "jdbc:mysql://"+ip+":3306/mgest_bd";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,PASS);
			
		} catch (ClassNotFoundException | SQLException e) {
			erro.textPaneErro.setText("FOI INDENTIFICADO QUE COM CONEX\u00C3O COM SERVIDOR N\u00C3O FOI COMPLETADA SIGA OS PASSO A SEGUIR:\r\n1- VERIFIQUE O NOME OU IP SERVIDOR BANCO DE DADOS\r\n2-CERTIFIQUESE QUE A PORTA 3366 DO SERVIDOR SE ENCONTRA LIBERADA NO SERVIDOR\r\n3- RELIZER UM TESTE DE CONEX\u00C3O COM SERVIDOR E VERIFIQUE SE ELE SE ENCONTRA EM REDE.\r\n\r\nCASO O PROBLEMA PERSISTA OU TENHA ALGUMA DUVIDA ENTRE EM CONTATO COM SUPORTE E INFORME O ERRO ABAIXO.\r\n----------------------------------------------------------------------------------------------"
					+e.getMessage());
			erro.show();
		}
	}
	/*---------------------------------------------------------------------*/
	//Execulção banco de dados - MAYNORECOMENTS

	//Validação login - MAYNORECOMENTS
	public boolean logado;

	int id_usuario;
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	String nome_usuario;

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public void Acesso(String log_usuario,String senha_usuario,String ip){

		Connection conectado = null;
		Statement consulta = null;
		ResultSet retorno= null;

		try{

			Class.forName("com.mysql.jdbc.Driver");
			conectado = DriverManager.getConnection("jdbc:mysql://"+ip+"/mgest_bd/INTtech?useSSL=false","root","maynore");
			consulta = (Statement) conectado.createStatement();
			retorno = ( (java.sql.Statement) consulta).executeQuery("select log, senha from table_usuario where log='"+log_usuario+"'and senha='"+senha_usuario+"'");
			if(retorno.next()){

				logado=true;
			}else{
				menssagem.texto.setText("USUARIO OU SENHA INCORRETOS");
				menssagem.show();
				logado=false;
			}	
		}catch (Exception e){

			e.getMessage();

		}


	}

	public void DadosUsuario(String nome){
		String sql= "SELECT * FROM table_usuario where log='"+nome+"';";
		try {
			stmt =  con.prepareStatement(sql);
			bd = stmt.executeQuery();
			while (bd.next()) {
				setId_usuario(Integer.parseInt(bd.getString("id_usuario")));
				setNome_usuario(bd.getString("nome"));

			}

		} catch (SQLException e) {
			erro.textPaneErro.setText(e.getMessage());
			erro.show();
		}

	}

	
	/*-------------------------------------------------------------------------------------------------------------------------------------------*/
	/***************************************************************************
	 * 																		   *
	 * 							T03 - METODOS                                  *
	 *                                                                         *
	 ***************************************************************************/
	/*---------------------------------------------------------------------*/
	//DAO_CONNECT- ALUNO - T03-A
	/*----------------------------------------------------------------------*/	
	//VARIAVEIS PARA RETORNO BANCO DE DADOS 	

	//CADASTRO ALUNO - COMENTARIOS MAYNORE SOFT
	public void inserirAluno(Aluno aluno){
		String sql = "INSERT INTO table_aluno (nome_aluno,rg_aluno,org_expedidor,cpf_aluno,sexo,nacionalidade,estado,"
					+ "cidade,bairro,rua,cep,nume_casa,telefone,telefone_2,celular,celular_2,email,facebook,idade_aluno,altura,peso,"
					+ "imc,possui_doenca,doencaCardiaca,paradaRespiratoria,hipertencao,historicoFamilia,situacao_aluno,dtNasciAluno,foto)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		try {
			
			stmt =  con.prepareStatement(sql);
			stmt.setString(1, aluno.getNome_aluno());
			stmt.setString(2, aluno.getRg_aluno() );
			stmt.setString(3, aluno.getOrg_exp());
			stmt.setString(4,aluno.getCpf_aluno());
			stmt.setString(5, aluno.getSexo_aluno());
			stmt.setString(6,aluno.getNacionalidade_aluno());
			stmt.setString(7,aluno.getEstado_aluno());
			stmt.setString(8, aluno.getCidade_aluno());
			stmt.setString(9,aluno.getBairro_aluno());
			stmt.setString(10, aluno.getRua_aluno());
			stmt.setString(11,aluno.getCep_aluno());
			stmt.setString(12, aluno.getNumero_casa());
			stmt.setString(13, aluno.getTel1_aluno());
			stmt.setString(14, aluno.getTel2_aluno());
			stmt.setString(15,aluno.getCelu1_aluno());
			stmt.setString(16,aluno.getCelu2_aluno());
			stmt.setString(17,aluno.getEmail_Aluno());
			stmt.setString(18, aluno.getFace_aluno());
			stmt.setString(19, aluno.getIdade_Aluno());
			stmt.setString(20,aluno.getAltura_aluno());
			stmt.setString(21, aluno.getPeso_aluno());
			stmt.setString(22, aluno.getImc_aluno());
			stmt.setInt(23, aluno.getPossui_doenca());
			stmt.setString(24, aluno.getDoenca_cardiaca());
			stmt.setInt(25, aluno.getParada_respiratoria());
			stmt.setInt(26, aluno.getHipertencao());
			stmt.setInt(27, aluno.getHistorico_familia());
			stmt.setString(28, aluno.getSit_aluno());
			stmt.setString(29, aluno.getDtNascimento_aluno());
			stmt.setBytes(30, aluno.getImagem());
			stmt.execute();
			menssagem.texto.setText("CADASTRO REALIZADO COM SUCESSO");
			menssagem.show();
			
		} catch (SQLException e) {
			erro.textPaneErro.setText(e.getMessage());
			erro.show();
		}
	}
	//FIM CADASTRO ALUNO
	/*-------------------------------------------------------------------------------------------------------------------------------------------*/
	// ALTERA DADOS ALUNO - COMENTARIOS MAYNORE
	public void alterar(Aluno aluno){
		String sql = "UPDATE table_aluno SET nome_aluno =?,rg_aluno =?,org_expedidor =?,cpf_aluno =?,sexo =?,nacionalidade =?,estado=?"
				+ ",cidade =?,bairro=?,rua=?,cep=?,nume_casa=?,telefone=?,telefone_2 =?,celular = ?,celular_2= ?,email=?,facebook=?"
				+ ",idade_aluno=?,altura=?,peso=?,imc=?,possui_doenca=?,doencaCardiaca =?,paradaRespiratoria=?,hipertencao=?,historicoFamilia=?"
				+ ",situacao_aluno=?,dtNasciAluno=?,foto=? where idAluno =?;";
	
	try {
		
		stmt =  con.prepareStatement(sql);
		stmt.setString(1, aluno.getNome_aluno());
		stmt.setString(2, aluno.getRg_aluno() );
		stmt.setString(3, aluno.getOrg_exp());
		stmt.setString(4,aluno.getCpf_aluno());
		stmt.setString(5, aluno.getSexo_aluno());
		stmt.setString(6,aluno.getNacionalidade_aluno());
		stmt.setString(7,aluno.getEstado_aluno());
		stmt.setString(8, aluno.getCidade_aluno());
		stmt.setString(9,aluno.getBairro_aluno());
		stmt.setString(10, aluno.getRua_aluno());
		stmt.setString(11,aluno.getCep_aluno());
		stmt.setString(12, aluno.getNumero_casa());
		stmt.setString(13, aluno.getTel1_aluno());
		stmt.setString(14, aluno.getTel2_aluno());
		stmt.setString(15,aluno.getCelu1_aluno());
		stmt.setString(16,aluno.getCelu2_aluno());
		stmt.setString(17,aluno.getEmail_Aluno());
		stmt.setString(18, aluno.getFace_aluno());
		stmt.setString(19, aluno.getIdade_Aluno());
		stmt.setString(20,aluno.getAltura_aluno());
		stmt.setString(21, aluno.getPeso_aluno());
		stmt.setString(22, aluno.getImc_aluno());
		stmt.setInt(23, aluno.getPossui_doenca());
		stmt.setString(24, aluno.getDoenca_cardiaca());
		stmt.setInt(25, aluno.getParada_respiratoria());
		stmt.setInt(26, aluno.getHipertencao());
		stmt.setInt(27, aluno.getHistorico_familia());
		stmt.setString(28, aluno.getSit_aluno());
		stmt.setString(29, aluno.getDtNascimento_aluno());
		stmt.setBytes(30, aluno.getImagem());
		stmt.setInt(31,aluno.getMatricula_aluno());
		stmt.execute();
		menssagem.texto.setText("ALTERAÇÃO REALIZADA COM SUCESSO");
		menssagem.show();
		
	} catch (SQLException e) {
		erro.textPaneErro.setText(e.getMessage());
		erro.show();
	}
		
	}
	// FIM ALTERA ALUNO - COMENTARIOS MAYNORE
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	//DADOS ALUNO - COMENTARIOS MAYNORE
	public void dadosAluno(int id,Aluno aluno){
		String sql = "select * from table_aluno where idAluno='"+id+"';";
		
		
		try {
			
			stmt = con.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			while(res.next()){
				
				aluno.setNome_aluno(res.getString("nome_aluno"));
				aluno.setRg_aluno(res.getString("rg_aluno"));
				aluno.setOrg_exp(res.getString("org_expedidor"));
				aluno.setCpf_aluno(res.getString("cpf_aluno"));
				aluno.setSexo_aluno(res.getString("sexo"));
				aluno.setNacionalidade_aluno(res.getString("nacionalidade"));
				aluno.setEstado_aluno(res.getString("estado"));
				aluno.setCidade_aluno(res.getString("cidade"));
				aluno.setBairro_aluno(res.getString("bairro"));
				aluno.setRua_aluno(res.getString("rua"));
				aluno.setCep_aluno(res.getString("cep"));
				aluno.setNumero_casa(res.getString("nume_casa"));
				aluno.setTel1_aluno(res.getString("telefone"));
				aluno.setTel2_aluno(res.getString("telefone_2"));
				aluno.setCelu1_aluno(res.getString("celular"));
				aluno.setCelu2_aluno(res.getString("celular_2"));
				aluno.setEmail_Aluno(res.getString("email"));
				aluno.setFace_aluno(res.getString("facebook"));
				aluno.setIdade_Aluno(res.getString("idade_aluno"));
				aluno.setAltura_aluno(res.getString("altura"));
				aluno.setPeso_aluno(res.getString("peso"));
				aluno.setImc_aluno(res.getString("imc"));	
				aluno.setPossui_doenca(res.getInt("possui_doenca"));
				aluno.setDoenca_cardiaca(res.getString("doencaCardiaca"));
				aluno.setParada_respiratoria(res.getInt("paradaRespiratoria"));
				aluno.setHipertencao(res.getInt("hipertencao"));
				aluno.setHistorico_familia(res.getInt("historicoFamilia"));
				aluno.setSit_aluno(res.getString("situacao_aluno"));
				aluno.setDtNascimento_aluno(res.getString("dtNasciAluno"));
				aluno.setImagem(res.getBytes("foto"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//FIM DADOS ALUNO - COMENTARIOS MAYNORE
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	public void fecharCon(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
