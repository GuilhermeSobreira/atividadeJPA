package br.edu.ifba.principal;


import java.util.List;


import br.edu.ifba.basicas.Categoria;
import br.edu.ifba.basicas.Cliente;
import br.edu.ifba.basicas.Endereco;
import br.edu.ifba.dao.GetEntityManager;
import jakarta.persistence.EntityManager;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = GetEntityManager.getConnectionJpa();
		
//		Categoria cat = new Categoria();
//		cat.setDescricao("Professores");
//		
//		em.getTransaction().begin();
//		
//		em.persist(cat);
//		
//		em.getTransaction().commit();
		
		Cliente c = new Cliente();
//		
//		c.setNome("Sicrano");
//		c.setCpf("0568953");
//		c.setRg("956233254");
//		c.setCategoria(em.find(Categoria.class, 1));
//		
		Endereco e = new Endereco();
//		
		e.setBairro("Tal");
		e.setCep("48562-000");
		e.setCidade("Lá longe");
		e.setEstado("Bahia");
		e.setNumero("200");
		e.setRua("Lá");
//		
//		c.setEndereco(e);
		
		c = em.find(Cliente.class, 2);
		
		c.setEndereco(e);
		
		
		em.getTransaction().begin();
		
		em.merge(c);
		
		em.getTransaction().commit();

//		System.out.println(c);
		
		
		List<Cliente> list = em.createQuery("select c from Cliente c",Cliente.class).getResultList();
		
		list.forEach(System.out::println);

	}

}
