package br.edu.ifba.basicas;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Veiculo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String modelo;
	private String montadora;

    @ManyToMany
    @JoinTable(
        name = "historico_servico",
        joinColumns = @JoinColumn(name = "servico_id"),
        inverseJoinColumns = @JoinColumn(name = "veiculo_id")
    )

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private List<Servico> servico;

    @OneToMany(cascade = CascadeType.ALL)
	private Cliente cliente;


    public Veiculo(int id, String modelo, String montadora, Cliente cliente) {
        this.id = id;
        this.modelo = modelo;
        this.montadora = montadora;
        this.cliente = cliente;
    }

    public Veiculo() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMontadora() {
        return montadora;
    }
    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", modelo=" + modelo + ", montadora=" + montadora + ", cliente=" + cliente + "]";
    }
    
}
