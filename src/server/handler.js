const { getArticles, getDetailArticle } = require('../services/getArticles');

async function getDashboardArticles(request, h) {
    try {
        const articles = await getArticles();
        return h.response(articles).code(200);
    } catch (error) {
        console.error('Error fetching dashboard articles:', error);
        return h.response({ message: 'Failed to fetch articles' }).code(500);
    }
}

async function getArticle(request, h) {
    const { id } = request.params;
    try {
        const allArticles = await getDetailArticle();
        const article = allArticles.find(doc => doc.id_article === id);

        if (!article) {
            return h.response({ message: 'Article not found' }).code(404);
        }

        return h.response(article).code(200);
    } catch (error) {
        console.error('Error fetching article:', error);
        return h.response({ message: 'Failed to fetch article' }).code(500);
    }
}

module.exports = { getDashboardArticles, getArticle };