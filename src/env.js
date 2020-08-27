let baseURL;
switch (process.env.NODE_ENV) {
    case 'development':
        baseURL = 'http://dev-mall-tablu.com/api';
        break;
    case 'test':
        baseURL = 'http://test-mall-tablu.com/api';
        break;
    case 'production':
        baseURL = 'http://mall-tablu.com/api';
        break;
    default:
        baseURL = 'http://mall-tablu.com/api';
        break;
}

export default {
    baseURL
}