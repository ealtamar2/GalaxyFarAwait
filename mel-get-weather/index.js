'use strict';
// Loads in the AWS SDK
var AWS = require('aws-sdk');
var dynamodb = new AWS.DynamoDB.DocumentClient();


exports.handler = async (event, context) => {
  // Handle promise fulfilled/rejected states
  console.log("event:", event);

  try {

    let tableName = 'weather-prediction-mel';
    let data = await getItem(tableName, { day: event.day.toString() });
   
    if (!!!!data && !!data.Item) {
      succeed(context, buildOutput('0', 'SUCCESS', data.Item))
    }

    succeed(context, buildOutput('204', 'No se encontraron registros con el día suministrado', data.Item))

  } catch (error) {
    fail(context, buildOutput('500', 'Error al Consultar datos', {}))
  }

};

function buildOutput(code, desc, body) {
  return {
    statusCode: code,
    statusDesc: desc,
    body: body
  }
}


/**
 * @function
 * @description Finaliza con exito la ejecucion de la lambda
 * @param {string|object} output Informacion de salida de la lambda
 * @param {boolean} logging Define si se deja registros en log @default true
 * @return {string|object} Salida de la lambda
 * @example
 * const output = {
 *  code: '0',
 *  description: 'Lambda ejecutada correctamente'
 * };
 * return lambdaUtils.succeed(context, output);
 */
function succeed(context, output) {
  const lambdaOutput = !!output ? output : 'Ejecucion finalizada correctamente';
  console.log('succeed', lambdaOutput);
  context.succeed(lambdaOutput);
}

/**
* @function
* @description Finaliza con fallo la ejecucion de la lambda
* @param {string|object} output Informacion de salida de la lambda
* @throws output
* @example
* const output = {
*  code: '1',
*  description: 'Lambda ejecutada con fallo'
* };
* lambdaUtils.fail(context, output);
*/
function fail(context, output) {
  const lambdaOutput = !!output ? output : 'Ejecucion finalizada con error';
  console.error('fail', lambdaOutput);
  context.fail(lambdaOutput);
}

/**
 * @function
 * 
 * @description Permite obtener un item almacenado en una tabla en DynamoDB
 * 
 * @param {string} tableName Nombre de la tabla de la cual desea consultar el item
 * @param {object} key Clave asociada al item en la tabla de DynamoDB
 * @return {Promise} Promesa del servicio
 * @example
 * var promiseDynamo = getItem('tableTest', {code: '123'});
 * promiseDynamo.then((data)=>{console.log(data)}, (error)=>{console.log(error)});
*/
function getItem(tableName, key) {
  return new Promise((resolve, reject) => {
    let params = { TableName: tableName, Key: key };
    dynamodb.get(params, function (err, data) {
      if (err) {
        reject(err);
      } else {
        resolve(data);
      }
    });
  });
}


