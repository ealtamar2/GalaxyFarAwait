'use strict';
const rewire = require("rewire");
const index = rewire('../index.js');
const fs = require('fs');

describe('mel-get-weather/index.js', () => {
  var originalTimeout;
  beforeEach(function () {
    originalTimeout = jasmine.getEnv().defaultTimeoutInterval;
    jasmine.getEnv().defaultTimeoutInterval = 50000;
  });
  afterEach(function () {
    jasmine.getEnv().defaultTimeoutInterval = originalTimeout;
  });

  function promisifyHanddler(request) {
    return new Promise((resolve, reject) => {
      let context = {
        succeed: resolve,
        fail: reject
      };
      index.handler(request, context);
    });
  }

  it('index.js: Success test', async (done) => {

    try {
      let event = JSON.parse(fs.readFileSync('./test/event.json', {
        encoding: 'utf8'
      }));

      let response = await promisifyHanddler(event);
      expect(response).toBeDefined();
      expect(response.statusCode).toBeDefined();
      expect(response.statusCode).toBe('0');
      expect(response.body).toBeDefined();
      expect(response.body.weather).toBeDefined();
      expect(response.body.weather).toBe('Presión y temperatura óptimas');

    } catch (error) {
      console.log('ERROR' + JSON.stringify(error));
      expect(error).not.toBeDefined();
    } finally {
      done();
    }
  });

  it('index.js: Not found test', async (done) => {

    try {
      let event = JSON.parse(fs.readFileSync('./test/event.json', {
        encoding: 'utf8'
      }));
      event.day = '-1';

      let response = await promisifyHanddler(event);
      expect(response).toBeDefined();
      expect(response.statusCode).toBeDefined();
      expect(response.statusCode).toBe('204');

    } catch (error) {
      console.log('ERROR' + JSON.stringify(error));
      expect(error).not.toBeDefined();
    } finally {
      done();
    }
  });

  it('index.js: Bad param test', async (done) => {

    try {
      let event = JSON.parse(fs.readFileSync('./test/event.json', {
        encoding: 'utf8'
      }));
      event.day = '';

      await promisifyHanddler(event);
    } catch (error) {
      console.log('ERROR ' + JSON.stringify(error));
      expect(error).toBeDefined();
    } finally {
      done();
    }
  });

});