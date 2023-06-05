package br.com.targettrust.enderecoapicep.config;

public class ItauApiImpl implements BancoApiService {
    @Override
    public String getBankName() {
        return "itau";
    }
}
