package hackaton;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Vaga {
	
	private String tituloDaVaga;
	private String nomeDaEmpresa;
	private String local;
	private String salario;
	private String tipo;
	
	
	public Vaga(String tituloDaVaga, String nomeDaEmpresa, String local, String salario, String tipo) {
		this.tituloDaVaga = tituloDaVaga;
		this.nomeDaEmpresa = nomeDaEmpresa;
		this.local = local;
		this.salario = salario;
		this.tipo = tipo;
	}
	
	
	public Vaga() {
	}


	public static Vaga geraVaga(String url) {

		try {
			Document doc = Jsoup.connect(url).get();
			Element tituloDaVaga = doc.getElementsByClass("font-weight-bolder mb-4").get(0);
			Element nomeDaEmpresa = doc.getElementsByClass("h4").get(0);
			Element local = doc.getElementsByClass("text-medium mb-4").get(0);
			Element salario = doc.getElementsByClass("text-medium mb-4").get(1);
			Element tipo = doc.getElementsByClass("text-medium small font-weight-bold mb-4").get(0);

			
			Vaga vaga = new Vaga();
			vaga.setTituloDaVaga(tituloDaVaga.text());
			vaga.setNomeDaEmpresa(nomeDaEmpresa.text());
			vaga.setLocal(local.text());
			vaga.setSalario(salario.text());
			vaga.setTipo(tipo.text());
			
			return vaga;
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
		return null;
	}
	
	
	public String getTituloDaVaga() {
		return tituloDaVaga;
	}



	public void setTituloDaVaga(String tituloDaVaga) {
		this.tituloDaVaga = tituloDaVaga;
	}



	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}



	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		this.nomeDaEmpresa = nomeDaEmpresa;
	}



	public String getLocal() {
		return local;
	}



	public void setLocal(String local) {
		this.local = local;
	}



	public String getSalario() {
		return salario;
	}



	public void setSalario(String salario) {
		this.salario = salario;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Vaga [tituloDaVaga=" + tituloDaVaga + ", nomeDaEmpresa=" + nomeDaEmpresa + ", local=" + local
				+ ", salario=" + salario + ", tipo=" + tipo + "]";
	}

}
