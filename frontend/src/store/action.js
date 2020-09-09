/**
 * Vuex-actions
 */
export default {
    saveUsername(context, username) {
        context.commit('saveUsername', username);
    },
    saveCartCount(context, cartCount) {
        context.commit('saveCartCount', cartCount);
    }
}