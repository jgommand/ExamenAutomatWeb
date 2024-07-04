package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.time.Duration;

public class MyStorePage {
    private By botonIniciarSesion = By.xpath("//div[@id='_desktop_user_info']");
    private By botonBuscarCategoria = By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]");
    private By botonEntrarGenero = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[2]/section[1]/div[2]/ul[1]/li[1]/div[1]/a[1]/picture[1]/img[1]");
    private By botonSeleccionPrenda = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[2]/section[1]/section[1]/div[3]/div[1]/div[1]/article[1]/div[1]/div[1]/a[1]/picture[1]/img[1]");
    private By botonNumeroPrendas = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/span[3]/button[1]/i[1]");
    private By botonDelCarrito = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/button[1]");
    private By botonDeVerificacionPopup = By.xpath("//a[contains(@class, 'btn-primary') and contains(text(), 'Finalizar compra')]");
    private By validarPrendaAgregada = By.xpath("//h6[contains(text(),'Hummingbird printed t-shirt')]");
    private By precioPrenda = By.xpath("//span[contains(text(),'19,12 PEN')]");
    private By cantidadPrenda = By.xpath("//span[contains(text(),'2 artículos')]");
    private By tituloCarrito = By.xpath("//h1[contains(text(),'Carrito')]");
    private By precioFinalPopUp = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    private By precioFinal = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong");



    private final WebDriverWait wait;
    WebDriver driver;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickEnIniciarSesion() {
        wait.until(ExpectedConditions.elementToBeClickable(botonIniciarSesion));
        WebElement botonBusqueda = driver.findElement(botonIniciarSesion);
        botonBusqueda.click();
    }

    public void clickEnCategoria() {
        wait.until(ExpectedConditions.elementToBeClickable(botonBuscarCategoria));
        WebElement botonCategoria = driver.findElement(botonBuscarCategoria);
        botonCategoria.click();
    }

    public void clickEnGenero() {
        wait.until(ExpectedConditions.elementToBeClickable(botonEntrarGenero));
        WebElement botonGenero = driver.findElement(botonEntrarGenero);
        botonGenero.click();
    }

    public void clickEnPrenda() {
        wait.until(ExpectedConditions.elementToBeClickable(botonSeleccionPrenda));
        WebElement botonGenero = driver.findElement(botonSeleccionPrenda);
        botonGenero.click();
    }

    public void clickEnCantidadPrenda() {
        wait.until(ExpectedConditions.elementToBeClickable(botonNumeroPrendas));
        WebElement botonNumPrendas = driver.findElement(botonNumeroPrendas);
        botonNumPrendas.click();
    }

    public void clickEnCarrito() {
        wait.until(ExpectedConditions.elementToBeClickable(botonDelCarrito));
        WebElement botonCarrito = driver.findElement(botonDelCarrito);
        botonCarrito.click();
    }

    public void clickFinalizarCompra() {
        wait.until(ExpectedConditions.elementToBeClickable(botonDeVerificacionPopup));
        WebElement botonFinalizarCompraPopup = driver.findElement(botonDeVerificacionPopup);
        botonFinalizarCompraPopup.click();

    }

    public void validadProductoAgregado() {
        driver.findElement(validarPrendaAgregada);
    }

    public void validarPrecioFinal() {
        driver.findElement(precioFinal);
    }

    private double extraerValor(WebElement element) {
        String text = element.getText().replace("PEN", "")
                .trim().replace(',', '.');
        return Double.parseDouble(text);
    }


    public void validarTituloCarrito() {
        driver.findElement(tituloCarrito);

    }

    public void validarPrecioPopUp() {
        driver.findElement(precioFinalPopUp);
    }
}
