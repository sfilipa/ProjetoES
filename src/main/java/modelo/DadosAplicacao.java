package modelo;

import java.util.ArrayList;
import java.util.List;

public class DadosAplicacao {
    public static final DadosAplicacao INSTANCE = new DadosAplicacao();

    private List<Veiculo> veiculos;
    private List<Evento> eventos;
    private String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
    private List<Cliente> clientes;

    private List<Peca> pecas;

    private DadosAplicacao() {
        veiculos = new ArrayList<>();
        eventos = new ArrayList<>();
        clientes = new ArrayList<>();

        veiculos.add(new Veiculo("XJ-88-MM", "BMW", "K5", 5, "Laura", "jkdsfn", 5,500, 54553, 525,456, "manual","traseira", "Bom","Diesel", "Filial Leiria"));
        veiculos.add(new Veiculo("XJ-99-MM", "BMW", "K5", 5, "Pedro", "jkdsfn", 5,500, 54553, 525,456, "manual","traseira", "Bom","Diesel", "Filial Porto"));
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);

        System.out.println("Veiculo adicionado");
        System.out.println(veiculo.toString());
        System.out.println(veiculos.size());
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

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void editarEvento(Evento evento, String nome, Data dataInicio, Data datafim, Integer nVeiculos, String distrito, String local) {
        evento.setNome(nome);
        evento.setnVeiculos(nVeiculos);
        evento.setDataInicio(dataInicio);
        evento.setDataFim(datafim);
        evento.setLocal(local);
        evento.setDistrito(distrito);
    }

    public void transportarVeiculo(Veiculo veiculo, String localParaTransportar) {
        veiculo.setLocalArmazenamento(localParaTransportar);
    }

    public void editarVeiculo(Veiculo veiculo, String matricula, String marca, String modelo, Integer Ndonos, String donoAnterior, String categoria, Integer classe, Integer Nportas, Integer potencia, Integer quilometros, Integer cilindrada, String tipoDeCaixa, String tracao, String condicaoGeral, String combustivel ,String localarmazenamento) {
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setMatricula(matricula);
        veiculo.setNdonos(Ndonos);
        veiculo.setDonoAnterior(donoAnterior);
        veiculo.setCategoria(categoria);
        veiculo.setClasse(classe);
        veiculo.setNportas(Nportas);
        veiculo.setPotencia(potencia);
        veiculo.setQuilometros(quilometros);
        veiculo.setCilindrada(cilindrada);
        veiculo.setTipoDeCaixa(tipoDeCaixa);
        veiculo.setTracao(tracao);
        veiculo.setCondicaoGeral(condicaoGeral);
        veiculo.setCombustivel(combustivel);
        veiculo.setLocalArmazenamento(localarmazenamento);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarPeca(Peca peca){
        pecas.add(peca);
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


    public boolean existeClienteNif(Integer nif) {
        for (Cliente cliente : clientes) {
            if (cliente.getNif()==nif) {
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
            if (dataInicio != null) {
                if (evento.getDataInicio().equals(evento.getDataInicio(), dataInicio)) {
                    if (!eventos.contains(evento)) {
                        eventos.add(evento);
                    }
                }

            }
            if (dataFim != null) {
                if (evento.getDataFim().equals(evento.getDataFim(), dataFim)) {
                    if (!eventos.contains(evento)) {
                        eventos.add(evento);
                    }
                }
            }
            if (distrito != null) {
                if (evento.getDistrito().equals(distrito)) {
                    if (!eventos.contains(evento)) {
                        eventos.add(evento);
                    }
                }
            }
        }
        return eventos;
    }

    public static List<Veiculo> getVeiculos(String marca, String combustivel, String tipoCaixa, String condicaoGeral, Integer quilometros) {
        List<Veiculo> veiculos = new ArrayList<>();
        for (Veiculo veiculo : DadosAplicacao.INSTANCE.getVeiculos()) {
            if (marca != null) {
                if (veiculo.getMarca().equals(marca))
                    if (!veiculos.contains(veiculo)) {
                        veiculos.add(veiculo);
                    }
            }
            if (combustivel != null) {
                if (veiculo.getCombustivel().equals(combustivel)) {
                    if (!veiculos.contains(veiculo)) {
                        veiculos.add(veiculo);
                    }
                }
            }
            if (tipoCaixa != null) {
                if (veiculo.getTipoDeCaixa().equals(tipoCaixa)) {
                    if (!veiculos.contains(veiculo)) {
                        veiculos.add(veiculo);
                    }
                }
            }
            if (condicaoGeral != null) {
                if (veiculo.getCondicaoGeral().equals(condicaoGeral)) {
                    if (!veiculos.contains(veiculo)) {
                        veiculos.add(veiculo);
                    }
                }
            }
            if (quilometros != null) {
                if (veiculo.getQuilometros() == quilometros) {
                    if (!veiculos.contains(veiculo)) {
                        veiculos.add(veiculo);
                    }
                }
            }
        }
        return veiculos;

    }


    public static List<Cliente> getClientes(Integer nif) {
        List<Cliente> clientes = new ArrayList<>();
        for (Cliente cliente : DadosAplicacao.INSTANCE.getClientes()) {

            if (nif != null) {
                if (cliente.getNif() == nif) {
                    if (!clientes.contains(cliente)) {
                        clientes.add(cliente);
                    }
                }
                }
            }

        return clientes;
    }




    public boolean existePecaNome(String nome) {
        if (!pecas.isEmpty()) {
            for (Peca peca : pecas) {
                if (peca.getNome().equals(nome)) {
                    return true;
                }
            }
        }
        return false;
    }


}
