import { createApi } from '../ultils/helpers/index'
import ApiSchema from './schema'

export const postApi = {
    getPosts: createApi(ApiSchema.POSTS.GET),
    addPost: createApi(ApiSchema.POSTS.ADD),
    deletePost: createApi(ApiSchema.POSTS.DELETE),
    updatePost: createApi(ApiSchema.POSTS.UPDATE)
}
export const commentsApi = {
    getComments: createApi(ApiSchema.COMMENTS.GET),
    addComment: createApi(ApiSchema.COMMENTS.ADD),
    deleteComment: createApi(ApiSchema.COMMENTS.DELETE),
    updateComment: createApi(ApiSchema.COMMENTS.UPDATE)
}