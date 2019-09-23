package service;

import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JokenpoService {

	private enum opcoes{
		PAPEL, PEDRA, TESOURA
	}
	
	public static String vezMaquina(){
		opcoes[] escolhas = opcoes.values();
        Random random = new Random();
        int index = random.nextInt(escolhas.length);
        return escolhas[index].name();
    }	

	public static boolean processarJogada(String maquina, String jogada) {
		boolean status = true;
		switch (maquina) {
			case "PAPEL":			
				if(jogada.equalsIgnoreCase("pedra")) {
					status = false;
				}				
				break;
			case "PEDRA":
				if(jogada.equalsIgnoreCase("tesoura")) {
					status = false;
				}
				break;
			case "TESOURA":
				if(jogada.equalsIgnoreCase("papel")) {
					status = false;
				}
				break;		
			default:
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "iiiiiii!", "A maquina errou"));
				status = true;
				break;
		}
		return status;
	}		
}
