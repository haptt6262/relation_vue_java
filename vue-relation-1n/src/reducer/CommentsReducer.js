import { defineStore } from 'pinia'
import { commentsTypes } from '../constants/actionsType/index'
const DEFAULT_STATE = {
    listComments: [],
    isFetching: false,
    error: false,
    messageError: null,
    type: ''
}

export const useCommentsStore = defineStore({
    id: 'comments',
    state: () => DEFAULT_STATE,

    actions: {
        getRequest() {
            commentsTypes.GET_COMMENTS_REQUEST
            this.isFetching = true
        },
        getSuccess(payload) {
            // console.log("payload in reducer: ", payload);
            this.listComments = payload,
                commentsTypes.GET_COMMENTS_SUCCESS,
                this.isFetching = false
        },
        getFailure() {
            commentsTypes.GET_COMMENTS_FAILURE
        },
        addRequest() {
            commentsTypes.ADD_COMMENT_REQUEST
            this.isFetching = true
        },
        addSuccess() {
            commentsTypes.ADD_COMMENT_SUCCESS
            this.isFetching = false
        },
        addFailure() {
            commentsTypes.ADD_COMMENT_FAILURE
        },
        deleteRequest() {
            commentsTypes.DELETE_COMMENT_REQUEST
            this.isFetching = true
        },
        deleteSuccess() {
            commentsTypes.DELETE_COMMENT_SUCCESS
            this.isFetching = false
        },
        deleteFailure() {
            commentsTypes.DELETE_COMMENT_FAILURE
        },
        updateRequest() {
            commentsTypes.UPDATE_COMMENT_REQUEST
            this.isFetching = true
        },
        updateSuccess() {
            commentsTypes.UPDATE_COMMENT_SUCCESS
            this.isFetching = false
        },
        updateFailure() {
            commentsTypes.UPDATE_COMMENT_FAILURE
        }
    },
})
