package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.MyStoreStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreStepsDef {

    private MyStoreStep myStore;
    private Scenario scenario;
    private WebDriver driver;

    @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }



    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        myStore = new MyStoreStep(driver);
        myStore.navegarA("https://qalab.bensg.com/store");
        screenShot();

    }

    private  void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }





    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String contrasena) {

        myStore.IniciarSesion(usuario,contrasena);

        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String sexo) {
        myStore.BuscarCategoria(categoria,sexo);
        myStore.BuscarGenero(categoria,sexo);
        screenShot();
    }


    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        myStore.SeleccionarPrenda(unidades);
        myStore.AgregarPrendas(unidades);
        screenShot();

    }

    @And("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        myStore.VerficacionCarrito();
        screenShot();

    }
    @And("Cuando finalizo la compra en el popup")
    public void cuandoFinalizoLaCompraEnElPopup() {
        myStore.VerficacionPopup();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        myStore.ValidacionPrecioPopUp();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        myStore.VerficacionTituloCarrito();
        screenShot();


    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        myStore.ValidacionPrecio();
        screenShot();

    }





    }

