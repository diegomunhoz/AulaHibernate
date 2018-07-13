package br.com.choice.hibernate.dao;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.com.choice.hibernate.bean.Endereco;
import br.com.choice.hibernate.util.HibernateUtil;

public class EnderecoDAO extends GenericDAO{
	
	public Endereco buscarPorCodigo (Long codigo) throws Exception{
		Session sessao = null;
		Endereco Endereco = null;

		sessao = HibernateUtil.getSessionFactory().openSession();
		Endereco = (Endereco) sessao.get(Endereco.class, codigo);

		return Endereco;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Endereco> buscarTodos() throws Exception{
		ArrayList<Endereco> listaRetorno = new ArrayList<Endereco>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Endereco.class);
		
		criteria.addOrder (Order.asc("codigo"));
		
		listaRetorno = (ArrayList<Endereco>) criteria.list();
		
		return listaRetorno;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Endereco> pesquisarPorNome(String nome) throws Exception{
		ArrayList<Endereco> listaRetorno = new ArrayList<Endereco>();
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = sessao.createCriteria(Endereco.class);

		criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));

		criteria.addOrder(Order.asc("nome"));
		
		listaRetorno = (ArrayList<Endereco>) criteria.list();
		
		return listaRetorno;
	}
}