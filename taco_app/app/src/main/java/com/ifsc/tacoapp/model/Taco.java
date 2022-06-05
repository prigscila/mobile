package com.ifsc.tacoapp.model;

public class Taco {
    private Integer id;
    private String categoria;
    private String alimento;
    private String umidade;
    private String energiakcal;
    private String kJ;
    private String proteonag;
    private String lipodeosg;
    private String colesterolmg;
    private String carboidratosg;
    private String fibraAlimentarg;
    private String cinzasg;
    private String calciomg;
    private String magnesiomg;
    private String manganesmg;
    private String fosforomg;
    private String ferromg;
    private String sodiomg;
    private String potassiomg;
    private String cobremg;
    private String zincomg;
    private String retinolmcg;
    private String rEmcg;
    private String rAEmcg;
    private String tiaminamg;
    private String riboflavinamg;
    private String piridoxinamg;
    private String niacinamg;
    private String vitaminaCmg;

    public Taco(
            Integer id,
            String categoria,
            String alimento,
            String umidade,
            String energiakcal,
            String kJ,
            String proteonag,
            String lipodeosg,
            String colesterolmg,
            String carboidratosg,
            String fibraAlimentarg,
            String cinzasg,
            String calciomg,
            String magnesiomg,
            String manganesmg,
            String fosforomg,
            String ferromg,
            String sodiomg,
            String potassiomg,
            String cobremg,
            String zincomg,
            String retinolmcg,
            String rEmcg,
            String rAEmcg,
            String tiaminamg,
            String riboflavinamg,
            String piridoxinamg,
            String niacinamg,
            String vitaminaCmg
    ) {
        this.id = id;
        this.categoria = categoria;
        this.alimento = alimento;
        this.umidade = umidade;
        this.energiakcal = energiakcal;
        this.kJ = kJ;
        this.proteonag = proteonag;
        this.lipodeosg = lipodeosg;
        this.colesterolmg = colesterolmg;
        this.carboidratosg = carboidratosg;
        this.fibraAlimentarg = fibraAlimentarg;
        this.cinzasg = cinzasg;
        this.calciomg = calciomg;
        this.magnesiomg = magnesiomg;
        this.manganesmg = manganesmg;
        this.fosforomg = fosforomg;
        this.ferromg = ferromg;
        this.sodiomg = sodiomg;
        this.potassiomg = potassiomg;
        this.cobremg = cobremg;
        this.zincomg = zincomg;
        this.retinolmcg = retinolmcg;
        this.rEmcg = rEmcg;
        this.rAEmcg = rAEmcg;
        this.tiaminamg = tiaminamg;
        this.riboflavinamg = riboflavinamg;
        this.piridoxinamg = piridoxinamg;
        this.niacinamg = niacinamg;
        this.vitaminaCmg = vitaminaCmg;
    }

    public Integer getId() {
        return this.id;
    }

    public String getAlimento() {
        return this.alimento;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getUmidade() {
        return this.umidade;
    }
}

