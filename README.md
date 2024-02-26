# Consultorio Medico (EDA)

Programa de un Consultorio Medico usando Estructuras de Datos y Algoritmos

### [Como instalar JavaFX21](https://openjfx.io/openjfx-docs/)

## Configuracion de la VM
### Linux/Mac

--module-path lib/JavaFX21 --add-modules javafx.controls,javafx.fxml

### Windows

--module-path "lib\JavaFX21" --add-modules javafx.controls,javafx.fxml

### Error

Si contiene este error:
```
OpenJDK 64-Bit Server VM warning: You have loaded library /home/kalpataru/Projects/consultorio Medico/lib/JavaFX 21/libprism_es2.so which might have disabled stack guard. The VM will try to fix the stack guard now. It's highly recommended that you fix the library with 'execstack -c <lib file>', or link it with '-z noexecstack'. Graphics Device initialization failed for : es2, sw Error initializing QuantumRenderer: no suitable pipeline found
```
[Reinstalar JavaFX](https://gluonhq.com/products/javafx/) en la carpeta "/lib/JavaFX21"

### Scene Builder
Usar [Scene Builder](https://gluonhq.com/products/scene-builder/#download) para la construccion de la interfaz grafica del programa
