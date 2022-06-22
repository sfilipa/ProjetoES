package modelo;

import java.util.ArrayList;
import java.util.List;

public class DadosAplicacao {
    public static final DadosAplicacao INSTANCE = new DadosAplicacao();
    ;
    private List<Veiculo> veiculos;
    private List<Evento> eventos;
    private String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
    private List<Cliente> clientes;

    private DadosAplicacao() {
        veiculos = new ArrayList<>();
        eventos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
        System.out.println("Evento adicionado");
        System.out.println(evento.toString());
        System.out.println(eventos.size());
    }

    public void removerEvento(Evento evento) {
        eventos.remove(evento);
    }

    public void editarEvento(Evento evento, String nome, Data dataInicio, Data datafim, Integer nVeiculos, String distrito, String local){
        evento.setNome(nome);
        evento.setnVeiculos(nVeiculos);
        evento.setDataInicio(dataInicio);
        evento.setDataFim(datafim);
        evento.setLocal(local);
        evento.setDistrito(distrito);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }


    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public boolean existeVeiculoComMatricula(String matricula) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeEventoNome(String nome) {
        if (!eventos.isEmpty()) {
            for (Evento evento : eventos) {
                if (evento.getNome().equals(nome)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existeClienteNome(String nome) {
        if (!clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                if (cliente.getNome().equals(nome)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean existeClienteNif(String nif) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nif)) {
                return true;
            }
        }
        return false;
    }

    public boolean temCaracteresEspeciais(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (specialCharactersString.contains(Character.toString(string.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    public boolean isNumero(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isDataValida(String data) {
        Data data_final = Data.parseData(data);

        if (data_final == null) {
            return false;
        }
        System.out.println(data_final.toString());
        int dia = data_final.getDia();
        int mes = data_final.getMes();
        int ano = data_final.getAno();
        //System.out.println("dia: " + dia + " mes: " + mes + " ano: " + ano);
        return (dia > 0 && dia < 32 && mes > 0 && mes < 13 && ano > 0);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Evento> getEventos() {//devolve todos os eventos
        return eventos;
    }

    public static List<Evento> getEventos(Data dataInicio, Data dataFim, String distrito) {
        List<Evento> eventos = new ArrayList<>();
        for (Evento evento : DadosAplicacao.INSTANCE.getEventos()) {
            if (evento.getDataInicio().equals(evento.getDataInicio(),dataInicio) &&
                    evento.getDataFim().equals(evento.getDataFim(), dataFim) &&
                    evento.getDistrito().equals(distrito)) {
                eventos.add(evento);
            }
        }
        return eventos;
    }

    public static List<Evento> getEventosDataInicioEDistrito(Data dataInicio, String distrito) {
        List<Evento> eventos = new ArrayList<>();
        for (Evento evento : DadosAplicacao.INSTANCE.getEventos()) {
            if (evento.getDataInicio().equals(evento.getDataInicio(),dataInicio) &&
                    evento.getDistrito().equals(distrito)) {
                eventos.add(evento);
            }
        }
        return eventos;
    }

    public static List<Evento> getEventosDataFimEDistrito(Data dataFim, String distrito) {
        List<Evento> eventos = new ArrayList<>();
        for (Evento evento : DadosAplicacao.INSTANCE.getEventos()) {
            if (evento.getDataFim().equals(evento.getDataFim(), dataFim) && evento.getDistrito().equals(distrito)) {
                eventos.add(evento);
            }
        }
        return eventos;
    }

    public static List<Evento> getEventos(Data dataInicio, Data dataFim) {
        List<Evento> eventos = new ArrayList<>();
        for (Evento evento : DadosAplicacao.INSTANCE.getEventos()) {
            if (evento.getDataInicio().getCalendar().getTimeInMillis() == dataInicio.getCalendar().getTimeInMillis() &&
                    evento.getDataFim().getCalendar().getTimeInMillis() == dataFim.getCalendar().getTimeInMillis()) {
                eventos.add(evento);
            }
        }
        return eventos;
    }

    public static List<Evento> getEventosDataInicio(Data dataInicio) {
        List<Evento> eventos = new ArrayList<>();
        for (Evento evento : DadosAplicacao.INSTANCE.getEventos()) {
            if (evento.getDataInicio().getCalendar().getTimeInMillis() == dataInicio.getCalendar().getTimeInMillis()) {
                eventos.add(evento);
            }
        }
        return eventos;
    }

    public static List<Evento> getEventosDataFim(Data dataFim) {
        List<Evento> eventos = new ArrayList<>();
        for (Evento evento : DadosAplicacao.INSTANCE.getEventos()) {
            if (evento.getDataFim().getCalendar().getTimeInMillis() == dataFim.getCalendar().getTimeInMillis()) {
                eventos.add(evento);
            }
        }
        return eventos;
    }

    public static List<Evento> getEventos(String distrito) {
        List<Evento> eventos = new ArrayList<>();
        for (Evento evento : DadosAplicacao.INSTANCE.getEventos()) {
            if (evento.getDistrito().equals(distrito)) {
                eventos.add(evento);
            }
        }
        return eventos;
    }
}
