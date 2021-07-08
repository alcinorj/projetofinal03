package projetofinal03;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastroFuncionarioTest {
	
	//atributo
			WebDriver driver;

	@Dado("^Acessar a página de cadastro$")
	public void acessar_a_página_de_cadastro() {
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();			
		driver.manage().window().maximize();
		driver.get("http://prjfinalteste-001-site1.ctempurl.com/Home/Exercicio03");   
	}

	@Dado("^Informar o nome do funcionario \"([^\"]*)\"$")
	public void informar_o_nome_do_funcionario(String nome) {
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys(nome); 
	}

	@Dado("^Informar a data de nascimento do funcionario \"([^\"]*)\"$")
	public void informar_a_data_de_nascimento_do_funcionario(String nascimento) {
		driver.findElement(By.xpath("//*[@id=\"DataNascimento\"]")).sendKeys(nascimento);  
	}

	@Dado("^Informar o rg do funcionario \"([^\"]*)\"$")
	public void informar_o_rg_do_funcionario(String rg) {
		driver.findElement(By.xpath("//*[@id=\"RG\"]")).sendKeys(rg);  
	}

	@Dado("^Informar o cpf do funcionario \"([^\"]*)\"$")
	public void informar_o_cpf_do_funcionario(String cpf) {
		driver.findElement(By.xpath("//*[@id=\"Cpf\"]")).sendKeys(cpf); 
	}

	@Dado("^Selecionar o tipo de processo seletivo \"([^\"]*)\"$")
	public void selecionar_o_tipo_de_processo_seletivo(String tiposeletivo) {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"ProcessoInscricao\"]"));
		   Select select = new Select(element);
		   select.selectByVisibleText(tiposeletivo);
	}

	@Quando("^Solicitar o cadastramento do funcionario$")
	public void solicitar_o_cadastramento_do_funcionario() {
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}

	@Então("^Sistema informa cadsatro realizado com sucesso$")
	public void sistema_informa_cadsatro_realizado_com_sucesso() {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		assertEquals(mensagem, "Processo realizado com sucesso");	      
	}

	@Então("^Sistema informa que os campos são obrigatórios$")
	public void sistema_informa_que_os_campos_são_obrigatórios() {
		String erroNome = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div/span")).getText();
		String erroNascimento = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[4]/div/span")).getText();
		String erroRg = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div/span")).getText();
		String erroCpf = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[3]/div/span")).getText();
		String erroTiposeletivo = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[5]/div/span")).getText();
		assertEquals(erroNome, "Campo obrigatório");
		assertEquals(erroNascimento, "Campo obrigatório");  
		assertEquals(erroRg, "Campo obrigatório");
		assertEquals(erroCpf, "Campo obrigatório"); 
		assertEquals(erroTiposeletivo, "Campo obrigatório"); 
	
	}

}
