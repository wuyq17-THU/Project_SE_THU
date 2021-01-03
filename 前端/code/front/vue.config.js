module.exports = {
    devServer:{
        proxy:{
            '/api':{
                target: 'http://localhost:8129',
                ws: true,
                changeOrigin: true,                
            }
        }
    }
}