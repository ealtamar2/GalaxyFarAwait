# Mel Challenge - Galaxy far await!

Para la implementación del proyecto se crearon dos componentes.

* Se creo una lambda function en Java 8 llamamda [mel-weather-forecast-job](https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-weather-forecast-job).
  * [Ver Documentación](https://github.com/ealtamar2/GalaxyFarAwait/blob/main/mel-weather-forecast-job/README.md) 
    
* Se creo una lamdba function en NodeJS  [mel-get-weather](https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-get-weather).
  * [Ver Documentación](https://github.com/ealtamar2/GalaxyFarAwait/blob/main/mel-get-weather/README.md)    

Bonus:
  1. Para el job, se creo una regla de CloudWatch donde se invoca cada X tiempo la función [mel-weather-forecast-job](https://github.com/ealtamar2/GalaxyFarAwait/tree/main/mel-weather-forecast-job).
  2. Se uso expuso un método GET por medio de APIGateway de AWS (Se comparte el link mediante email)
  3. Se almacenó el pronostico de 10 años en una tabla de DynamoDB

## Autores ✒️

* **Eduardo Altamar** - *Desarrollo y Documentación* - [ealtamar](https://github.com/ealtamar2)


