package unirio.es1.TransLogAPI.domain;

public enum CargoEnum {
    CLIENTE(0, "ROLE_CLIENTE"),
    ORCAMENTO(1, "ROLE_ORCAMENTO"),
    LOGISTICA(2, "ROLE_LOGISTICA"),
    TRANSPORTE(3, "ROLE_TRASNPORTE");

    private Integer cod;
    private String desc;

    public static CargoEnum toEnum(Integer code){
        if(code == null){
            return null;
        }

        for(CargoEnum c : CargoEnum.values()){
            if(code.equals(c.getCod())){
                return c;
            }
        }

        throw new IllegalArgumentException("Codigo invalido:" + code);
    }

    CargoEnum(Integer cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }
}
