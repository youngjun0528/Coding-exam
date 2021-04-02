import axios from "axios";

const state = {
  products: [],
};

const mutations = {
  SET_STORE(state, products) {
    state.products = products;
  },
};

const actions = {
  initStore: ({ commit }) => {
    axios.get("../static/products.json").then((response) => {
      commit("SET_STORE", response.data.products);
    });
  },
};

const getters = {
  products: (state) => state.products,
  getProductById: (state) => (id) => {
    return state.products.filter((product) => product.id === id);
  },
};

export default {
  state,
  getters,
  actions,
  mutations,
};
