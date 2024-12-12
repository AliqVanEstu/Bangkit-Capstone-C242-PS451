const postPredictHandler = require('../server/handler');
 
const routes = [
  {
    path: '/translate',
    method: 'POST',
    handler: postTranslateHandler,
    options: {
      payload: {
        allow: 'multipart/form-data',
        multipart: true
      }
    }
  },
  {
    path: '/translate/histories',
    method: 'GET',
    handler: getTranslateHistoriesHandler,
  }
]
 
module.exports = routes;