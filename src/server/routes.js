const handler = require('./handler');

const routes = [
    {
        method: 'GET',
        path: '/dashboard/articles',
        handler: handler.getDashboardArticles
    },
    {
        method: 'GET',
        path: '/article/{id}',
        handler: handler.getArticle
    },
];

module.exports = routes;