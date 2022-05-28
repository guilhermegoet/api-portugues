package br.com.goet.apiportugues.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.goet.apiportugues.utils.FuncoesPortugues;

@RestController
public class PortuguesController {
	
    @RequestMapping(value = "/palavra", method = RequestMethod.GET)
    public String Get() {
        return "teste";
    }
    
    @RequestMapping(value = "/consoante/{letra}", method = RequestMethod.GET)
    public boolean ehConsoante(@PathVariable("letra") char letra) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
        return funcoes.ehConsoante(letra);
    }   
   
    @RequestMapping(value = "/vogal/{letra}", method = RequestMethod.GET)
    public boolean ehVogal(@PathVariable("letra") char letra) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
        return funcoes.ehVogal(letra);
    }  
    
    @RequestMapping(value = "/pontuacao/{letra}", method = RequestMethod.GET)
    public boolean ehPontuacao(@PathVariable("letra") char letra) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
        return funcoes.ehPontuacao(letra);
    }  
    
    @RequestMapping(value = "/acentuacao/{letra}", method = RequestMethod.GET)
    public boolean ehAcentuada(@PathVariable("letra") String letra) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
        return funcoes.testaAcentuadaeEspecial(letra);
    }  
    
    @RequestMapping(value = "/vogalacentuada/{letra}", method = RequestMethod.GET)
    public boolean ehVogalAcentuada(@PathVariable("letra") char letra) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
        return funcoes.ehvogalAcentuada(letra);
    }  
    
    @RequestMapping(value = "/vogaltil/{letra}", method = RequestMethod.GET)
    public boolean ehVogalEspecial(@PathVariable("letra") char letra) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
        return funcoes.ehEspecial(letra);
    }  
    
    @RequestMapping(value = "/oxitona/{palavra}", method = RequestMethod.GET)
    public boolean ehOxitona(@PathVariable("palavra") String palavra) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
        return funcoes.testaOxitona(palavra);
    }  

    @RequestMapping(value = "/metrica/{frase}", method = RequestMethod.GET)
    public String separaMetrica(@PathVariable("frase") String frase) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
        return funcoes.separaMetrica(frase);
    }  

    @RequestMapping(value = "/silaba/{frase}", method = RequestMethod.GET)
    public String separaSilaba(@PathVariable("frase") String frase) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
        return funcoes.separadorSilabas(frase);
    }  
    
    @RequestMapping(value = "/martelo/{frase}", method = RequestMethod.GET)
    public String verificaFraseMartelo(@PathVariable("frase") String frase) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
    	String fraseMetrica = funcoes.separaMetrica(frase);
    	int[] metricaEscolhida = funcoes.metricaEscolhida(1);
        return funcoes.verificar(fraseMetrica, metricaEscolhida);
    }  
    
    @RequestMapping(value = "/safico/{frase}", method = RequestMethod.GET)
    public String verificaFraseSafico(@PathVariable("frase") String frase) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
    	String fraseMetrica = funcoes.separaMetrica(frase);
    	int[] metricaEscolhida = funcoes.metricaEscolhida(2);
        return funcoes.verificar(fraseMetrica, metricaEscolhida);
    }  
    
    @RequestMapping(value = "/gaitagalega/{frase}", method = RequestMethod.GET)
    public String verificaFraseGaitaGalega(@PathVariable("frase") String frase) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
    	String fraseMetrica = funcoes.separaMetrica(frase);
    	int[] metricaEscolhida = funcoes.metricaEscolhida(3);
        return funcoes.verificar(fraseMetrica, metricaEscolhida);
    }  
    
    @RequestMapping(value = "/heroico/{frase}", method = RequestMethod.GET)
    public String verificaFraseHeroico(@PathVariable("frase") String frase) {
    	FuncoesPortugues funcoes = new FuncoesPortugues();
    	String fraseMetrica = funcoes.separaMetrica(frase);
    	int[] metricaEscolhida = funcoes.metricaEscolhida(4);
        return funcoes.verificar(fraseMetrica, metricaEscolhida);
    }      
}
