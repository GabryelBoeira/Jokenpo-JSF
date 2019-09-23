package dal;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import conexao.Conexao;
import model.Jogador;

public class JogadorDAO{
	
	public static boolean cadastrarJogador(Jogador jogador){
		excluirJogadores();
		try {
			
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.persist(jogador);
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	protected static void excluirJogadores() {
		
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("DELETE FROM JOGADOR").executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	public static Jogador buscarJogador() {
		
		EntityManager em = Conexao.getEntityManager();
		Query query = em.createNativeQuery("SELECT * FROM JOGADOR", Jogador.class);

        return (Jogador) query.getSingleResult();
	}	
}