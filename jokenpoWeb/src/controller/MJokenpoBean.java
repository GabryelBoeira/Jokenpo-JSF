package controller;


import java.io.IOException;
import java.text.ParseException;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dal.JogadorDAO;
import model.Jogador;
import service.JokenpoService;

@SessionScoped
@ManagedBean(name = "mJokenpoBean")
public class MJokenpoBean {
	private Jogador gamer = new Jogador();
	
	private String Jogada = new String();

	
	public void rodada(String jogada) throws ParseException, IOException {
		String maquina = JokenpoService.vezMaquina();
		if(jogada != "") {
			if(!maquina.equalsIgnoreCase(jogada)){
				if(JokenpoService.processarJogada(maquina, jogada)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Opa!", "O jogador ganhou esta rodada"));
				}else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Opa!", "A maquina ganhou esta rodada"));
				}			
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Opa!", "Empate ninguém ganhou"));
			}		
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Opa!", "Escolha uma opções valida"));
		}
	}

	public String getJogada() {
		return Jogada;
	}

	public void setJogada(String jogada) {
		Jogada = jogada;
	}
	
	public Jogador getGamer() {
		return JogadorDAO.buscarJogador();
	}

}
