package com.nttdata.steps;


import com.nttdata.page.MyStorePage;
import com.nttdata.stepsdefinitions.MyStoreStepsDef;
import org.openqa.selenium.WebDriver;
import java.lang.Thread;

public class MyStoreStep {

    WebDriver driver;
    MyStorePage page;


    public MyStoreStep(WebDriver driver) {
        this.driver = driver;
        page = new MyStorePage(driver);
    }

    public void navegarA(String url) {
        driver.get(url);
    }

    public void IniciarSesion(String usuario, String contrasena) {
        LoginSteps loginSteps = new LoginSteps(driver);

        page.clickEnIniciarSesion();
        loginSteps.typeUser(usuario);
        loginSteps.typePassword(contrasena);
        loginSteps.login();

    }

    public void BuscarCategoria(String categoria, String sexo) {
        page.clickEnCategoria();
    }

    public void BuscarGenero(String categoria, String sexo) {
        page.clickEnGenero();
    }

    public void SeleccionarPrenda(int unidades) {
        page.clickEnPrenda();
    }

    public void AgregarPrendas(int unidades) {
        page.clickEnCantidadPrenda();
    }

    public void VerficacionCarrito() {
        page.clickEnCarrito();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.validadProductoAgregado();

    }

    public void VerficacionPopup() {
        page.clickFinalizarCompra();

    }

    public void ValidacionPrecio() {
        page.validarPrecioFinal();
    }


    public void VerficacionTituloCarrito() {
        page.validarTituloCarrito();
    }

    public void ValidacionPrecioPopUp() {
        page.validarPrecioPopUp();
    }
}
