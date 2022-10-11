package be.iesca.ebar.domaine;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum EtatCommande {
    @Enumerated(EnumType.STRING)
    CREEE() {};

    @Enumerated(EnumType.STRING)
    void CONFIRMEE() {}

    @Enumerated(EnumType.STRING)
    void PRETE(){}

    @Enumerated(EnumType.STRING)
    void LIVREE(){}

    @Enumerated(EnumType.STRING)
    void ARCHIVEE(){}
}
