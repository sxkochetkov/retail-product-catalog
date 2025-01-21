import axios from "axios";

const REST_API_ROOT_URL = 'http://localhost:8080';
const REST_API_PRODUCT_DIR = REST_API_ROOT_URL + "/products";
const REST_API_SEARCH_DIR = REST_API_ROOT_URL + "/search";

export async function getProducts(page = 0, pageSize = 9) {
    return await axios.get(`${REST_API_PRODUCT_DIR}?page=${page}&pageSize=${pageSize}`);
}

export async function prepopulate() {
    return await axios.get(`${REST_API_ROOT_URL}/config?action=prepopulate`);
}

export async function getProduct(id) {
    return await axios.get(`${REST_API_PRODUCT_DIR}/${id}`);
}

export async function addProduct(product) {
    return await axios.post(REST_API_PRODUCT_DIR, product);
}

export async function udpateProduct(product) {
    return await axios.post(REST_API_PRODUCT_DIR, product);
}

export async function searchProducts(name) {
    return await axios.get(`${REST_API_SEARCH_DIR}?term=${name}`);
}
