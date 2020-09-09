/**
 * Vuex-mutations
 */
export default {
    saveUsername(state, username) {
        state.username = username;
    },
    saveCartCount(state, cartCount) {
        state.cartCount = cartCount;
    }
}