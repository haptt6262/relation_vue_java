import { useStore } from '../reducer/PostReducer'
import { postApi } from '../api'
import { getComments } from './CommentsSaga'

async function getPosts() {
    const actions = useStore()
    // console.log('res saga:')
    await actions.getRequest()
    try {
        let res = await postApi.getPosts()
        await actions.getSuccess(res.data)
    } catch (error) {
        await actions.getFailure(error)
    }
}
async function createNewPost(payload) {
    const actions = useStore()
    // console.log('PAYLOAD IN SAGA: ', payload)
    await actions.addRequest()
    try {
        let res = await postApi.addPost({ name: payload.namePost, mota: payload.description }, null, null)
        await actions.addSuccess()
        await getPosts()
    } catch (error) {
        await actions.addFailure(error)
    }
}
async function deletePost(payload) {
    const actions = useStore()
    // console.log('PAYLOAD IN SAGA: ', payload)
    await actions.deleteRequest()
    try {
        let res = await postApi.deletePost(null, { id: payload }, null)
        await actions.deleteSuccess()
        await getPosts()
        await getComments()

    } catch (error) {
        await actions.deleteFailure(error)
    }
}
async function updatePost(payload) {
    const actions = useStore()
    // console.log('PAYLOAD IN SAGA: ', payload)
    await actions.updateRequest()
    try {
        let res = await postApi.updatePost({ name: payload.namePost, mota: payload.description }, { id: payload.id }, null)
        await actions.updateSuccess()
        await getPosts()
    } catch (error) {
        await actions.updateFailure(error)
    }
}

export {
    getPosts, createNewPost, deletePost, updatePost
}
