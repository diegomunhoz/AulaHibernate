package br.com.choice.hibernate.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.choice.hibernate.bean.Endereco;
import br.com.choice.hibernate.bean.Funcionario;
import br.com.choice.hibernate.dao.EnderecoDAO;
import br.com.choice.hibernate.dao.FuncionarioDAO;

public class TesteInserirFuncionario {

	public static void main(String[] args) {
		new TesteInserirFuncionario().inserir();
		new TesteInserirFuncionario().listar();
	}
	
	public void listar(){
		FuncionarioDAO daoFuncionario = new FuncionarioDAO();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		try {
			lista = daoFuncionario.buscarTodos();
			for (Funcionario func : lista) {
				func.getEndereco().getBairro();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void inserir() {
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO daoFuncionario = new FuncionarioDAO();
		
		Endereco endereco = new Endereco();
		EnderecoDAO daoEndereco = new EnderecoDAO();

		endereco.setLogadouro("RUA ANTONIO PRADO");
		endereco.setNumero("123");
		endereco.setBairro("CENTRO");
		
		daoEndereco.salvar(endereco);
		
		funcionario.setNome("TESTE");
		funcionario.setCargo("DIREÇÃO");
		funcionario.setEndereco(endereco);
		funcionario.setSalario(123.45);
		
		daoFuncionario.salvar(funcionario);		
	}

}