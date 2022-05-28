package br.com.goet.apiportugues.utils;
import java.util.ArrayList;

import br.com.goet.apiportugues.model.Metrica;

public class FuncoesPortugues {

	public boolean ehConsoante(char letra)
    {
        int i;
        char[] consoantes = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','x','w','y','z',
                'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','X','W','Y','Z'};
        for (i=0; i < consoantes.length; i++)
        {
            if (letra == consoantes[i])
                return true;
        }
        return false;
    }
	 
	public boolean ehVogal(char letra)
    {
        int i;
        char[] vogais = {'a','e','i','o','u','A','E','I','O','U','á','Á','é','É','ê','Ê','ú','Ú','Ó','ó','í','Í','â','Â'};
        for (i=0; i < vogais.length; i++)
        {
            if (letra == vogais[i]) {
                return true;
            }
        }
        return false;
    }
	
    public boolean ehPontuacao(char letra)
    {
        int i;
        char[] pontuacao = {',','.','!','?',':',';','(',')','-'};
        for (i=0; i < pontuacao.length; i++)
        {
            if (letra == pontuacao[i])
                return true;
        }
        return false;
    }
    
    public boolean testaAcentuadaeEspecial (String trecho)
    {
        int i,u;
        char[] vogais = {'á','Á','é','É','ó','Ó','ô','í','Í','ú','Ú','ê','Ê','ã','Ã','õ','Õ','â','Â'};
        for (i=0; i < trecho.length(); i++)
        {
            for (u=0; u < vogais.length; u++)
            {
                if (trecho.charAt(i) == vogais[u])
                    return true;
            }

        }
        return false;
    }
    
    public boolean ehvogalAcentuada(char letra)
    {
        int i;
        char[] vogais = {'á','Á','é','É','ó','Ó','í','Í','ú','Ú','ê','Ê'};
        for (i=0; i < vogais.length; i++)
        {
            if (letra == vogais[i])
                return true;
        }
        return false;
    }

    public boolean ehEspecial(char letra)
    {
        int i;
        char[] especial = {'ã','Ã','õ','Õ'};
        for (i=0; i < especial.length; i++)
        {
            if (letra == especial[i])
                return true;
        }
        return false;
    }

    
    public boolean testaOxitona (String trecho)
    {
        int i;
        char[] terminacoes = {'r','l','z','x','i','u'};
        String duasUltimasLetras = trecho.substring(trecho.length()-2,trecho.length());
        if(duasUltimasLetras.equals("im")  || duasUltimasLetras.equals("um") ||duasUltimasLetras.equals("om")  ){
            return true;
        }
        for (i=0; i < terminacoes.length; i++)
        {
            if (trecho.charAt(trecho.length()-1)==terminacoes[i]){
                return true;

            }

        }
        return false;
    }
    
    public String separaMetrica(String Frase)
    {
        int i,u, p = 0, pp;
        String nextLetra = "";
        String Esp = " /";
        String ResultMetrica = "";
        int ab;
        boolean encontrouVogal = false, duasConsoantes = false;

        String aa[] = {"a / a","a / e","a / i","a / o","a / u","e / a","e / e","e / i","e / o","e / u","i / a","i / e","i / i","i / o","i / u", "o / a","o / e","o / i","o / o","o / u","u / a","u / e","u / i","u / o","u / u","-","/  /"};
        String bb[] = {"a a","a e","a i","a o","a u","e a","e e","e i","e o","e u","i a","i e","i i","i o","i u", "o a","o e","o i","o o","o u","u a","u e","u i","u o","u u","- /"," /"};

        Frase = Frase + Esp;


        for (i=0; i< Frase.length(); i++)
        {



            if ( ehVogal(Frase.charAt(i)) || ehEspecial(Frase.charAt(i)) || Frase.charAt(i) == ' ')
            {
                int auxI = i;
                p = i+1;
                pp = i+2;

                if (pp >= Frase.length()-1 )
                    pp = Frase.length()-1;
                if (p >= Frase.length()-1 )
                    p = Frase.length()-1;

                if (Frase.charAt(i) == ' ' && Frase.charAt(p) != '/')
                {
                    ResultMetrica += Esp;
                }
                if ( (ehConsoante(Frase.charAt(p))  && (Frase.charAt(pp) == ' ')) )
                {}
                else if ( ( (Frase.charAt(p) == ' '  &&  ehConsoante(Frase.charAt(pp)))) )
                {

                }
                else if (((ehConsoante(Frase.charAt(p))  && ehConsoante(Frase.charAt(pp)) )  &&
                        ((Frase.charAt(pp) != 'H') && (Frase.charAt(pp) != 'h') && (Frase.charAt(pp) != 'l') && (Frase.charAt(pp) != 'r') && (Frase.charAt(p) != Frase.charAt(pp)) ))
                        || ( (ehConsoante(Frase.charAt(p))  && ehConsoante(Frase.charAt(pp)) ) && Frase.charAt(pp) == 'r' && Frase.charAt(p) == 'n' ))
                /*((ehConsoante(Frase.charAt(p))  && ehConsoante(Frase.charAt(pp)) )  &&
                        ((Frase.charAt(p) != 'r') && (Frase.charAt(p) != 's') && (Frase.charAt(pp) == 'r'))) ||
                ((ehConsoante(Frase.charAt(p))  && ehConsoante(Frase.charAt(pp)) )  &&
                        ((Frase.charAt(p) != 's') && (Frase.charAt(p) != 'r') && (Frase.charAt(pp) == 's'))))*/
                {

                    duasConsoantes = true;
                    nextLetra = Frase.charAt(i+1) + "";
                }
                /* else if (Frase.charAt(p) == ' ')  //proximo valor Frase.charAt(p)
                {

                }*/
                else if (
                        (((ehVogal(Frase.charAt(p)) && (Frase.charAt(i) != Frase.charAt(p) ) )  || (Frase.charAt(p) == ' ') )) ) //proximo valor Frase.charAt(p)
                {

                }
                else if (
                        (((ehVogal(Frase.charAt(i)) &&  (ehVogal(Frase.charAt(p)))  || (Frase.charAt(p) == ' ') )) )) //proximo valor Frase.charAt(p)
                {

                }
                else if (
                        ((ehEspecial(Frase.charAt(i))  && ehVogal(Frase.charAt(p)) )) ) //proximo valor Frase.charAt(p)
                {

                }
                else if (Frase.charAt(i) != ' '&& (!(ehPontuacao(Frase.charAt(i+1))))){
                    ResultMetrica += Frase.charAt(i) + Esp;
                    encontrouVogal = true;
                }
            }
            if (duasConsoantes == true)
            {
                ResultMetrica += (Frase.charAt(i)) + nextLetra + Esp;
                i++;
                duasConsoantes = false;
            }
            else if (encontrouVogal != true)
            {
                ResultMetrica += Frase.charAt(i);
            }
            encontrouVogal = false;



        }


        for (ab = 0; ab< 27; ab++)
        {
            ResultMetrica = ResultMetrica.replaceAll(aa[ab], bb[ab]);
        }


        return ResultMetrica;

    }
    
    public String separadorSilabas(String Frase)
    {
        int i,u, p = 0, pp;
        String nextLetra = "";
        String Esp = " |";
        String Result = "";
        boolean encontrouVogal = false, duasConsoantes = false, temEspaco = false;

        Frase = Frase + Esp;


        for (i=0; i< Frase.length(); i++)
        {
            if (Frase.charAt(i) == ' ' && Frase.charAt(i+1) != '|' )
            {
                Result += Esp;
            }

            if ( ehVogal(Frase.charAt(i)) || ehEspecial(Frase.charAt(i)))
            {

                p = i+1;
                pp = i+2;

                if (pp >= Frase.length()-1 )
                    pp = Frase.length()-1;
                if (p >= Frase.length()-1 )
                    p = Frase.length()-1;

                if ((ehConsoante(Frase.charAt(p))  && (Frase.charAt(pp) == ' ')) )
                {

                }
                else if ( ( (Frase.charAt(p) == ' '  &&  ehConsoante(Frase.charAt(pp)))) )
                {
                }
                else if ( ( (Frase.charAt(i) == 'u'  &&  Frase.charAt(p) == 'e')) )
                {
                    //para solucionar palavras como `querer` nai separar u do e
                }
                else if (((ehConsoante(Frase.charAt(p))  && ehConsoante(Frase.charAt(pp)) )  && (Frase.charAt(pp) != 'H') && (Frase.charAt(pp) != 'h') &&
                        (Frase.charAt(pp) != 'l') && (Frase.charAt(pp) != 'r')) || ( (ehConsoante(Frase.charAt(p))  && ehConsoante(Frase.charAt(pp)) ) && Frase.charAt(pp) == 'r' && (Frase.charAt(p) == Frase.charAt(pp)) ) ) /*&&
                        (((Frase.charAt(p) != 'r') && (Frase.charAt(pp) != 'r'))  ||
                        ((Frase.charAt(p) != 's') && (Frase.charAt(pp) != 's')) ||
                        ((Frase.charAt(p) != 'R') && (Frase.charAt(pp) != 'R')) ||
                        ((Frase.charAt(p) != 'S') && (Frase.charAt(pp) != 'S')))
                        ) ||
                          ((Frase.charAt(pp) == 'r')  && (Frase.charAt(pp) == 'r') )||
                                  ((Frase.charAt(pp) == 'R')  && (Frase.charAt(pp) == 'R') )||
                                  ((Frase.charAt(pp) == 's')  && (Frase.charAt(pp) == 's') )||
                                  ((Frase.charAt(pp) == 'S')  && (Frase.charAt(pp) == 'S') ))*/
                {
                    duasConsoantes = true;
                    nextLetra = Frase.charAt(i+1) + "";
                }
                else if (((ehVogal(Frase.charAt(p)) && (Frase.charAt(i) != Frase.charAt(p) )  && !(ehvogalAcentuada(Frase.charAt(p))) && !ehConsoante(Frase.charAt(p)) )
                        && (ehVogal(Frase.charAt(p)) && (Frase.charAt(i) != 'i' && Frase.charAt(p) != 'e') )
                ))  //proximo valor Frase.charAt(p)
                {
  
                }
                else if (Frase.charAt(p) == ' ')
                {

                }
                else if (
                        ((ehEspecial(Frase.charAt(i)) && ehVogal(Frase.charAt(p)) )) ) //proximo valor Frase.charAt(p)
                {


                }
                else if (!(ehPontuacao(Frase.charAt(i+1))) && !(ehPontuacao(Frase.charAt(i+2)))){
                    Result += Frase.charAt(i) + Esp;
                    encontrouVogal = true;
                }
            }
            if (duasConsoantes == true)
            {
                Result += (Frase.charAt(i)) + nextLetra + Esp;
                i++;
                duasConsoantes = false;
            }
            else if (encontrouVogal != true)
            {
                Result += Frase.charAt(i);
                if (temEspaco == true)
                {
                    Result += "-";
                    temEspaco = false;
                }
            }
            encontrouVogal = false;
        }

       /*
        for (i=0; i< Frase.length(); i++)
        {
            if (Frase.charAt(i) == 'a' || Frase.charAt(i) == 'b' || Frase.charAt(i) == 'c' ||
                    Frase.charAt(i) == 'd' ||Frase.charAt(i) == 'e') {
                Result += Frase.charAt(i)+Esp;
            }else
                Result += Frase.charAt(i);
        }*/
        Result = Result.replace("-","- |");

        return Result;

    }
    
    public String tiraCaracterEspecial(String seq){
        seq = seq.replace(".","");
        seq = seq.replace("?","");
        seq = seq.replace("!","");
        seq = seq.replace(",","");
        seq = seq.replace(";","");
        seq = seq.replace("~","");
        seq = seq.replace("´","");
        seq = seq.replace("`","");
        seq = seq.replace("'","");
        seq = seq.replace("1","");
        seq = seq.replace("2","");
        seq = seq.replace("3","");
        seq = seq.replace("4","");
        seq = seq.replace("5","");
        seq = seq.replace("6","");
        seq = seq.replace("7","");
        seq = seq.replace("8","");
        seq = seq.replace("9","");
        seq = seq.replace("0","");
        return seq;
    }    
    
    public int[] metricaEscolhida (int opcao) {
    	int[] metricaEscolhida = new int[3];
    	if (opcao == 1) {
    		metricaEscolhida =  new int[] {3, 6, 10}; //Martelo
    	} else if (opcao == 2){
    		metricaEscolhida = new int[]{4, 8, 10}; //Sáfico
    	} else if (opcao == 3){
    		metricaEscolhida = new int[]{4, 7, 10}; //Gaita Galega
    	} else if (opcao == 4){
    		metricaEscolhida = new int[]{0, 6, 10}; //Heroico
    	}
    	return metricaEscolhida;
    }
    
    public String verificar(String Frase, int[] metricaEscolhida) {

        String array[];
        String msg = "";
        array = Frase.split("/");
        boolean tonica = false;
        int contadormaisum = 0;
        boolean ehsilabaTonica = false;
        String tipo = "";
        String palavraFinal="";
        ArrayList<Metrica> myMetrica = new ArrayList();
        

        Metrica objMetrica = new Metrica();

        for (int i=0; i< array.length; i++)
        {

            contadormaisum = i+1;
            //array[i] = array[i].trim();
            String teste= "";
            for (int i2 = 0; i2 < metricaEscolhida.length; i2++)
            {
                palavraFinal = "";
                teste = "";
                Boolean temEspaco = false;
                if (metricaEscolhida[i2] == contadormaisum){
                    ehsilabaTonica = testaAcentuadaeEspecial(array[i]);
                    for (int auxDecrescente = i;auxDecrescente >= 0; auxDecrescente-- )
                    {
                        String trechoTrim = array[auxDecrescente].trim();
                        trechoTrim = tiraCaracterEspecial(trechoTrim);
                        String Str = "";

                        int idx = trechoTrim.indexOf(" ");
                        if (idx > 0){
                            String dividido[];
                            dividido = trechoTrim.split(" ");
                            if (dividido.length > 0) {
                                teste = dividido[1]+teste  ;
                                break;
                            }
                        }

                        teste = array[auxDecrescente]+teste;

                        if (array[auxDecrescente].charAt(0) == ' ')
                            break;


                    }

                    if (!temEspaco) {
                        for (int auxCrescente = i + 1; auxCrescente < array.length; auxCrescente++) {
                            if (array[auxCrescente].charAt(0) == ' ')
                                break;

                            String trechoTrim = array[auxCrescente].trim();
                            trechoTrim = tiraCaracterEspecial(trechoTrim);
                            int idx = trechoTrim.indexOf(" ");
                            if (idx > 0){
                                String dividido[];
                                dividido = trechoTrim.split(" ");
                                if (dividido.length > 0) {
                                    teste = teste + dividido[0];
                                    break;
                                }
                            }


                            teste = teste + array[auxCrescente];
                        }
                    }
                    teste = teste.replace(" ","");
                    palavraFinal = tiraCaracterEspecial(teste);
                    String teste2 = separadorSilabas(teste);
                    String recebePalavra[] = separadorSilabas(teste).replace('|',';').split(";");
                    boolean ehOxitona = false;
                    if(!ehsilabaTonica)
                        ehOxitona = testaOxitona(teste);

                    for (int teste3 = 0 ; teste3 < recebePalavra.length; teste3++){
                    }


                    String ultimaSilaba = recebePalavra[recebePalavra.length-1]; // -2 pq o -1 que [e a ultima possicao sempre tera o caracter |
                    if (array[i].contains(ultimaSilaba) == true && ehOxitona == true){
                        ehsilabaTonica = true;
                    }

                    if(!ehsilabaTonica && recebePalavra.length >= 2 && ehOxitona == false) {
                        String penultimaSilaba = recebePalavra[recebePalavra.length - 2];
                        if (array[i].contains(penultimaSilaba) == true) {
                            ehsilabaTonica = true;
                        }
                    }

                    if (ehOxitona == true){
                        tipo = "Oxítona";
                    }
                    else if (recebePalavra.length >= 3 && testaAcentuadaeEspecial(recebePalavra[recebePalavra.length-3]) == true ){
                        tipo = "Proparoxítona";
                    }
                    else {
                        tipo = "Paroxítona";
                    }

                    tonica = true;
                    break;
                }


            }
            myMetrica.add(new Metrica(contadormaisum, array[i], palavraFinal, tipo,  tonica, ehsilabaTonica));

            tonica = false;
            ehsilabaTonica = false;

        }

        for (int u =0; u<myMetrica.size();u++ )
        {
            if (myMetrica.get(u).isTonica() == true) {
                if (myMetrica.get(u).isEhsilabaTonica() == false) {
                    msg += " Posição: "+ String.valueOf(myMetrica.get(u).getId()) + "\n Silaba: "+myMetrica.get(u).getSilaba() +"\n"
                            +" Palavra: "+myMetrica.get(u).getPalavra().toString()+ "\n Regra: " +myMetrica.get(u).getTipo()
                            +"\n Errado, não é a sílaba tônica da palavra \n";
                    msg +="\n";

                }
            }
            if (myMetrica.get(u).isTonica() == true) {
                if (myMetrica.get(u).isEhsilabaTonica() == true) {
                    msg += " Posição: "+ String.valueOf(myMetrica.get(u).getId()) + "\n Silaba: "+myMetrica.get(u).getSilaba() +"\n"
                            +" Palavra: "+myMetrica.get(u).getPalavra().toString() + "\n Regra: " +myMetrica.get(u).getTipo()
                                    +"\n Correto, é a sílaba tônica da palavra \n";
                    msg +="\n";

                }
            }

        }

        return msg;
    }
}
