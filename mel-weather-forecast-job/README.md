# mel-weather-forecast-job (Java)

 Se creo esta Lambda function para implementar toda la logica relacionada con la predicción de los climas por día. Además, se guarda cada una
 de los resultados en DynamoDB para su consulta. Actualmente se genero la data para 10 Años.
 

![Architecture](/mel-weather-forecast-job/images/weather-prediction-mel.PNG)

La fuente del proyecto incluye código de función y recursos de apoyo
- `src/main` - Una Java function.
- `src/test` - Una prueba unitaria y una clase de ayuda.
- `template.yml` - Una plantilla de AWS CloudFormation para desplegar la aplicación.
- `pom.xml` - un archivo de dependencias Maven .
- `1-create-bucket.sh`, `2-deploy.sh`, etc. - -unos Shell scripts para configurar y/o desplegar la aplicación.

Utilice las siguientes instrucciones para implementar la aplicación.

# Requisitos
- [Java 8 runtime environment (SE JRE)](https://www.oracle.com/java/technologies/javase-downloads.html)
- Consola o terminal Bash. Para Linux y macOS, esto se incluye de forma predeterminada. En Windows 10, puede instalar el [Windows Subsystem for Linux](https://docs.microsoft.com/en-us/windows/wsl/install-win10) para obtener una versión de Ubuntu y Bash integrada en Windows.
- [The AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html) v1.17 o posterior.
- [Maven](https://maven.apache.org/) - Manejador de dependencias

 Si usa AWS CLI v2, agregue lo siguiente a su [configuration file](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-files.html) (`~/.aws/config`):

```
cli_binary_format=raw-in-base64-out
```

Esta configuración permite que AWS CLI v2 cargue eventos JSON desde un archivo, que coincida con el comportamiento de v1.

# Configuración
Descargue o clone el repositorio.

    $ git clone https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-weather-forecast-job
    $ cd GalaxyFarAwait/mel-weather-forecast-job

Para crear un nuevo depósito para artefactos de implementación, ejecute `1-create-bucket.sh`.

    mel-weather-forecast-job$ ./1-create-bucket.sh
    make_bucket: lambda-artifacts-a5e4xmplb5b22e0d

# Despliegue
Para implementar la aplicación, ejecutar `2-deploy.sh`.

    mel-weather-forecast-job$ ./2-deploy.sh
    BUILD SUCCESSFUL in 1s
    Successfully packaged artifacts and wrote output template to file out.yml.
    Waiting for changeset to be created..
    Successfully created/updated stack - mel-weather-forecast-job

Este script utiliza AWS CloudFormation para implementar las funciones de Lambda y un rol de IAM. Si la pila de AWS CloudFormation que contiene los recursos ya existe, el script la actualiza con cualquier cambio en la plantilla o el código de función.

También puede crear la aplicación con Maven. Para usar maven, agregue `mvn` al comando.

    mel-weather-forecast-job$ ./2-deploy.sh mvn
    [INFO] Scanning for projects...
    [INFO] -----------------------< com.example:mel-weather-forecast-job >-----------------------
    [INFO] Building mel-weather-forecast-job-function 1.0-SNAPSHOT
    [INFO] --------------------------------[ jar ]---------------------------------
    ...

# Pruebas 

* Ejecutar los siguientes comandos,

    maven test

* Tambien se puede ejecutar usando el script `3-invoke.sh`.

    mel-weather-forecast-job$ ./3-invoke.sh
    
    `{
    "Tiempo de Sequía":20,
    "Presión y temperatura óptimas":80,
    "Día más LLuvioso":72,
    "Desconocido":2362,
    "Tiempo LLuvioso":1188
    }`


Deje que el script invoque la función varias veces y luego presione `CRTL+C` para salir.

# Limpiar

Para eliminar la aplicación, ejecute `4-cleanup.sh`.

    mel-weather-forecast-job$ ./4-cleanup.sh
