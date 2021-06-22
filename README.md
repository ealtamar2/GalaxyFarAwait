# Meli Challenge - Galaxy far away!

Para la implementación del proyecto se crearon dos componentes.

* Se creo una lambda function en Java 8 llamamda [mel-weather-forecast-job](https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-weather-forecast-job).
  * [Ver Documentación](https://github.com/ealtamar2/GalaxyFarAwait/blob/main/mel-weather-forecast-job/README.md) 
    
* Se creo una lamdba function en NodeJS  [mel-get-weather](https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-get-weather).
  * [Ver Documentación](https://github.com/ealtamar2/GalaxyFarAwait/blob/main/mel-get-weather/README.md)    

Donde, la primera funcion se encarga de simular calculando matemáticamente la rotacion de los planetas

![Gráfica](https://github.com/ealtamar2/GalaxyFarAwait/blob/main/mel-weather-forecast-job/images/Graphic.PNG)

Además, se hicieron uso de las servicios de Amazon AWS:

* Se creo una tabla de DynamoDB para almacenar los datos:
  ![Dynamo](https://github.com/ealtamar2/GalaxyFarAway/blob/main/mel-weather-forecast-job/images/Dynamo.PNG)
  
* Se implementaron Lambdas:
  ![Lambdas](https://github.com/ealtamar2/GalaxyFarAway/blob/main/mel-weather-forecast-job/images/CloudWatch.PNG)
  
* Se uso CloudWatch para generar el job:
  ![Lambdas](https://github.com/ealtamar2/GalaxyFarAway/blob/main/mel-weather-forecast-job/images/Rules.PNG)


Bonus:
  1. Para el job, se creo una regla de CloudWatch donde se invoca cada X tiempo la función [mel-weather-forecast-job](https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-weather-forecast-job).
  2. Se uso expuso un método GET por medio de APIGateway de AWS (Se comparte el link mediante email)
  3. Se almacenó el pronostico de 10 años en una tabla de DynamoDB

## Autores ✒️

* **Eduardo Altamar** - *Desarrollo y Documentación* - [ealtamar](https://github.com/ealtamar2)


