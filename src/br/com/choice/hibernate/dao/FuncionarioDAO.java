package br.com.choice.hibernate.dao;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.com.choice.hibernate.bean.Funcionario;
import br.com.choice.hibernate.util.HibernateUtil;

public class FuncionarioDAO extends GenericDAO{
	
	public Funcionario buscarPorCodigo (int codigo) throws Exception{
		Session sessao = null;
		Funcionario Funcionario = null;

		sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionario = (Funcionario) sessao.get(Funcionario.class, codigo);

		return Funcionario;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Funcionario> buscarTodos() throws Exception{
		ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Funcionario.class);
		
		criteria.addOrder (Order.asc("codigo"));
		
		listaRetorno = (ArrayList<Funcionario>) criteria.list();
		
		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Funcionario> pesquisarPorNome(String nome) throws Exception{
		ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Funcionario.class);

		criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));

		criteria.addOrder(Order.asc("nome"));
		
		listaRetorno = (ArrayList<Funcionario>) criteria.list();
		
		return listaRetorno;
	}
}