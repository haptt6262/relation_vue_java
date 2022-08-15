import { REST_API_METHOD as METHOD, BASE_URL } from '../constants/index'
const API_SCHEMA = {
    POSTS: {
        GET: {
            url: `${BASE_URL}/post`
        },
        ADD: {
            url: `${BASE_URL}/post`,
            method: METHOD.POST
        },
        UPDATE: {
            url: `${BASE_URL}/post/:id`,
            method: METHOD.PUT
        },
        DELETE: {
            url: `${BASE_URL}/post/:id`,
            method: METHOD.DELETE
        }
    },
    COMMENTS: {
        GET: {
            url: `${BASE_URL}/comments`,
            method: METHOD.GET
        },
        ADD: {
            url: `${BASE_URL}/comments`,
            method: METHOD.POST
        },
        UPDATE: {
            url: `${BASE_URL}/comments/:id`,
            method: METHOD.PUT
        },
        DELETE: {
            url: `${BASE_URL}/comments/:id`,
            method: METHOD.DELETE
        },
    },
}
export default API_SCHEMA