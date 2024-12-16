const { Firestore } = require('@google-cloud/firestore');

function formatDateWithSuffix(date) {
    const months = [
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    ];

    const day = date.getDate();
    const month = months[date.getMonth()];
    const year = date.getFullYear();
    const hours = date.getHours();
    const minutes = date.getMinutes();

    const suffix = (day) => {
        if (day === 1 || day === 21 || day === 31) return day + 'st';
        if (day === 2 || day === 22) return day + 'nd';
        if (day === 3 || day === 23) return day + 'rd';
        return day + 'th';
    };

    const formattedDay = suffix(day);
    const formattedTime = `${hours < 10 ? '0' + hours : hours}.${minutes < 10 ? '0' + minutes : minutes} WIB`;

    return `${month} ${formattedDay}, ${year} at ${formattedTime}`;
}

async function getArticles() {
    const db = new Firestore();
    const predictCollection = db.collection('articles');
    
    const filteredData = await predictCollection
        .select('id_article', 'title', 'image', 'updated_at')
        .get();

    const articles = filteredData.docs.map(doc => {
        const data = doc.data();
        const formattedUpdatedAt = formatDateWithSuffix(data.updated_at.toDate());

        return {
            id_article: data.id_article,
            title: data.title,
            image: data.image,
            updated_at: `Last Updated on ${formattedUpdatedAt}`
        };
    });

    return articles;
}

async function getDetailArticle() {
    const db = new Firestore();
    const predictCollection = db.collection('articles');
    
    const allData = await predictCollection.get();

    const articles = allData.docs.map(doc => {
        const data = doc.data();
        const formattedCreatedAt = formatDateWithSuffix(data.created_at.toDate());
        const formattedUpdatedAt = formatDateWithSuffix(data.updated_at.toDate());

        return {
            ...data,
            created_at: `Created on ${formattedCreatedAt}`,
            updated_at: `Last Updated on ${formattedUpdatedAt}`
        };
    });

    return articles;
}

module.exports = { getArticles, getDetailArticle };