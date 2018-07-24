package criaPDF;
// GUANABARA É O REI 

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.PrimeFaces;

@ManagedBean
public class PDF {

    private String nome;
    private String conteudo;

    public void convertePdf() {

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Projetos\\NOVO\\criaPDF\\PDF\\" + nome + ".pdf"));
            document.open();
            //Paragraph texto = new Paragraph("                                                                      " + nome + "\n\n\n " + conteudo);  Pura gambiarra hueheheheheheueheuh
            Paragraph texto = new Paragraph(conteudo);
            document.add(texto);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Arquivo " + getNome(), "Convertido com Sucesso.");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Algo deu errado, tente novamente. ", "" + e);
            PrimeFaces.current().dialog().showMessageDynamic(message);
            System.out.println(e);
        }
        document.close();
    }

    public void limpar() {
        setNome("");
        setConteudo("");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
