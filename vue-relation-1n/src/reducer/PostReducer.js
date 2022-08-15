import { defineStore } from 'pinia'
import { postTypes } from '../constants/actionsType/index'
const DEFAULT_STATE = {
    listPosts: [],
    isFetching: false,
    error: false,
    messageError: null,
    type: ''
}

export const useStore = defineStore({
    id: 'post',
    state: () => DEFAULT_STATE,
    actions: {
        getRequest() {
            postTypes.GET_POSTS_REQUEST
            this.isFetching = true
        },
        getSuccess(payload) {
            // console.log("payload in reducer: ", payload);
            this.listPosts = payload,
                postTypes.GET_POSTS_SUCCESS,
                this.isFetching = false
        },
        getFailure() {
            postTypes.GET_POSTS_FAILURE
        },
        addRequest() {
            postTypes.ADD_POST_REQUEST
            this.isFetching = true
        },
        addSuccess() {
            postTypes.ADD_POST_SUCCESS
            this.isFetching = false
        },
        addFailure() {
            postTypes.ADD_POST_FAILURE
        },
        deleteRequest() {
            postTypes.DELETE_POST_REQUEST
            this.isFetching = true
        },
        deleteSuccess() {
            postTypes.DELETE_POST_SUCCESS
            this.isFetching = false
        },
        deleteFailure() {
            postTypes.DELETE_POST_FAILURE
        },
        updateRequest() {
            postTypes.UPDATE_POST_REQUEST
            this.isFetching = true
        },
        updateSuccess() {
            postTypes.UPDATE_POST_SUCCESS
            this.isFetching = false
        },
        updateFailure() {
            postTypes.UPDATE_POST_FAILURE
        }
    },
})
