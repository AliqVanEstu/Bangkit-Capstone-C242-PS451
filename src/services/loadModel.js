const tf = require('@tensorflow/tfjs-node');
async function loadModel() {
    const modelPath = process.env.MODEL_URL;
    console.log("Model path:", modelPath);
    try {
        console.log("Memuat model...");
        const model = await tf.loadLayersModel(modelPath);
        console.log("Model berhasil dimuat");
        return model;
    } catch (error) {
        console.error("Error saat memuat model:", error);
    }
}
module.exports = loadModel;