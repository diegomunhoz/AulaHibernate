package br.com.choice.hibernate.teste;

import br.com.choice.hibernate.bean.Funcionario;
import br.com.choice.hibernate.dao.FuncionarioDAO;

public class TesteBuscaFuncionario {

	public static void main(String[] args) {

		Funcionario funcionario = new Funcionario();
		FuncionarioDAO dao = new FuncionarioDAO();
		
		try {
			funcionario = dao.buscarPorCodigo(1);
			System.out.println(funcionario.getEndereco().getLogadouro());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
