package hackaton;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;

public class Hackaton {
	
   public static ArrayList<String> linksDasVagas(String url) {
		
		ArrayList<String> list = new ArrayList<String>();
    	
		try {
	    	Document doc = Jsoup.connect(url).get();        
	        Elements elements = doc.getElementsByClass("py-16 pl-24 pr-16 cursor-pointer js_vacancyLoad js_cardLink");
	        
	        for(Element e : elements) {
	            	
	        	String link = e.getElementsByClass("mr-8").toString();
	            	
	            link = link.split(" ")[3];
	            link = link.replace("href=", "");
	            link = link.replace("\">", " ");
	            link = link.replace("\"", "");
	            link = "https://www.infojobs.com.br" + link;
	            
	            list.add(link);
	        }
    	} catch(IOException e) {
    		System.out.println(e.toString());
    	}
    	
		return list;
	}
	
	public static void imprimirDadosDaVaga(String url) {
		
		try {
	    	Document doc = Jsoup.connect(url).get();        
	        
	    	Element tituloDaVaga = doc.getElementsByClass("font-weight-bolder mb-4").get(0);
	    	Element nomeDaEmpresa = doc.getElementsByClass("h4").get(0);
	    	Element local = doc.getElementsByClass("text-medium mb-4").get(0);
	    	Element salario =  doc.getElementsByClass("text-medium mb-4").get(1);
	    	Element tipo = doc.getElementsByClass("text-medium small font-weight-bold mb-4").get(0);
	    	
	    	System.out.println("\n\n\n--- VAGAS ---");
	        System.out.println(tituloDaVaga.text());
	        System.out.println(nomeDaEmpresa.text());
	        System.out.println(local.text());
	        System.out.println(salario.text());
	        System.out.println(tipo.text());
	        
    	} catch(IOException e) {
    		System.out.println(e.toString());
    	}
	}
	
    public static void main(String[] args) {
    	
    	ArrayList<String> links = new ArrayList<String>();
    		
    	for(int i = 1; i <= 20; i++)
    		links.addAll(linksDasVagas("https://www.infojobs.com.br/vagas-de-emprego-estagio+ti.aspx?page=%d".formatted(i)));
    	
    	int contador = 1;
    	for(String link : links) {
    		System.out.printf("\n\n%d°", contador);
    		imprimirDadosDaVaga(link);
    		contador++;
    	}
    	
    	System.out.printf("\n\nQuantidade Total de Vagas: %d\n", links.size());
    	    
    }
}

