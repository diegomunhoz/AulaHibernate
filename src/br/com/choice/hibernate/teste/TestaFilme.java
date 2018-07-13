package br.com.choice.hibernate.teste;

import javax.swing.JOptionPane;

import br.com.choice.hibernate.bean.Filme;
import br.com.choice.hibernate.dao.FilmeDAO;

public class TestaFilme {

	public static void main(String[] args) {
		Filme filme = new Filme();
		FilmeDAO dao = new FilmeDAO();
		filme.setNome("A Era do Gelo 3");
		filme.setValor(1.50);
		filme.setDisponivel("SIM");
		filme.setGenero("Animação");
		if (dao.salvar(filme)) {
			JOptionPane.showMessageDialog(null, "Filme salvo com sucesso");
		}
		
		
	}

}