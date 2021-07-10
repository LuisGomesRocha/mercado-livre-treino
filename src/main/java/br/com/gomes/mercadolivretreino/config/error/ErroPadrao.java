package br.com.gomes.mercadolivretreino.config.error;

import java.util.Collection;

public class ErroPadrao {

    private Collection<String> mensagens;

    public ErroPadrao(Collection<String> mensagens){
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }
}
