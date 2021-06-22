# mel-get-weather function (Node.js)

 Se creo esta Lambda function para consultar el pronostico del clima por día, esta funcion es implementada o expuesta por un servicio REST
 por medio de APIGateway de Amazon

![Architecture](/mel-get-weather/images/mel-get-weather.PNG)

The project source includes function code and supporting resources:

- `function` - una Node.js function.
- `template.yml` - una plantilla de AWS CloudFormation para desplegar la aplicación.
- `1-create-bucket.sh`, `2-deploy.sh`, etc. -unos Shell scripts para configurar y/o desplegar la aplicación .

Utilice las siguientes instrucciones para implementar la aplicación de muestra. Para ver en profundidad su arquitectura y características, consulte [Blank Function Sample Application for AWS Lambda](https://docs.aws.amazon.com/lambda/latest/dg/samples-mel-get-weather.html) in the developer guide.

# Requisitos
- [Node.js 10 with npm](https://nodejs.org/en/download/releases/)
- Consola o terminal Bash. Para Linux y macOS, esto se incluye de forma predeterminada. En Windows 10, puede instalar el [Windows Subsystem for Linux](https://docs.microsoft.com/en-us/windows/wsl/install-win10) para obtener una versión de Ubuntu y Bash integrada en Windows.
- [The AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html) v1.17 o posterior.

 Si usa AWS CLI v2, agregue lo siguiente a su [configuration file](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-files.html) (`~/.aws/config`):

```
cli_binary_format=raw-in-base64-out
```

# Configuración
Descargue o clone el repositorio 

    $ git clone https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-get-weather
    $ cd GalaxyFarAwait/tree/main/mel-get-weather

 Crear un bucket, ejecutar `scripts/1-create-bucket.sh`.

    mel-get-weather$ ./scripts/1-create-bucket.sh
    make_bucket: lambda-artifacts-a5e491dbb5b22e0d

Para crear una capa Lambda que contenga las dependencias en tiempo de ejecución de la función, ejecute `2-build-layer.sh`. El empaquetado de dependencias en una capa reduce el tamaño del paquete de implementación que carga cuando modifica su código.

    mel-get-weather$ ./scripts/2-build-layer.sh

# Despliegue
To deploy the application, run `3-deploy.sh`.

    mel-get-weather$ ./3-deploy.sh
    added 16 packages from 18 contributors and audited 18 packages in 0.926s
    added 17 packages from 19 contributors and audited 19 packages in 0.916s
    Uploading to e678bc216e6a0d510d661ca9ae2fd941  2737254 / 2737254.0  (100.00%)
    Successfully packaged artifacts and wrote output template to file out.yml.
    Waiting for changeset to be created..
    Waiting for stack create/update to complete
    Successfully created/updated stack - mel-get-weather

This script uses AWS CloudFormation to deploy the Lambda functions and an IAM role. If the AWS CloudFormation stack that contains the resources already exists, the script updates it with any changes to the template or function code.

# Pruebas

Ejecutar los siguientes comandos,

* npm install
* npm test

Tambien se puede hacer uso de el script, Ejecutar `scripts/4-invoke.sh`.

    mel-get-weather$ ./4-invoke.sh
    {
    "statusCode": "0",
    "statusDesc": "SUCCESS",
    "body": {
        "weather": "Tiempo de Sequía",
        "day": "360"
    }}

Deje que el script invoque la función varias veces y luego presione `CRTL+C` para salir.


Finalmente, vea la aplicación en la consola de Lambda

*To view the application*
1. Abrir [applications page](https://console.aws.amazon.com/lambda/home#/applications) en la consola de Lambda .
2. Escoger **mel-get-weather**.


