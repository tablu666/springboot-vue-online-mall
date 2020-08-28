module.exports = {
  devServer:{
    host:'localhost',
    port:8080,
    proxy:{
      '/api':{
        target:'http://mall-tablu.com/api',
        changeOrigin:true,
        pathRewrite:{
          '/api':''
        }
      }
    }
  },
};