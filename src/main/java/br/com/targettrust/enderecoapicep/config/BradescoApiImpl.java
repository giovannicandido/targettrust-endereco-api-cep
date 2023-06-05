package br.com.targettrust.enderecoapicep.config;

public class BradescoApiImpl implements BancoApiService {

    @Override
    public String getBankName() {
        return "bradesco";
    }
}
