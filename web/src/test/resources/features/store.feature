# new feature
# Tags: optional

Feature: My Store
@storeTest
  Scenario: Validación del Precio de un Producto
    Given estoy en la página de la tienda
      And me logueo con mi usuario "jgomezm1898@gmail.com" y clave "J123456.%%%"
      When navego a la categoria "Clothes" y subcategoria "Men"
      And agrego 2 unidades del primer producto al carrito
      And valido en el popup la confirmación del producto agregado
      And valido en el popup que el monto total sea calculado correctamente
      And Cuando finalizo la compra en el popup
      Then valido el titulo de la pagina del carrito
      And vuelvo a validar el calculo de precios en el carrito
