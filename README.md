# Proyecto de Solución al Problema de la Parada

Este proyecto implementa una solución al problema de la parada utilizando el patrón de diseño Chain of Responsibility. El proyecto está escrito en Java y JavaScript.

## Paquetes

El proyecto se divide en varios paquetes, cada uno con su propia responsabilidad.

### Paquete `ChainOfResponsability`

Este paquete contiene las clases que implementan el patrón de diseño Chain of Responsibility. Cada clase maneja un tipo específico de excepción.

- `ExceptionHandler`: Esta es la clase principal que maneja las excepciones en tu aplicación. Utiliza el patrón de diseño Chain of Responsibility para manejar diferentes tipos de excepciones. La clase tiene un método estático `getInstance()` que devuelve una instancia única de `ExceptionHandler`. Este método configura la cadena de manejo de excepciones y crea la instancia si no existe. La clase también tiene un método `handleException(Exception ex)` que maneja la excepción especificada utilizando la cadena de responsabilidad.

- `CuentaInfinitaProcesoHandler`: Esta clase es un manejador de excepciones específico para el proceso de cuenta infinita. Implementa la interfaz `ExcepcionHandlerInterface` y forma parte de la cadena de responsabilidad en el manejo de excepciones. Si la excepción que se está manejando está relacionada con el proceso de cuenta infinita, esta clase la maneja. Si no, la pasa al siguiente manejador en la cadena.

- `CuentaAtrasProcesoHandler`: Similar a `CuentaInfinitaProcesoHandler`, esta clase es un manejador de excepciones específico para el proceso de cuenta atrás. También implementa la interfaz `ExcepcionHandlerInterface` y forma parte de la cadena de responsabilidad en el manejo de excepciones.

### Paquete `Vista`

Este paquete contiene la interfaz gráfica de usuario (GUI) para la aplicación.

- `Vista`: Esta clase representa la interfaz gráfica de usuario (GUI) de tu aplicación. Contiene un `JFrame` que es la ventana principal de la aplicación, un `JTextArea` que es el área de texto donde se muestran los mensajes, y varios `JButton` que representan las acciones que el usuario puede realizar. La clase tiene métodos para obtener estos componentes de la GUI, mostrar la ventana principal y actualizar el área de texto con un nuevo mensaje.

## Diagrama UML

El diagrama UML del proyecto se puede encontrar en el archivo `DiagramaUML.png` en la raíz del proyecto.

## Directorio de pruebas

El directorio `test` contiene las clases de prueba para el proyecto. Cada clase de prueba verifica la funcionalidad de su clase correspondiente en el código principal.

- `HaltCheckerTest`: Pruebas para la clase `HaltChecker`.
- `ExceptionHandlerTest`: Pruebas para la clase `ExceptionHandler`.

## Información más detallada

Para poder acceder a información mas detallada del proyecto 

link al repositorio -> 
