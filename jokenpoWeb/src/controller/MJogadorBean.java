package controller;

import java.io.IOException;
import java.text.ParseException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dal.JogadorDAO;
import model.Jogador;

@SessionScoped
@ManagedBean(name = "mJogadorBean")
public class MJogadorBean {
	private Jogador gamer = new Jogador();

	public void cadastrar(Jogador gamer) throws ParseException, IOException {	
		
		if(org.h2.util.StringUtils.isNullOrEmpty(gamer.getNome()))
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Nome do jogador deve ser preenchido"));
		} else if(JogadorDAO.cadastrarJogador(gamer))
		{
		    FacesContext.getCurrentInstance().getExternalContext().redirect("PartidaJokenpo.xhtml"); 
		}else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Não foi possivel iniciar o jogo"));
		}		
	}
	
	public Jogador getGamer() {
		return gamer;
	}

	public void setGamer(Jogador gamer) {
		this.gamer = gamer;
	}
}
