package br.edu.ifba.principal;

import java.util.List;

import br.edu.ifba.basicas.Cliente;
import br.edu.ifba.basicas.Endereco;
import br.edu.ifba.dao.GetEntityManager;
import jakarta.persistence.EntityManager;

public class Principal {
    public static void main(String[] args) {
        EntityManager em = GetEntityManager.getConnectionJpa();
        
        // criar cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Sicrano");
        cliente.setCpf("0568953");
        cliente.setEmail("sicrano@gmail.com");
        
        // criar endereço
        Endereco endereco = new Endereco();
        endereco.setBairro("Tal");
        endereco.setCep("48562-000");
        endereco.setCidade("Lá longe");
        endereco.setNumero("200");
        endereco.setRua("Lá");
        
        cliente.setEndereco(endereco);
        
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        
        // buscar cliente e atualizar endereço
        Cliente clienteEncontrado = em.find(Cliente.class, 2);
        if (clienteEncontrado != null) {
            clienteEncontrado.setEndereco(endereco);
            
            em.getTransaction().begin();
            em.merge(clienteEncontrado);
            em.getTransaction().commit();
        }

        //listar
        List<Cliente> listaClientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        listaClientes.forEach(System.out::println);
    }
}