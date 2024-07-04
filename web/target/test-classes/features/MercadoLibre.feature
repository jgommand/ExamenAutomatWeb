Feature: MercadoLibre
@busquedaProducto
  Scenario: Busqueda de Productos
    Given estoy en la página de MercadoLibre
    When busco un producto "Televisores Led 40 pulgadas"
    Then una lista de resultados
    And valido el primer titulo del resultado sea "Televisor inteligente S5400a LED Fhd Android Preta Tcl 110 V/220 V"
