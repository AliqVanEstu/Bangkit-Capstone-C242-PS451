const { Firestore } = require('@google-cloud/firestore');

async function getArticles() {
    const db = new Firestore();
    const predictCollection = db.collection('articles');
    
    const filteredData = await predictCollection
        .select('id_article', 'title', 'image', 'updated_at')
        .get();

    return filteredData;
}


async function getDetailArticle() {
    const db = new Firestore();
    const predictCollection = db.collection('articles');
    
    const allData = await predictCollection.get();
    return allData;
}

module.exports = { getArticles, getDetailArticle };