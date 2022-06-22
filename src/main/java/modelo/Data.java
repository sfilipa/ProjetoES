package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {

    private Calendar calendar;

    public Data(int dia, int mes, int ano){

        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes);
        calendar.set(Calendar.YEAR, ano);
        //this.calendar = new GregorianCalendar(ano, mes-1, dia);
    }

    public Calendar getCalendar(){ return this.calendar; }

    public static Data parseData(String data){

        /*String[] dataSplit = data.split("/");
        try{
            int dia = Integer.parseInt(dataSplit[0]);
            int mes = Integer.parseInt(dataSplit[1]);
            int ano = Integer.parseInt(dataSplit[2]);

            return new Data(dia,mes,ano);
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            return null;
        }*/
        var formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        try{
            var d = formato.parse(data); //o ponto de falha é aqui no parse, em que falha a conversão
            var cal = new GregorianCalendar();
            cal.setTime(d);

            int dia = cal.get(Calendar.DAY_OF_MONTH);
            int mes = cal.get(Calendar.MONTH) + 1;
            int ano = cal.get(Calendar.YEAR);

            return new Data(dia,mes,ano);
        }catch (ParseException e){
            return null;
        }
        //ou this.calendar = new GregorianCalendar(ano, mes-1,dia); -> deixava adicionar datas inválidas (aceito qualquer coisa)
    }
    public int getDia(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getMes(){
        return calendar.get(Calendar.MONTH);
    }

    public int getAno(){
        return calendar.get(Calendar.YEAR);
    }



    @Override
    public String toString() {
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH);
        int ano = calendar.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + ano;
    }
}
