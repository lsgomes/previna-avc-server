package com.previnaavc.model;

import java.util.Locale;

public enum RiskFactorTips {

    NEVER_SMOKED("Try to never smoke.", "Tente nunca fumar."),
    SMOKER("Try to stop smoking.", "Tente parar de fumar."),
    FEARFUL("Try to feel less anxious.", "Tente se sentir menos ansioso(a)."),
    FORMER_ALCOHOLIC("Try not to drink again.", "Tente não voltar a beber."),
    INACTIVE("Exercise at least 1 or 2 times this week.", "Pratique exercícios físicos pelo menos 1 ou 2 vezes essa semana."),
    CRY_EASILY("Try to live happier.", "Tente viver mais alegremente."),
    ACTIVE("Exercise once again this week.", "Pratique exercícios físicos mais uma vez essa semana."),
    ABSTAIN("Try to drink in moderation during the week.", "Tente beber com moderação durante a semana."),
    CRITICAL_OF_OTHERS("Try to get less irritated.", "Tente se irritar menos."),
    FORMER_SMOKER("Try not to go back to smoking.", "Tente não voltar a fumar."),
    VERY_ACTIVE("Try to keep exercising 3 times a week.", "Tente manter se exercitando 3 vezes por semana."),
    DRINKER("Try to drink less during the week.", "Tente beber menos durante a semana."),
    NOT_CRYING_EASILY("Living happily", "Vivendo de forma alegre"),
    DRINK_IN_MODERATION("Try to continue drinking in moderation.", "Tente continuar bebendo com moderação.");

    private String en;
    private String ptBr;

    RiskFactorTips(String en, String ptBr) {
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
