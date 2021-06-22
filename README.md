# Meli Challenge - Galaxy far away!

Para la implementación del proyecto se hicieron uso de las servicios de Amazon AWS, creando los siguientes componentes:

* Se implementarón dos Lambdas:
  * Se creo una función con Java 8 para calcular y generar los pronósticos del clima, [mel-weather-forecast-job](https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-weather-forecast-job).
    * [Ver README](https://github.com/ealtamar2/GalaxyFarAwait/blob/main/mel-weather-forecast-job/README.md) 

  * Se creo función en NodeJS para exponer la consulta por día, [mel-get-weather](https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-get-weather).
    * [Ver README](https://github.com/ealtamar2/GalaxyFarAwait/blob/main/mel-get-weather/README.md)    

  ![Lambdas](https://github.com/ealtamar2/GalaxyFarAway/blob/main/mel-weather-forecast-job/images/CloudWatch.PNG)
  

# Bonus:
 ##   1. Para el job, se creo una regla de CloudWatch donde se invoca cada X tiempo la función [mel-weather-forecast-job](https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-weather-forecast-job). Recibe por medio de un JSON los parámetros necesarios, cómo la cantidad de años y el listado de los planetas.
 
  ![Lambdas](https://github.com/ealtamar2/GalaxyFarAway/blob/main/mel-weather-forecast-job/images/Rules.PNG)
  
 ## 3. Se uso expuso un método GET por medio de APIGateway de AWS (Se comparte colección de Postman por email)
 
    https://{{aws_host}}/dev/get-weather-per-day?day=360
    
 ## 4. Se almacenó el pronóstico de 10 años en una tabla de DynamoDB.

  ![Dynamo](https://github.com/ealtamar2/GalaxyFarAway/blob/main/mel-weather-forecast-job/images/Dynamo.PNG)
  
 # Anexos:
 Se grafican a modo de prueba las coordenadas que genera la primera función, calculando matemáticamente la rotacion de los planetas. Se comparte el resultado.

   ![Gráfica](https://github.com/ealtamar2/GalaxyFarAwait/blob/main/mel-weather-forecast-job/images/Graphic.PNG)
   

## Autores ✒️

* **Eduardo Altamar** - *Desarrollo y Documentación* - [ealtamar](https://github.com/ealtamar2)


