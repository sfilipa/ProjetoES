package modelo;

import java.util.ArrayList;
import java.util.List;

public class DadosAplicacao {
    public static final DadosAplicacao INSTANCE = new DadosAplicacao();;
    private List<Veiculo> veiculos;
    private List<Evento> eventos;
    private String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

    private DadosAplicacao(){
        veiculos = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    public void adicionarEvento(Evento evento){
        eventos.add(evento);
        System.out.println("Evento adicionado");
        System.out.println(evento.toString());
        System.out.println(eventos.size());
    }



    public List<Veiculo> getVeiculos(){
        return veiculos;
    }

    public boolean existeVeiculoComMatricula(String matricula){
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }
    public boolean existeEventoNome(String nome){
        if(!eventos.isEmpty()) {
            for (Evento evento : eventos) {
                if (evento.getNome().equals(nome)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean temCaracteresEspeciais(String string){
        for (int i = 0; i < string.length(); i++) {
            if (specialCharactersString.contains(Character.toString(string.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumero(String string){
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public boolean isDataValida(String data){
        Data data_final = Data.parseData(data);

        if(data_final == null){
            return false;
        }
        System.out.println(data_final.toString());
        int dia = data_final.getDia();
        int mes = data_final.getMes();
        int ano = data_final.getAno();
        //System.out.println("dia: " + dia + " mes: " + mes + " ano: " + ano);
        return (dia > 0 && dia < 32 && mes > 0 && mes < 13 && ano > 0);
    }
    

   public List<Evento> getEventos() {//devolve todos os eventos
        return eventos;
    }
/*
     public List<Evento> getEventos(Veiculo veiculo) {//devolve todos os eventos com aquele veiculo
   //TODO
        return eventos;
    }

    public List<Veiculo> getCriancas() {
        return veiculos;
    }*/
}
