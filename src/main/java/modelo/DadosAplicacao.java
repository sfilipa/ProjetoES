package modelo;

import java.util.ArrayList;
import java.util.List;

public class DadosAplicacao {
    public static final DadosAplicacao INSTANCE = new DadosAplicacao();;
    private List<Veiculo> veiculos;
    private List<Evento> eventos;

    private DadosAplicacao(){
        veiculos = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    public void adicionarEvento(Evento evento){
        eventos.add(evento);
    }

    public List<Veiculo> getVeiculos(){
        return veiculos;
    }

    public boolean existeVeiculoComMatricula(String matricula){
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMatricula().equals(veiculo)) {
                return true;
            }
        }
        return false;
    }

   /* public List<Evento> getEventos() {//devolve todos os eventos
        return eventos;
    }

     public List<Evento> getEventos(Veiculo veiculo) {//devolve todos os eventos com aquele veiculo
   //TODO
        return eventos;
    }

    public List<Veiculo> getCriancas() {
        return veiculos;
    }*/
}
