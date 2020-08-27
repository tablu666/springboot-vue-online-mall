/**
 * Storage封装
 */
const STORAGE_KEY = 'mall';
export default {

    getStorage() {
        return JSON.parse(window.sessionStorage.getItem(STORAGE_KEY) || '{}');
    },

    //获取模块属性如user.username
    getProperty(key, module_name) {
        if (module_name) {
            let obj = this.getProperty(module_name);
            if (obj) {
                return obj[key];
            }
        }
        return this.getStorage()[key];
    },

    setProperty(key, value, module_name) {
        if (module_name) {
            let obj = this.getProperty(module_name);
            obj[key] = value;
            this.setProperty(module_name, obj);
        } else {
            let obj = this.getStorage();
            obj[key] = value;
            window.sessionStorage.setItem(STORAGE_KEY, JSON.stringify(obj));
        }
    },

    clearProperty(key, module_name) {
        let obj = this.getStorage();
        if (module_name) {
            delete obj[module_name][key];
        } else {
            delete obj[key];
        }
        window.sessionStorage.setItem(STORAGE_KEY, JSON.stringify(obj));
    }
}