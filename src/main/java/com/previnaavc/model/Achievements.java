package com.previnaavc.model;

import java.util.Locale;

public enum Achievements {

    FORMER_SMOKER("Did not go back to smoking", "Não voltou a fumar"),
    VERY_ACTIVE("Exercising 3 times a week", "Se exercitando 3 vezes por semana"),
    NOT_FEARFUL("Level of anxiety under control", "Nível de ansiedade sob controle"),
    NOT_CRITICAL_OF_OTHERS("Level of anger under control", "Nível de irritação sob controle"),
    NOT_CRYING_EASILY("Living happily", "Vivendo de forma alegre"),
    DRINK_IN_MODERATION("Drinking in moderation", "Bebendo com moderação"),
    ACTIVE("Exercising twice a week", "Se exercitando 2 vezes por semana"),
    FORMER_ALCOHOLIC("Did not go back to drinking", "Não voltou a beber");

    private String en;
    private String ptBr;

    Achievements(String en, String ptBr) {
        this.en = en;
        this.ptBr = ptBr;
    }

    public String getTip(Locale locale) {
        if (new Locale("pt", "BR").equals(locale)) {
            return ptBr;
        } else {
            return en;
        }
    }
}
